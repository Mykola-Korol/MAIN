package com.driver.manager.service;

import com.driver.manager.enums.LocalMachineDeviceClass;
import com.driver.manager.exception.InvalidDriverPathValueException;
import com.driver.manager.exception.UnknownDeviceClassException;

public interface DriverService {

    void getEnumDrivers();

    void addNewDriver(String driverPath) throws InvalidDriverPathValueException;

    void deleteExistedDriver(String driverPath) throws InvalidDriverPathValueException;

    void getConnectedDevices();

    void getConnectedDevices(LocalMachineDeviceClass deviceClass) throws UnknownDeviceClassException;
}
