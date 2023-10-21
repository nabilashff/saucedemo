Feature: Add to Cart

  Scenario: Success Add to Cart
    Given Login page Sauce Demo - Add To Cart
    When Input user-name - Add To Cart
    And Input password - Add to Cart
    And Click the login button - Add to Cart
    And User redirected to dashboard page
    Then Add Bag to Cart