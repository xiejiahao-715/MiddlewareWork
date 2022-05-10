package com.xjh.middlewarework.test3.service.impl;

import com.xjh.middlewarework.test3.bean.FlightInfo;
import com.xjh.middlewarework.test3.service.FlightService;
import com.xjh.middlewarework.test3.utils.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightServiceImpl extends UnicastRemoteObject implements FlightService {
    private final static String xmlPath = "FlightINFO.xml";

    public FlightServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<FlightInfo> searchFlightByTime(String time) throws RemoteException {
        String xpathTemplate = "/flightInfos/flightInfo[translate(leaveTime,':','') < translate('%s',':','')]";
        String xpath = String.format(xpathTemplate,time);
        return search(xpath);
    }

    @Override
    public List<FlightInfo> searchFlightByLeaveAirport(String airport) {
        String xpathTemplate = "/flightInfos/flightInfo[leaveAirport = '%s']";
        String xpath = String.format(xpathTemplate,airport);
        return search(xpath);
    }

    private List<FlightInfo> search(String xpath){
        Document document = XmlUtil.getDocument(xmlPath);
        NodeList nodeList = XmlUtil.getNodeList(document,xpath);
        List<FlightInfo> flightInfos = new ArrayList<>();
        if(nodeList != null){
            for(int i = 0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                FlightInfo flightInfo = castNode(node,FlightInfo.class);
                if(flightInfo != null){
                    flightInfos.add(flightInfo);
                }
            }
        }
        return flightInfos;
    }

    // 利用反射将Node对象(属于xml中的flightInfo节点)转换为FlightInfo对象
    private  <T> T castNode(Node node, Class<T> clazz){
        NodeList attrs = node.getChildNodes();
        try {
            T obj = clazz.getConstructor().newInstance();
            Map<String,Field> fieldMap = new HashMap<>();
            // 将Field对象转储到HashMap中便于查找
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                fieldMap.put(field.getName(),field);
            }
            for(int i=0;i< attrs.getLength();i++){
                Node attr= attrs.item(i);
                // 忽略文本节点
                if(attr.getNodeName().equals("#text")){
                    continue;
                }
                Field field = fieldMap.get(attr.getNodeName());
                if(field != null){
                    // 存在对应字段设置值
                    field.setAccessible(true);
                    field.set(obj,attr.getTextContent());
                }
            }
            return obj;
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            System.err.println("转换Node节点成"+clazz.getName()+"对象失败");
            System.err.println(e.getMessage());
            return null;
        }
    }
}
