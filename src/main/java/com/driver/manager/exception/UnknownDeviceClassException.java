package com.driver.manager.exception;

import java.io.IOException;

public class UnknownDeviceClassException extends IOException {

    public UnknownDeviceClassException(String message) {
        super(message);
    }
}
