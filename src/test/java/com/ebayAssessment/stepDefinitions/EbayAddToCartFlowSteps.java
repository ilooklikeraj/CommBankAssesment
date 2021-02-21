package com.ebayAssessment.stepDefinitions;

import java.util.Properties;

import com.ebayAssessment.PageObjects.EbayAddToCartFlowPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EbayAddToCartFlowSteps extends BaseClass {
	Properties prop;

	@Given("^User Launch Chrome Browser$")
	public void user_Launch_Chrome_Browser() throws Throwable {

		ebayAddToCartFlowPage = new EbayAddToCartFlowPage(Hooks.driver);
	}

	@Given("^Uesr Opens URL$")
	public void uesr_Opens_URL() throws Throwable {
		prop = readProperties();
		Hooks.driver.get(prop.getProperty("url"));
		Hooks.driver.manage().window().maximize();
	}

	@Then("^verify that user successfully navigated to ebay home page$")
	public void verify_that_user_successfully_navigated_to_ebay_home_page() throws Throwable {
		ebayAddToCartFlowPage.verifyEbayLogo();
	}

	@Then("^User serach for \"([^\"]*)\"$")
	public void user_serach_for(String bike) throws Throwable {
		ebayAddToCartFlowPage.searchBike(bike);

	}

	@Then("^User clicks on search button$")
	public void user_clicks_on_search_button() throws Throwable {
		ebayAddToCartFlowPage.clickOnSerachButton();
	}

	
	@Then("^User clicks on the first bike item in the list and selects appropriate size$")
	public void user_clicks_on_the_first_bike_item_in_the_list_and_selects_appropriate_size() throws Throwable {
		ebayAddToCartFlowPage.verifySearchResultsForBikeAndClickOnFirstItem();
		ebayAddToCartFlowPage.chooseDesiredSize();
	}

	@Then("^User clicks on add to cart button$")
	public void user_clicks_on_add_to_cart_button() throws Throwable {
		ebayAddToCartFlowPage.clickOnAddToCartButton();
	}

	@When("^User clicks on the add to cart icon$")
	public void user_clicks_on_the_add_to_cart_icon() throws Throwable {
		ebayAddToCartFlowPage.clickOnAddToCartIcon();
	}

	@Then("^User should able to see product added successfully to the cart$")
	public void user_should_able_to_see_product_added_successfully_to_the_cart() throws Throwable {
		ebayAddToCartFlowPage.verifyProductInCheckOutPage();
	}

	@Then("^User clicks My Ebay located on the top right corner$")
	public void user_clicks_My_Ebay_located_on_the_top_right_corner() throws Throwable {
		ebayAddToCartFlowPage.clickOnMyEbayLink();
	}

	@Then("^User should see sign in page should be dispalyed$")
	public void user_should_see_sign_in_page_should_be_dispalyed() throws Throwable {
		ebayAddToCartFlowPage.verifyEbayLogoInSignPage();
	}

	@Then("^User clicks on Continue button leaving the username or email blank$")
	public void user_clicks_on_Continue_button_leaving_the_username_or_email_blank() throws Throwable {
		ebayAddToCartFlowPage.clickOnContinueButtonInSignIn();
	}

	@Then("^User should get an appropriate error message$")
	public void user_should_get_an_appropriate_error_message() throws Throwable {
		ebayAddToCartFlowPage.verifyErrorTextInSignIn();
	}

}
