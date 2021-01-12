package com.commBank.stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.commBank.PageObjects.RegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps extends BaseClass {
Properties prop;
	@Given("^User Launch Chrome Browser$")
	public void user_Launch_Chrome_Browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ilook\\eclipse-workspace\\commBankAssesment\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		registrationPage = new RegistrationPage(driver);
	}

	@Given("^Uesr Opens URL$")
	public void uesr_Opens_URL() throws Throwable {
		prop=readProperties();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}


	@When("^User Clicks On Register Online Now button$")
	public void user_Clicks_On_Register_Online_Now_button() throws Throwable {
		driver.switchTo().frame(driver.findElement(By.id("frmRegistration")));
		registrationPage.clickRegOnlineNowBtn();

	}

	@When("^Page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String title) throws Throwable {
		registrationPage.getRegistrationPageTitleAndVerify(title);
	}

	@When("^User clicks on Advanced Control radio button$")
	public void user_clicks_on_Advanced_Control_radio_button() throws Throwable {
		registrationPage.clickAdvncedCntrlRadioBtn();
	}

	@When("^User clicks on Register for Foreign Exchange checkbox$")
	public void user_clicks_on_Register_for_Foreign_Exchange_checkbox() throws Throwable {
		registrationPage.clickOnRegForForeignExchngChkBx();
	}

	@When("^User clicks on Ready Lets Go button$")
	public void user_clicks_on_Ready_Lets_Go_button() throws Throwable {
		registrationPage.clickLetsReadyGoRadioBtn();
	}

	@When("^User clicks on Next button$")
	public void user_clicks_on_Next_button() throws Throwable {
		registrationPage.clickNextBtn();
	}

	@When("^User enters valid data in Fill up Username textbox \"([^\"]*)\"$")
	public void user_enters_valid_data_in_Fill_up_Username_textbox(String userName) throws Throwable {

		registrationPage.setUserNameTxt(userName + randomString());
	}

	@When("^User enters valid data in Fill up Password textbox \"([^\"]*)\"$")
	public void user_enters_valid_data_in_Fill_up_Password_textbox(String password) throws Throwable {
		registrationPage.setPasswordTxt(password);
	}

	@When("^User enters valid data in Fill up Re-enter password textbox \"([^\"]*)\"$")
	public void user_enters_valid_data_in_Fill_up_Re_enter_password_textbox(String reEnterPassword) throws Throwable {
		registrationPage.setReEnterPasswordTxt(reEnterPassword);
	}

	@When("^User selects Security Question one dropdown \"([^\"]*)\"$")
	public void user_selects_Security_Question_one_dropdown(String securityQuestion1) throws Throwable {
		registrationPage.selectSecurityQuestion1DropDown(securityQuestion1);
	}

	@When("^User Answers Security Question one textbox \"([^\"]*)\"$")
	public void user_Answers_Security_Question_one_textbox(String securityQuestion1Answer) throws Throwable {
		registrationPage.setSelectSecurityQuestion1Answer(securityQuestion1Answer);
	}

	@When("^User selects Security Question two dropdown  \"([^\"]*)\"$")
	public void user_selects_Security_Question_two_dropdown(String securityQuestion2) throws Throwable {
		registrationPage.selectSecurityQuestion2DropDown(securityQuestion2);
	}

	@When("^User Answers Security Question two textbox \"([^\"]*)\"$")
	public void user_Answers_Security_Question_two_textbox(String securityQuestion2Answer) throws Throwable {
		registrationPage.setSelectSecurityQuestion2Answer(securityQuestion2Answer);
	}

	@When("^User clicks on create account button$")
	public void user_clicks_on_create_account_button() throws Throwable {
		registrationPage.clickCreateAccountButton();
	}

	@Then("^user should navigate to service details page \"([^\"]*)\"$")
	public void user_should_navigate_to_service_details_page(String successfulRegistraionVerify) throws Throwable {
		registrationPage.getServiceDetailsPageTitleAndVerify(successfulRegistraionVerify);
	}

}
