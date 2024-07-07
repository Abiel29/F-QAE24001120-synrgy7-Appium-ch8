Feature: Cart

  Scenario: Checkout
    Given I am on the homepage
    When I add two different items to the cart
    And I proceed to checkout
    Then I should see the success checkout page