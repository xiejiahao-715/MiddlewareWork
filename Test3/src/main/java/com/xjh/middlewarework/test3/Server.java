package com.xjh.middlewarework.test3;

import com.xjh.middlewarework.test3.service.FlightService;
import com.xjh.middlewarework.test3.service.impl.FlightServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static final int port = 8888;
    public static final String url = "rmi://localhost:"+ port +"/flightService";

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(port);
            FlightService flightService = new FlightServiceImpl();
            Naming.bind(url,flightService);
            System.out.println("FlightService服务已开启，地址为:"+url);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

