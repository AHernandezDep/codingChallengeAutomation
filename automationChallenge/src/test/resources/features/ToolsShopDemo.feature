@TOOLSSHOP
Feature: Validation for practicesoftwaretesting.com Website

  Scenario Outline: Verify search functionality
    Given I open the browser on "https://practicesoftwaretesting.com"
    And Navigate to the 'Search' input box
    And In the 'Search' input box type the search criteria "<searchCriteria>"
    When Hit the search button
    Then Verify that only 'Pliers' are present in the page

    Examples:
      | searchCriteria |
      | Pliers         |

