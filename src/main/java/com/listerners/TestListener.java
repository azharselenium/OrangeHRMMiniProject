package com.listerners;
import com.base.BaseTest;
import com.utils.*;
import com.aventstack.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private ExtentReports extent = ExtentManager.getReport();
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test =
		extent.createTest(result.getMethod().getMethodName());
		StepLogger.setTest(test);
		Log.logger.info("TEST STARTED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		StepLogger.pass("Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath =
		ScreenshotUtil.captureScreenshot(BaseTest.getDriver(),result.getMethod().getMethodName());
		StepLogger.fail("Test Failed: " + result.getThrowable().getMessage());
		StepLogger.info("Screenshot captured");
		StepLogger.fail("Refer screenshot below");
		StepLogger.info("Screenshot Path: " + screenshotPath);
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		Log.logger.info("TEST EXECUTION FINISHED");
	}
}