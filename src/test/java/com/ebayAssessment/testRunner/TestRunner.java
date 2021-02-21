package com.ebayAssessment.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html"},features = {"Features/EbayAddToCartFlow.feature"},glue= "com.ebayAssessment.stepDefinitions")
public class TestRunner 				
{		
	
}	