package com.xjh.middlewarework.test3.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FlightInfo implements Serializable {
    private String id;
    private String leaveAirport;
    private String arriveAirport;
    private String airplaneType;
    private String leaveTime;
    private String arriveTime;
    private String status;
}
