package com.booking.page;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

public class paymentMethodPage {

    static Gson gson = new Gson();
    static HashMap<String, Map> jsonData;
    static WebDriverWait wait = null;


    //Locators for elements
    private static final By FinalStep_Button = By.xpath("//android.widget.Button[@resource-id='com.booking:id/action_button']");
    private static final By InputCreditCard = By.xpath("//android.widget.EditText[@resource-id='com.booking:id/new_credit_card_number_edit']");
    private static final By InputExpirationDate = By.xpath("//android.widget.EditText[@resource-id='com.booking:id/new_credit_card_expiry_date_edit']");
    private static final By InputCvc = By.xpath("//android.widget.EditText[@resource-id='com.booking:id/new_credit_card_cvc_edit_text']");
    private static final By Book_Button = By.xpath("//android.widget.Button[@resource-id='com.booking:id/action_button']");
    private static final By PriceFinal = By.xpath("//android.widget.TextView[@resource-id='com.booking:id/title']");


    static {
        try {
            FileReader reader = new FileReader("src/test/resources/json/data.json");
            jsonData = gson.fromJson(reader, new TypeToken<HashMap<String, Object>>() {
            }.getType());
            wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void ClickFinalButton()  {
        WebElement finalStep_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(FinalStep_Button));
        finalStep_Button.click();
    }

    public void methodPay() {
        Map<String, Object> PayDetails = (Map<String, Object>) jsonData.get("Pay");
        if (PayDetails != null) {
            String cardNumber = (String) PayDetails.get("cardNumber");
            String expirationDate = (String) PayDetails.get("expirationDate");
            String cvc = (String) PayDetails.get("CVC");
            WebElement inputCreditCard = wait.until(ExpectedConditions.visibilityOfElementLocated(InputCreditCard));
            inputCreditCard.click();
            inputCreditCard.clear();
            inputCreditCard.sendKeys(cardNumber);
            WebElement inputExpirationDate = wait.until(ExpectedConditions.visibilityOfElementLocated(InputExpirationDate));
            inputExpirationDate.click();
            inputExpirationDate.clear();
            inputExpirationDate.sendKeys(expirationDate);
            WebElement inputCvc = wait.until(ExpectedConditions.visibilityOfElementLocated(InputCvc));
            inputCvc.click();
            inputCvc.clear();
            inputCvc.sendKeys(cvc);
            androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        } else {
            System.out.println("Los detalles de búsqueda no están disponibles");
        }
    }

    public void ClickBook_Button() {
        WebElement book_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(Book_Button));
        book_Button.click();
    }


}
