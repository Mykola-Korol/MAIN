package com.driver.manager.enums;

public enum LocalMachineDeviceClass {

    PROCESSOR("Processor"),
    VIDEOCARD("Display"),
    MOUSE("Mouse"),
    KEYBOARD("Keyboard"),
    SYSTEM("System"),
    USB("Usb");

    private final String deviceConsoleQuery;

    LocalMachineDeviceClass(String deviceConsoleQuery) {
        this.deviceConsoleQuery = deviceConsoleQuery;
    }

    public String getDeviceConsoleQuery() {
        return deviceConsoleQuery;
    }
}
