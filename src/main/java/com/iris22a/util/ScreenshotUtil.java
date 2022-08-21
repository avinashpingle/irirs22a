package com.iris22a.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.iris22a.config.TestBase;

import io.qameta.allure.Attachment;

public class ScreenshotUtil implements ITestListener{

	@Attachment(value = "Screenshot", type = "image/png")
	@Override
	public void onTestFailure(ITestResult result) {
		TestBase tb = new TestBase();
		TakesScreenshot ts = (TakesScreenshot)tb.thread.get();
		byte[] data = ts.getScreenshotAs(OutputType.BYTES);
		try {
			FileUtils.writeByteArrayToFile(new File("/screenshots/sc1.png"), data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
