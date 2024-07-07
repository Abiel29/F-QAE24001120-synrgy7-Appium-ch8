Feature: Home Page

  Scenario: Sorting items from low to high price
    Given I am on the homepage
    When I sort items by price from low to high
    Then the first item should be cheaper than the second item