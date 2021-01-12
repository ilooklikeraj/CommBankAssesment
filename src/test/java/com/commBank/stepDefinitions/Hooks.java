package com.commBank.stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
	protected static WebDriver driver;
	public static WebDriverWait wait;
	
	@Before public void setUp(){ 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	   } 
	
	@After public void tearDown(Scenario scenario){ 
		String screenshotName=scenario.getName().replaceAll("", "_");
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			//scenario.att
		}
		driver.quit();
	   } 

	
}
