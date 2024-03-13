Feature: Accommodation without selecting destination

  @SearchWithDestination @Regression
  Scenario: Validate that it is not possible to make a reservation without entering a destination
    Given I enter the application booking
    And I click on Search button without enter the destination
    Then I see the modal with de message "Please enter your destination"