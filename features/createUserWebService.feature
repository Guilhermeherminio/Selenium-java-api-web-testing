@regression_api
Feature: Title of your feature
  I want to use this template for my feature file

  @create_user_api @TC002
  Scenario: Validate that the user is able to add a new user with a job
    Given I use user creation service
    When I set name Toy
    When I set job singer
    When I create the user
    Then I validate the user and job was created with success

  @delete_user_api @TC003
  Scenario: Validate that the user is able to delete a user
    Given I use user creation service
    When I set name Toy
    When I set job singer
    When I delete the user
    Then I validate the user and job was deleted with success

  @new_register_without_password @TC004
  Scenario: Validate that the user is able to create a new register with success
    Given I use register creation service
    When I set e-mail challenge@automation.com
    When I create a register
    Then I validate the register was created without success
