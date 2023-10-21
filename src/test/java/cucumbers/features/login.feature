Feature: Login Page to Sauce Demo

  Scenario: Success Login
    Given Login page Sauce Demo
    When Input user-name
    And Input password
    And Click the login button
    Then User redirected to dashboard Page

    Scenario: Failed Login
      Given Login page Sauce Demo
      When Input invalid user-name
      And Input password
      And Click the login button
      Then user get error button