#Author: Raja Enturi
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Comm Bank Registration
 
  Scenario: Successful registraion with user valid data
    Given 	User Launch Chrome Browser
    And Uesr Opens URL
    When User Clicks On Register Online Now button
   And Page title should be "Registration"
    And User clicks on Advanced Control radio button
    And User clicks on Register for Foreign Exchange checkbox
    And User clicks on Ready Lets Go button
    And User clicks on Next button
    And User enters valid data in Fill up Username textbox "Rajaenturi"
    And User enters valid data in Fill up Password textbox "Test@123"
    And User enters valid data in Fill up Re-enter password textbox "Test@123"
    And User selects Security Question one dropdown "What is your favourite colour?"
    And User Answers Security Question one textbox "Green"
    And User selects Security Question two dropdown  "What country did you first visit on your first overseas trip?"
    And User Answers Security Question two textbox "Australia"
    And User clicks on create account button
    Then user should navigate to service details page "Step 1 - Service details"
