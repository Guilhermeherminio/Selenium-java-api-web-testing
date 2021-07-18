@regression_web
Feature: Validate the product subscription page
  I want to validate the product subscription page

  @product_subscription_configurator @TC001
  Scenario: Validate the product price for a full special support plan for 6 months simulation
    Given I open Chrome and launch the application
    When I select type Special
    When I select support plan Full
    When I write monthly duration of 6
    When I click in calculate price button
    Then I validate price is 2249.10 $
