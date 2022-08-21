package com.iris22a.config;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.iris22a.keywords.UIKeyword;
import com.iris22a.util.Environment;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {
	
	public WebDriver driver;
	public ThreadLocal<WebDriver> thread = new ThreadLocal<>();
	private static final Logger log = Logger.getLogger(TestBase.class);
	
	
	@Before
	public void setUp() throws Exception {
		String browserName = Environment.BROWSER;
		if(browserName==null) {
			browserName = "Chrome";
		}
		if(browserName.isEmpty()) {
			browserName = "Chrome";
			log.info("Setting default browser as chrome");
		}
		this.driver = UIKeyword.openBrowser(browserName);
		thread.set(this.driver);
	}
	
	@After
	public void tearDown() throws Exception {
		thread.get().close();
		log.info("Browser is closed successfully");
	}
}
