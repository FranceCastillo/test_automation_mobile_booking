Feature: Accommodation Reserve


  @Search @Regression
  Scenario: Validate entry data for the accommodation search
    Given I enter the application booking
    When Enter the data for the search "city", "dateStart", "dateEnd" and "ageChildren"
    And I click on Search button
   Then I see the list of available accommodation results

  @accommodationResults @Regression
  Scenario: Validate selection of accommodation results
    Given I select the accommodation option
    And I select the rooms
    And I select the first option of reserve
    Then I see on the customer information entry screen

  @informationForm @Regression
  Scenario Outline: Validate the customer information form
    And I enter my data in the form
    And I click on Next step button
    Then I validate the booking summary with the total price "<Price>", start date "<Check-in>" and end date "<Check-Out>"
  Examples:
    | Price    | Check-in        | Check-Out       |
    | US$2,919 | Thu Mar 14 2024 | Thu Mar 28 2024 |

  @paymentMethod @Regression
  Scenario: Validate the payment method and finalize the reservation
    And I click on Final step button
    When I enter card number "<cardNumber>" and the date of issuance "<expirationDate>"
    Then I successfully complete the booking
