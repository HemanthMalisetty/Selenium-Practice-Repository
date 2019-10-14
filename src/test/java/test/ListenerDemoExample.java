package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemoExample implements ITestListener {
    @Override
    public void onTestStart(ITestResult arg0) {
        System.out.println("TestCase started====" +arg0.toString());
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        System.out.println("Congrates Testcase has been passed===="+ arg0.toString());
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        System.out.println("Screen shot captured====="+arg0.toString());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext arg0) {

    }

    @Override
    public void onFinish(ITestContext arg0) {

    }
}
