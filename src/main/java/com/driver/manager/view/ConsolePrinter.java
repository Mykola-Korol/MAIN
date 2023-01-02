package com.driver.manager.view;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsolePrinter {

    private InputStream inputStream;

    private ConsolePrinter() {

    }

    public ConsolePrinter(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void logOutput() {

        new Thread(() -> {
            Scanner scanner =
                    new Scanner(inputStream, StandardCharsets.UTF_8);

            while (scanner.hasNextLine()) {
                synchronized (this) {
                    System.out.println((scanner.nextLine()));
                }
            }

            scanner.close();

        }).start();
    }

}
