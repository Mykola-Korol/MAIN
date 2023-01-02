package com.driver.manager;

import com.driver.manager.enums.LocalMachineDeviceClass;
import com.driver.manager.exception.InvalidDriverPathValueException;
import com.driver.manager.service.DriverServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidDriverPathValueException {

        DriverServiceImpl driverService =
                new DriverServiceImpl();

        //Список установленных драйверов
      driverService.getEnumDrivers();

        //Добавление нового драйвера (Путь к файлу .inf обязателен)
       driverService.addNewDriver(
                "D:\\drive\\btmaux.inf"
        );

        //Удаление драйвера (Путь к файлу .inf обязателен)
       driverService.deleteExistedDriver(
                "D:\\drive\\btmaux.inf"
       );

        //Список всех поключенных к системе девайсов
      driverService.getConnectedDevices();

        //Список подключенных девайсов указанной категории. (Задаётся через LocalMachineDeviceClass)
      driverService.getConnectedDevices(LocalMachineDeviceClass.VIDEOCARD);
    }
}
