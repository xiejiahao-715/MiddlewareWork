package com.xjh.middlewarework.test3.service;

import com.xjh.middlewarework.test3.bean.FlightInfo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FlightService extends Remote {
    List<FlightInfo> searchFlightByLeaveAirport(String airport) throws RemoteException;

    List<FlightInfo> searchFlightByTime(String time) throws RemoteException;
}

