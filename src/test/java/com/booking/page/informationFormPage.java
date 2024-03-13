package com.booking.page;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.booking.steps.config.Driver.androidDriver;

public class informationFormPage {

    static Gson gson = new Gson();
    static HashMap<String, Map> jsonData;
    static WebDriverWait wait = null;

    TouchAction touchAction = new TouchAction(androidDriver);

    //Locators for elements
    private static final By InputFirstName = By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_firstname_value']/android.widget.EditText");
    private static final By InputLastName = By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_lastname_value']/android.widget.EditText");
    private static final By InputEmailAddress = By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_email_value']/android.widget.AutoCompleteTextView");
    private static final By InputAddress = By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_address_value']/android.widget.EditText");
    private static final By InputZipCode = By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_zipcode_value']/android.widget.EditText");
    private static final By InputCity = By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_city_value']/android.widget.EditText");
    private static final By InputCountry = By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_country_value']/android.widget.AutoCompleteTextView");
    private static final By InputMobilePhone = By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_telephone_value']/android.widget.EditText");
    private static final By Next_Button = By.xpath("//android.widget.Button[@resource-id='com.booking:id/action_button']");
    private static final By PriceSummary = By.xpath("//android.widget.TextView[@resource-id='com.booking:id/bp_price_summary_total_price_value']");
    private static final By CheckInSummary = By.xpath("//android.widget.TextView[@resource-id='com.booking:id/checkin_date']");
    private static final By CheckOnSummary = By.xpath("//android.widget.TextView[@resource-id='com.booking:id/checkout_date']");


    static {
        try {
            FileReader reader = new FileReader("src/test/resources/json/data.json");
            jsonData = gson.fromJson(reader, new TypeToken<HashMap<String, Object>>() {
            }.getType());
            wait = new WebDriverWait(androidDriver, Duration.ofSeconds(10));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void EnterInformation() throws InterruptedException {
        Map<String, Object> searchDetails = (Map<String, Object>) jsonData.get("Form");
        if (searchDetails != null) {
            String FirstName = (String) searchDetails.get("First Name");
            String LastName = (String) searchDetails.get("Last Name");
            String emailAddress = (String) searchDetails.get("email Address");
            String Country = (String) searchDetails.get("Country");
            String MobilePhone = (String) searchDetails.get("Mobile Phone");
            String Address = (String) searchDetails.get("Address");
            String ZipCode = (String) searchDetails.get("ZipCode");
            String City = (String) searchDetails.get("City");
            WebElement inputFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(InputFirstName));
            inputFirstName.click();
            inputFirstName.clear();
            inputFirstName.sendKeys(FirstName);
            WebElement inputLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(InputLastName));
            inputLastName.click();
            inputLastName.clear();
            inputLastName.sendKeys(LastName);
            WebElement inputEmailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(InputEmailAddress));
            inputEmailAddress.click();
            inputEmailAddress.clear();
            inputEmailAddress.sendKeys(emailAddress);
            WebElement inputAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(InputAddress));
            inputAddress.click();
            inputAddress.clear();
            inputAddress.sendKeys(Address);
            androidDriver.pressKey(new KeyEvent(AndroidKey.TAB));
            WebElement inputZipCode = wait.until(ExpectedConditions.visibilityOfElementLocated(InputZipCode));
            inputZipCode.click();
            inputZipCode.clear();
            inputZipCode.sendKeys(ZipCode);
            androidDriver.pressKey(new KeyEvent(AndroidKey.TAB));
            WebElement inputCity = wait.until(ExpectedConditions.visibilityOfElementLocated(InputCity));
            inputCity.click();
            inputCity.clear();
            inputCity.sendKeys(City);
            androidDriver.pressKey(new KeyEvent(AndroidKey.TAB));
            androidDriver.pressKey(new KeyEvent(AndroidKey.TAB));
            WebElement inputMobilePhone = wait.until(ExpectedConditions.visibilityOfElementLocated(InputMobilePhone));
            inputMobilePhone.click();
            inputMobilePhone.clear();
            inputMobilePhone.sendKeys(MobilePhone);
            androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        } else {
            System.out.println("Los detalles de búsqueda no están disponibles");
        }
    }

    public void ClickNextButton() {
        WebElement next_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(Next_Button));
        next_Button.click();
    }

    public void ValidInformationSumary(String expectedCheckIn, String expectedCheckOut) {

        WebElement checkInSummaryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckInSummary));
        String actualCheckIn = checkInSummaryElement.getText();
        Assert.assertEquals("La fecha de inicio no coincide", expectedCheckIn, actualCheckIn);

        WebElement checkOutSummaryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOnSummary));
        String actualCheckOut = checkOutSummaryElement.getText();
        Assert.assertEquals("La fecha de salida no coincide", expectedCheckOut, actualCheckOut);
    }

}
