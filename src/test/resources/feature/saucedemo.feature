@Tests
Feature: Buy product at saucedemo.com
  As a user of saucedemo.com
  I enter saucedemo.com
  To buy a product

  Background: Login to page saucedemo
    Given The "user" enters the site
    And User wants to login in saucedemo page


  @Successful_Purchase
  Scenario Outline: successful purchase of a product
    When Buy a product
      |product|firstname|lastname|postalCode|
      |<product>|<firstname>|<lastname>|<postalCode>|
    Then Verify that the purchase successful "Thank you for your order!"
    Examples:
      |product|firstname|lastname|postalCode|
   |Sauce Labs Backpack,Sauce Labs Bike Light|Cristian   |Hernandez   |55450|