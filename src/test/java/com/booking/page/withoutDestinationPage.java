package com.booking.page;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
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

public class withoutDestinationPage {

    static Gson gson = new Gson();
    static HashMap<String, Map> jsonData;
    static WebDriverWait wait = null;

    int x = 100;
    int y = 200;
    TouchAction touchAction = new TouchAction(androidDriver);

    //Locators for elements
    private static final By AlertMessage = By.id("com.booking:id/message");
    private static final By Search_button = By.id("com.booking:id/facet_search_box_legacy_theme_cta_border_bottom");
    private static final By Ok_button = By.id("com.booking:id/button_positive");


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


    public void ClickSearchButton() {
        touchAction.tap(PointOption.point(x, y)).perform();
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(Search_button));
        button.click();
    }

    public void ValidAlertMessage(String expectedMessage) {
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertMessage));
        String actualMessage = alertMessage.getText();
        Assert.assertEquals("El mensaje de alerta no coincide", expectedMessage, actualMessage);
        WebElement ok_button = wait.until(ExpectedConditions.visibilityOfElementLocated(Ok_button));
        ok_button.click();
    }
}
