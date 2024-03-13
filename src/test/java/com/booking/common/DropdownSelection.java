package com.booking.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.booking.steps.config.Driver.androidDriver;

public class DropdownSelection {

    public void selectAge(String age, String idElement) {

        boolean isAgeFound = false;
        int maxTries = 10;
        int currentTry = 1;
        while (!isAgeFound) {
            try {
                List<WebElement> visibleElements = androidDriver.findElements(By.className(idElement));
                visibleElements.get(1).click();
                WebElement ageSelected = androidDriver.findElement(By.xpath("//android.widget.EditText[@text='" + age + "']"));
                ageSelected.click();
                isAgeFound = true;
            } catch (Exception e) {
                if (currentTry == maxTries){
                    isAgeFound = true;
                }else{
                    currentTry++;
                }
            }
        }
    }
}
