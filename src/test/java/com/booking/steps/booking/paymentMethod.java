package com.booking.steps.booking;

import io.cucumber.java.en.*;
import com.booking.page.paymentMethodPage;
public class paymentMethod {

    paymentMethodPage methodPage = new paymentMethodPage();

    @And("I click on Final step button")
    public void iClickOnNextStepButton() {
        methodPage.ClickFinalButton();

    }
    @When("I enter card number {string} and the date of issuance {string}")
    public void she_enters_her_card_number_and_the_date_of_issuance(String string, String string2) {
        methodPage.methodPay();

    }
    @Then("I successfully complete the booking")
    public void i_successfully_complete_the_booking() {
        methodPage.ClickBook_Button();

    }
}
