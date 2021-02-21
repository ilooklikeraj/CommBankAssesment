Feature: Ebay application automation
 
  Scenario: Verify item added to cart is displayed in the cart
  
    Given 	User Launch Chrome Browser
    When Uesr Opens URL
    Then verify that user successfully navigated to ebay home page
    And User serach for "Bike"
    And User clicks on search button
    And User clicks on the first bike item in the list and selects appropriate size
    And User clicks on add to cart button
    When User clicks on the add to cart icon
    Then User should able to see product added successfully to the cart
    
  Scenario: Verify error messages when logging in without username or password
  
    Given 	User Launch Chrome Browser
    When Uesr Opens URL
    Then verify that user successfully navigated to ebay home page
    And User clicks My Ebay located on the top right corner
    Then User should see sign in page should be dispalyed
    And User clicks on Continue button leaving the username or email blank
    Then User should get an appropriate error message
