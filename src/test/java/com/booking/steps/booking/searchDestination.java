package com.booking.steps.booking;

import com.booking.page.searchDestinationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchDestination {

    searchDestinationPage searchDestination = new searchDestinationPage();

    @Given("I enter the application booking")
    public void iEnterTheApplicationBooking() {
        searchDestination.clicBuscador();
    }
    @When("Enter the data for the search {string}, {string}, {string} and {string}")
    public void enterTheDataForTheSearchAnd(String city, String dateStart, String dateEnd, String ageChildren) {
        searchDestination.enterDataSearch();
    }
    @And("I click on Search button")
    public void iClickOnButton() {
        searchDestination.ClickOnButton();
    }

    @Then("I see the list of available accommodation results")
    public void iSeeTheListOfAvailableAccommodationResults() {
        searchDestination.ValidResul();
        searchDestination.PriceInitial();
    }

}
