package org.example.base;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;


public class TestLogger implements ITestListener {
    private String clampParameter(Object param) {
        String fullString = String.valueOf(param);
        return fullString.length() > 40 ? fullString.substring(0, 37) + "...]" : fullString;
    }

    private String formatParameters(ITestResult result) {
        Object[] parameters = result.getParameters();
        if (parameters.length == 0) {
            return "";
        }
        String fullParamString = Arrays.toString(parameters);
        return " | Parameters: " + clampParameter(fullParamString);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[PASS] " + result.getMethod().getMethodName() + formatParameters(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[FAILURE] " + result.getMethod().getMethodName() + formatParameters(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[SKIPPED] " + result.getMethod().getMethodName() + formatParameters(result));
    }
}
