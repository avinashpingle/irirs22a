package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", 
				 glue = { "com.iris22a.stepdefinition","com.iris22a.config" }, 
				 dryRun = false)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
