package com.commBank.PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.commBank.utilities.WaitHelper;

public class RegistrationPage {
	public WebDriver driver;
	static WaitHelper waitHelper;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Register online now ')]")
	@CacheLookup
	WebElement regOnlineNowButton;

	@FindBy(xpath = "//input[@id='rdoAdvanced']")
	@CacheLookup
	WebElement advCntrlRdoButton;

	@FindBy(xpath = "//h2[contains(text(),'Registration')]")
	@CacheLookup
	WebElement regPageTitleVerify;

	@FindBy(xpath = "//input[@id='chkMMFXSelected']")
	@CacheLookup
	WebElement regFrForeignExch;

	@FindBy(xpath = "//input[@id='btnNext']")
	@CacheLookup
	WebElement letsReadyGoBtn;

	@FindBy(xpath = "//input[@id='btnSubmit']")
	@CacheLookup
	WebElement nextBtn;

	@FindBy(xpath = "//input[@id='txtUserName']")
	@CacheLookup
	WebElement userNameTxt;

	@FindBy(xpath = "//input[@id='txtPassword']")
	@CacheLookup
	WebElement passwordTxt;

	@FindBy(xpath = "//input[@id='txtReenterPassword']")
	@CacheLookup
	WebElement reEnterPasswordTxt;

	@FindBy(xpath = "//select[@id='ddlSecret1']")
	@CacheLookup
	WebElement selectSecQues1DropDown;

	@FindBy(xpath = "//input[@id='txtSecret1']")
	@CacheLookup
	WebElement selectSecQues1AnsTxt;

	@FindBy(xpath = "//select[@id='ddlSecret2']")
	@CacheLookup
	WebElement selectSecQues2DropDown;

	@FindBy(xpath = "//input[@id='txtSecret2']")
	@CacheLookup
	WebElement selectSecQues2AnsTxt;

	@FindBy(xpath = "//input[@id='btnSubmit']")
	@CacheLookup
	WebElement createAcountBtn;

	@FindBy(xpath = "//h2[contains(text(),'Step 1 - Service details')]")
	@CacheLookup
	WebElement verifySuccessfulRegistration;

	public void clickRegOnlineNowBtn() {
		highlight(driver, regOnlineNowButton);
		regOnlineNowButton.click();
	}

	public void clickAdvncedCntrlRadioBtn() {
		highlight(driver, advCntrlRdoButton);
		advCntrlRdoButton.click();
	}

	public void clickLetsReadyGoRadioBtn() {
		highlight(driver, letsReadyGoBtn);
		letsReadyGoBtn.click();
	}

	public void clickOnRegForForeignExchngChkBx() {
		highlight(driver, regFrForeignExch);
		regFrForeignExch.click();
	}

	public void clickNextBtn() {
		highlight(driver, nextBtn);
		nextBtn.click();
	}

	
	public void getRegistrationPageTitleAndVerify(String expectedTitle) {
		highlight(driver, regPageTitleVerify);
		assertEquals(expectedTitle, regPageTitleVerify.getText());
	}
	public void setUserNameTxt(String userName) {
		highlight(driver, userNameTxt);
		userNameTxt.clear();
		userNameTxt.sendKeys(userName);
	}

	public void setPasswordTxt(String password) {
		highlight(driver, passwordTxt);
		passwordTxt.clear();
		passwordTxt.sendKeys(password);
	}

	public void setReEnterPasswordTxt(String reEnterPassword) {
		highlight(driver, reEnterPasswordTxt);
		reEnterPasswordTxt.clear();
		reEnterPasswordTxt.sendKeys(reEnterPassword);
	}

	public void selectSecurityQuestion1DropDown(String value) {
		highlight(driver, selectSecQues1DropDown);
		Select question1 = new Select(selectSecQues1DropDown);
		question1.selectByVisibleText(value);
	}

	public void setSelectSecurityQuestion1Answer(String securityQuestionOneAnswer) {
		highlight(driver, selectSecQues1AnsTxt);
		selectSecQues1AnsTxt.clear();
		selectSecQues1AnsTxt.sendKeys(securityQuestionOneAnswer);
	}

	public void selectSecurityQuestion2DropDown(String value) {
		highlight(driver, selectSecQues2DropDown);
		Select question2 = new Select(selectSecQues2DropDown);
		question2.selectByVisibleText(value);
	}

	public void setSelectSecurityQuestion2Answer(String securityQuestionTwoAnswer) {
		highlight(driver, selectSecQues2AnsTxt);
		selectSecQues2AnsTxt.clear();
		selectSecQues2AnsTxt.sendKeys(securityQuestionTwoAnswer);
	}

	public void clickCreateAccountButton() {
		highlight(driver, createAcountBtn);
		createAcountBtn.click();
	}

	public void getServiceDetailsPageTitleAndVerify(String expectedTitle) {
		highlight(driver, verifySuccessfulRegistration);
		assertEquals(expectedTitle, verifySuccessfulRegistration.getText());
	}

	public static void highlight(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: grey; border: 2px solid red;');", ele);
	}
}
