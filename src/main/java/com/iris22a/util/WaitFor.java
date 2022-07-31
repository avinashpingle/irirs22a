package com.iris22a.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.iris22a.keywords.UIKeyword;

public class WaitFor {

	private static FluentWait<WebDriver> wait = null;
	
	static{
		wait= new FluentWait<WebDriver>(UIKeyword.driver);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("Wait is finished and element is not loaded or available");
		
	}
	
	public static void elemtnToBePresent(By locator) {
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void elemtnToBePresent(String locatorType, String locatorValue) {
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
	}

	public static void elementToBeClickable(WebElement element) {
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

	public static void time(int durationInSeconds) {
		long startTime = System.currentTimeMillis();
		long endTime = startTime+(durationInSeconds*1000);
		while(startTime<=endTime) {
			startTime = System.currentTimeMillis();
		}
	}
	
}
