package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.Bus;


public interface BusService {
     Bus addBus (Bus bus);
     Bus saveBus(Bus bus);
     Bus updateBus(Bus bus,Long id);
     Bus getBusById(Long id);
     List<Bus>getAllBusses();
     Boolean deleteBusById(Long id);
}
