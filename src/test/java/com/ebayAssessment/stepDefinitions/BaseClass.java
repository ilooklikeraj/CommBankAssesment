package com.ebayAssessment.stepDefinitions;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import com.ebayAssessment.PageObjects.EbayAddToCartFlowPage;
import com.ebayAssessment.utilities.WaitHelper;

public class BaseClass {
	public WebDriver driver;
	WaitHelper waitHelper;
	public EbayAddToCartFlowPage ebayAddToCartFlowPage;
	
	
	public static Properties readProperties() throws Exception {
		Properties prop = new Properties();
		String fileName = System.getProperty("user.dir")+"\\Config/Config.properties";
		InputStream is = null;
		try {
		    is = new FileInputStream(fileName);
		} catch (FileNotFoundException ex) {
		    throw new Exception(ex);
		}
		try {
		    prop.load(is);
		} catch (IOException ex) {
			throw new Exception(ex);
		}
		return prop;
	}
}
