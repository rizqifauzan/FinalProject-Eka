@cart
Feature: Product page cart

  Background:
    Given user on the home page
    When user input "ekapermary" as username
    And user input "welcome" as password
    Then user will redirect to home page

  @valid-Add
  Scenario Outline: Add and payment product
    Given user is on the product page
    When user click image product
    And user click Add to cart
    And user click cart redirect to page cart
    And user click place order
    And user input form check out for example data :
      | name   | country   | city   | card   | month   | year   |
      | <name> | <country> | <city> | <card> | <month> | <year> |
    And user click Purchase
    Then payment success and show notification “Thank you for your purchase!”
    And user close pop up notification

    Examples:
      | produk            | name  | country   | city    | card      | month | year |
      | Samsung galaxy s6 | Indah | Indonesia | Jakarta | 123456789 | 12    | 2025 |
      | Sony xperia z5    | Raka  | Jepang    | Tokyo   | 987654321 | 11    | 2026 |


  @valid-Remove
  Scenario Outline: User removes product from the cart
    Given user is on the product page
    Given user is on the product page
    When user click image product
    And user click Add to cart
    And user click cart redirect to page cart
    When user click delete
    Then the product should be removed from the cart

    @invalid-payment
    Given user is on the product page
    When user click image product
    And user click Add to cart
    And user click cart redirect to page cart
    And user click place order
    And user input form check out for example data :
      | name   | country   | city   | card   | month   | year   |
      | <name> | <country> | <city> | <card> | <month> | <year> |
    And user click Purchase
    Then payment faild and show notification “Please fill out Name and Creditcard.”


    Examples:
      | name | country   | city    | card      |month | year | isSuccess | expected_message                     |
      |      | Indonesia | Jakarta | 123456789 | 3    | 2024 | false     | Please fill out Name and Creditcard. |
      | Eka  | Indonesia | Jakarta |           | 3    | 2024 | false     | Please fill out Name and Creditcard. |
      | Eka  | Indonesia | Jakarta | abcd1234  | 3    | 2024 | true      | Thank you for your purchase!         |
      | Eka  | Indonesia | Jakarta | 1234abcd  | 3    | 2025 | true      | Thank you for your purchase!         |
      | Eka  | Indonesia | Jakarta | abcdefghi | 3    | 2025 | true      | Thank you for your purchase!         |
      | Eka  | Indonesia | Jakarta | 123456789 | 3    | 2025 | true      | Thank you for your purchase!         |


