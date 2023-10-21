Feature: Remove to Cart

  Scenario: Success Remove to Cart
    Given Login page Sauce Demo - Remove To Cart
    When Input user-name - Remove To Cart
    And Input password - Remove to Cart
    And Click the login button - Remove to Cart
    And User redirected to dashboard page - Remove to Cart
    And Add item to Cart
    Then Remove one item from cart