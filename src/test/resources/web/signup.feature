@signup
Feature: Sign up

  Scenario Outline : user sign up account Demoblaze
    Given user on the home page
    When user click Sign up
    And user input username "<username>"
    And user input password "<password>"
    And user click Sign Up
    Then user show message "<expectedMessage>"

    Examples:
      | username   | password | expectedMessage          |
      | ekapermary | welcome  | Sign up successful.      |
      | test123    | 12345    | This user already exist. |