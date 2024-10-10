@tag
Feature: Error validation
  I want to use this template for my feature file

  

  @ErrorHandling
  Scenario Outline: 
    Given I landed on ecommerce page
    When I want to login in with username <name> and password <pass>
    Then "Incorrect email or password." message is displayed on login page

    Examples: 
      | name               | pass      |
      | antony@yopmail.com |Welcome@13| 