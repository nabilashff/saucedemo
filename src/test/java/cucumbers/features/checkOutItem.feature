Feature: CheckOut Item

  Scenario: Success Checkout Item
    Given Login page Sauce Demo - CheckOut Item
    When Input user-name - CheckOut Item
    And Input password - CheckOut Item
    And Click the login button - CheckOut Item
    And User redirected to dashboard page - CheckOut Item
    And Add items to Cart
    And Click cart button
    And Click checkout button
    And Input first-name
    And Input last-name
    And Input zipCode
    And Click continue button
    And Click finish button
    Then redirect to successfully checkout page