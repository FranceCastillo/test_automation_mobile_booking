package com.booking.steps.booking;

import com.booking.page.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class searchDestiny {

    SearchPage searchPage = new SearchPage();

    @Given("I enter the application booking")
    public void iEnterTheApplicationBooking() {
        searchPage.clicBuscador();
    }

    @Given("I click in the Stays opcion")
    public void iClickInTheStaysOpcion() {
    }

    @When("I click on the search engine")
    public void i_click_on_the_search_engine() {

    }
    @When("I click on the search destination")
    public void i_click_on_the_search_destination() {

    }
    @When("I write the destiny {string}")
    public void i_write_the_destiny(String string) {

    }
    @Then("valid to show the date to be booked")
    public void valid_to_show_the_date_to_be_booked() {

    }
}
