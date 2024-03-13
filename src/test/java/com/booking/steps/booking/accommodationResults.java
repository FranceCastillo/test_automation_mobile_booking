package com.booking.steps.booking;

import com.booking.page.accommodationPage;

import io.cucumber.java.en.*;

public class accommodationResults {

    accommodationPage accommodation = new accommodationPage();

    @Given("I select the accommodation option")
    public void i_select_the_accommodation_option() {
        accommodation.selectOption();

    }
    @Given("I select the rooms")
    public void i_select_the_rooms() {
        accommodation.selectRooms();

    }
    @Given("I select the first option of reserve")
    public void i_select_the_firts_option_of_reserve() {
        accommodation.SelectFirstOption();

    }
    @Then("I see on the customer information entry screen")
    public void i_see_on_the_customer_information_entry_screen() {
        accommodation.ValidScreenData();
    }
}
