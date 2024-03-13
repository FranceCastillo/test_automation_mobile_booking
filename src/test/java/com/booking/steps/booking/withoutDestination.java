package com.booking.steps.booking;

import com.booking.page.withoutDestinationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class withoutDestination {

    com.booking.page.withoutDestinationPage withoutDestinationPage = new withoutDestinationPage();

    @And("I click on Search button without enter the destination")
    public void iClickOnSearchButtonWithoutEnterTheDestination() {
        withoutDestinationPage.ClickSearchButton();
    }

    @Then("I see the modal with de message {string}")
    public void iSeeTheModalWithDeMessage(String alertMessage) {
        withoutDestinationPage.ValidAlertMessage(alertMessage);

    }
}
