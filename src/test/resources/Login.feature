Feature: Login

  Scenario: Successfully login
    Given I am on the login page
    When I enter valid credentials
    And I press login
    Then I should see the homepage

  Scenario: Failed login with wrong password
    Given I am on the login page
    When I enter invalid credentials
    And I press login
    Then I should see an error message