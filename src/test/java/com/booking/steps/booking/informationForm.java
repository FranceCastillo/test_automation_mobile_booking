package com.booking.steps.booking;

import io.cucumber.java.en.*;
import com.booking.page.informationFormPage;

public class informationForm {

    informationFormPage informationForm = new informationFormPage();

    @Given("I enter my data in the form")
    public void i_enter_my_data_in_the_form() {
        informationForm.EnterInformation();
    }
    @And("I click on Next step button")
    public void iClickOnNextStepButton() {
        informationForm.ClickNextButton();
    }
    @Then("I validate the booking summary with the total price {string}, start date {string} and end date {string}")
    public void i_validate_the_booking_summary_with_the_total_price_start_date_and_end_date(String Price, String CheckIn, String CheckOut) throws InterruptedException {
     informationForm.ValidInformationSumary(Price, CheckIn, CheckOut);
    }
}
