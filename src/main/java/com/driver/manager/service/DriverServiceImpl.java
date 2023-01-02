package com.driver.manager.service;

import com.driver.manager.view.ConsolePrinter;
import com.driver.manager.enums.LocalMachineDeviceClass;
import com.driver.manager.exception.InvalidDriverPathValueException;
import com.driver.manager.exception.UnknownDeviceClassException;

import java.io.IOException;

public final class DriverServiceImpl implements DriverService {

    private Process process;

    private ConsolePrinter consolePrinter;

    private static final String GET_ALL_DRIVERS =
            "cmd /c chcp 861 && pnputil /enum-drivers";

    private static final String INSTALL_NEW_DRIVER =
            "cmd /c chcp 861 && pnputil /add-driver \"%s\" /install";

    private static final String DELETE_DRIVER =
            "cmd /c chcp 861 && pnputil /delete-driver \"%s\" /uninstall";

    private static final String GET_CONNECTED_DEVICES =
            "cmd /c chcp 861 && pnputil /enum-devices /connected";

    private static final String GET_CONNECTED_DEVICES_BY_CLASS =
            "cmd /c chcp 861 && pnputil /enum-devices /class %s /connected";

    public void getEnumDrivers() {

        try {

            process = Runtime.getRuntime().exec(GET_ALL_DRIVERS);

            consolePrinter =
                    new ConsolePrinter(process.getInputStream());

            consolePrinter.logOutput();

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.getLocalizedMessage();
        } finally {
            process.destroy();
        }
    }

    public void addNewDriver(String driverPath) throws InvalidDriverPathValueException {

        String resultAppendingQuery;

        if (driverPath.isBlank() || !(driverPath.contains(".inf"))) {
            throw new InvalidDriverPathValueException ("Invalid driver path or driver format \".inf\" not found!");
        } else {
            resultAppendingQuery = String.format(INSTALL_NEW_DRIVER, driverPath);
        }

        try {

            process = Runtime.getRuntime().exec(resultAppendingQuery);

            consolePrinter =
                    new ConsolePrinter(process.getInputStream());
            consolePrinter.logOutput();

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.getLocalizedMessage();
        } finally {
            process.destroy();
        }
    }

    public void deleteExistedDriver(String driverPath) throws InvalidDriverPathValueException {

        String resultDeletingQuery;

        if (driverPath.isBlank() || !(driverPath.contains(".inf"))) {
            throw new InvalidDriverPathValueException("Invalid driver path or driver format \".inf\" not found!");
        } else {
            resultDeletingQuery = String.format(DELETE_DRIVER, driverPath);
        }

        try {

            process = Runtime.getRuntime().exec(resultDeletingQuery);

            consolePrinter =
                    new ConsolePrinter(process.getInputStream());
            consolePrinter.logOutput();

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.getLocalizedMessage();
        } finally {
            process.destroy();
        }
    }

    public void getConnectedDevices() {

        try {

            process = Runtime.getRuntime().exec(GET_CONNECTED_DEVICES);

            consolePrinter =
                    new ConsolePrinter(process.getInputStream());
            consolePrinter.logOutput();

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.getLocalizedMessage();
        } finally {
            process.destroy();
        }
    }

    public void getConnectedDevices(LocalMachineDeviceClass deviceClass) throws UnknownDeviceClassException {

        String resultDevicesByClassQuery;

        if (deviceClass == null) {
            throw new UnknownDeviceClassException("Cannot find setted driver class!");
        } else {
            resultDevicesByClassQuery =
                    String.format(GET_CONNECTED_DEVICES_BY_CLASS, deviceClass.getDeviceConsoleQuery());
        }

        try {

            process = Runtime.getRuntime().exec(resultDevicesByClassQuery);

            consolePrinter =
                    new ConsolePrinter(process.getInputStream());
            consolePrinter.logOutput();

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.getLocalizedMessage();
        } finally {
            process.destroy();
        }
    }

}
