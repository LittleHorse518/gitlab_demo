package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class ExceptionMethod {

    //受检异常
    public void readFromFile(String filePath) throws FileNotFoundException {
        if (filePath == null || filePath.isEmpty()) {
            throw new FileNotFoundException("Invalid file path");
        }
    }

    //非受检异常
    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        return numerator / denominator;
    }

    //try-catch-finally
    public void processFile(String filePath) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            // 处理文件的代码...
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }

    //多个catch的情况
    public void performAction(int value) {
        try {
            if (value < 0) {
                throw new IllegalArgumentException("Value cannot be negative");
            }
            // 执行某些操作...
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
