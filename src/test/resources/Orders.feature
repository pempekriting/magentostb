Feature: Orders

  Background:
    Given User is at Home Page
    When User go to the sign in page
    And User login with valid registered customers
    Then User successfully logged in to Luma

  Scenario: As a User, I want to order men clothes
    Given User is at "Men" "Tops" "Jackets" menu
    When User buy 2 items
    And User navigate to "Men" "Tops" "Bottoms" menu
    And User buy 1 items
    And User navigate to the cart page
    And User fill the shipping address with valid data
    Then the order is successfully submitted
