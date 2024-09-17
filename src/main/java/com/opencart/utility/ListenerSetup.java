package com.opencart.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSetup implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Execution Started" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Execution Completed" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Utility.getScreenshotMethod(result.getName());
		System.out.println("Test EXecution Failure" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Execution Skipped" + result.getName());	
	}
}
