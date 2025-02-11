package org.example.base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TestLogger implements ITestListener {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String timestamp() {
        return "[" + LocalDateTime.now().format(formatter) + "]";
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(timestamp() + " PASS: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println((timestamp() + " FAILURE: " + result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println((timestamp() + " SKIPPED: " + result.getMethod().getMethodName()));
    }
}
