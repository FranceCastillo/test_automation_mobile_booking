Feature: Search destination

  @SearchDestination
  Scenario: Search for travel destination
    Given I enter the application booking
    Given I click in the Stays opcion
    When I click on the search engine
    And I click on the search destination
    And I write the destiny "Cusco"
    Then valid to show the date to be booked