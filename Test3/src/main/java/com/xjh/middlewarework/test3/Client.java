package com.xjh.middlewarework.test3;

import com.xjh.middlewarework.test3.service.FlightService;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            FlightService flightService = (FlightService) Naming.lookup(Server.url);
            System.out.println("获取出发地为北京的航班");
            flightService.searchFlightByLeaveAirport("北京").forEach(System.out::println);
            System.out.println("获取出发时间早于02:00的航班");
            flightService.searchFlightByTime("02:00").forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

