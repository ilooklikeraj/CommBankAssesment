package com.ebayAssessment.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ebayAssessment.utilities.WaitHelper;

public class EbayAddToCartFlowPage {
	public WebDriver driver;
	WaitHelper waitHelper;

	public EbayAddToCartFlowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='gh-logo']")
	@CacheLookup
	WebElement verifyEbayLogo;

	@FindBy(xpath = "//*[@id='gh-ac']")
	@CacheLookup
	WebElement searchBike;

	@FindBy(xpath = "//*[@id='gh-btn']")
	@CacheLookup
	WebElement clickOnSearchButton;

	@FindBy(xpath = "//*[@id='srp-river-results']/ul/li[1]")
	@CacheLookup
	WebElement verifySearchResultsForBike;
	
	@FindBy(xpath = "//*[@id='srp-river-results']/ul/li[1]/div/div[2]/a/h3")
	@CacheLookup
	WebElement clickOnFirstSearchResult;
	
	
	
	@FindBy(xpath = "//*[@id='msku-sel-1']")
	@CacheLookup
	WebElement chooseDesiredSize;
	
	@FindBy(xpath = "//*[@id='isCartBtn_btn']")
	@CacheLookup
	WebElement addtoCartButton;
	
	@FindBy(xpath = "//button[contains(text(),'No thanks')]")
	@CacheLookup
	WebElement noThanksButton;
	
	
	
	@FindBy(xpath = "//*[@id='gh-minicart-hover']")
	@CacheLookup
	WebElement addToCartIcon;
	
	@FindBy(xpath = "//*[@id='mainContent']/div/div[3]/div[1]/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[1]/div/div/img")
	@CacheLookup
	WebElement verifyProductInCheckOutPageafterClickOnCartIcon;
	
	@FindBy(xpath = "//a[@title='My eBay']")
	@CacheLookup
	WebElement clickOnMyEbay;
	
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	@CacheLookup
	WebElement clickOnVerifyYourSelfChkBx;
	
	@FindBy(xpath = "//*[@id='gh-logo']")
	@CacheLookup
	WebElement verifyEbayLogoInSignINPage;
	
	@FindBy(xpath = "//*[@id='signin-continue-btn']")
	@CacheLookup
	WebElement clickOnContinueBtn;
	
	@FindBy(xpath = "//p[contains(text(),'not a match.')]")
	@CacheLookup
	WebElement verifyErrorText;
	
	@FindBy(xpath = "//div[text()='Please verify yourself']")
	@CacheLookup
	WebElement verifyCaptchaPage;
	
	@FindBy(xpath = "//div[@class='target-icaptcha-slot']/div/div/iframe")
	@CacheLookup
	WebElement captchaFrame;	
	
	

	public void verifyEbayLogo() {
		highlight(driver, verifyEbayLogo);
	}

	public void searchBike(String bike) {
		highlight(driver, searchBike);
		searchBike.clear();
		searchBike.sendKeys(bike);
	}

	public void clickOnSerachButton() {
		highlight(driver, clickOnSearchButton);
		clickOnSearchButton.click();
	}
	
	

	public void verifySearchResultsForBikeAndClickOnFirstItem() {
		highlight(driver, verifySearchResultsForBike);
		verifySearchResultsForBike.click();
		clickOnFirstSearchResult.click();
	}
	
	public void chooseDesiredSize() {
		highlight(driver, chooseDesiredSize);
		Select chooseDesireSize=new Select(chooseDesiredSize);
		chooseDesireSize.selectByIndex(1);
	}
	
	
	public void clickOnAddToCartButton() {
		highlight(driver, addtoCartButton);
		addtoCartButton.click();
		noThanksButton.click();
	}
	
	public void clickOnAddToCartIcon() {
		highlight(driver, addToCartIcon);
		addToCartIcon.click();
	}
	
	public void verifyProductInCheckOutPage() {
		highlight(driver, verifyProductInCheckOutPageafterClickOnCartIcon);
	}
	
	public void clickOnMyEbayLink() throws InterruptedException {
		highlight(driver, clickOnMyEbay);
		clickOnMyEbay.click();
		Thread.sleep(5000);
		
		if(verifyCaptchaPage.isDisplayed()) {
			driver.switchTo().frame(captchaFrame);
			highlight(driver, clickOnVerifyYourSelfChkBx);
			clickOnVerifyYourSelfChkBx.click();
			driver.switchTo().parentFrame();
		}
		
	}

	public void verifyEbayLogoInSignPage() throws InterruptedException {
		Thread.sleep(2000);
		highlight(driver, verifyEbayLogoInSignINPage);
	}
	
	public void verifyErrorTextInSignIn() {
		highlight(driver, verifyErrorText);
	}
	
	public void clickOnContinueButtonInSignIn() throws InterruptedException {
		Thread.sleep(5000);
		highlight(driver, clickOnContinueBtn);
		clickOnContinueBtn.click();
	}
	
	public static void highlight(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: grey; border: 2px solid red;');", ele);
	}

}
