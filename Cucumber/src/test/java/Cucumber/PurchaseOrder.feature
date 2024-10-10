
@tag
Feature: Purchasing an order from an ecommerce site
  I want to use this template for my feature file

  Background:
  Given I landed on ecommerce page

  @Regression
  Scenario Outline: 
    Given I want to login in with username <name> and password <pass>
    When I add the product <productname> to the cart
    And I checkout the product <productname> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name               | pass      | productname   |
      | antony@yopmail.com |Welcome@123| IPHONE 13 PRO |
      
