@Login
Feature: Login ke Demoblaze

  @valid-Login
  Scenario: User success login website
    Given user open the home page Demoblaze
    When user click Log in
    And user input "ekapermary" as username
    And user input "welcome" as password
    Then user will redirect to home page

  @invalid-Login
  Scenario: User failed login to website (wrong password)
    Given user open the home page Demoblaze
    When user click Log in
    And user input "ekapermary" as username
    And user input "12345" as password
    Then system show message "Wrong password."

  @invalid-Login
  Scenario: User failed login to webstite (username is not registered)
    Given user open the home page Demoblaze
    When user click Log in
    And user input "test123" as username
    And user input "12345" as password
    Then system show message "User does not exist."
