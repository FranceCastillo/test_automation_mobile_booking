package com.booking.page;

import com.booking.common.DropdownSelection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.booking.steps.config.Driver.androidDriver;

public class accommodationPage {

    static Gson gson = new Gson();
    static HashMap<String, Map> jsonData;
    static WebDriverWait wait = null;

    //Locators for elements
    private static final By Result1 = By.xpath("//android.widget.FrameLayout[@resource-id='com.booking:id/results_list_facet']/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]");
    private static final String ResultPath = "//android.widget.FrameLayout[@resource-id='com.booking:id/results_list_facet']/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup";
    private static final By Result2 = By.xpath("//android.widget.FrameLayout[@resource-id='com.booking:id/results_list_facet']/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
    private static final By SelectRooms = By.id("com.booking:id/select_room_cta");
    private static final By SelectFirstOption = By.id("com.booking:id/recommended_block_reserve_button");
    private static final By SelectFirstOptionBck = By.id("com.booking:id/list_item");
    private static final By ScreenData = By.xpath("//android.widget.TextView[@text='Fill in your info']");


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

    public void selectOption() {
        List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(ResultPath)));
        if (results.size() > 4){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.booking:id/bui_banner_close_button"))).click();
            WebElement result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Result1));
            result1.click();
        }else{
            try {
                WebElement result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Result1));
                result1.click();
            } catch (Exception e){
                    WebElement result2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Result2));
                    result2.click();
            }
        }

 }

    public void selectRooms() {
        WebElement selectRooms = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectRooms));
        selectRooms.click();
    }

    public void SelectFirstOption() {
        try{
            WebElement selectFirstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectFirstOption));
            selectFirstOption.click();
        }catch (Exception e){
            WebElement selectFirstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectFirstOptionBck));
            selectFirstOption.click();
        }

    }

    public void ValidScreenData() {
        WebElement screenData = wait.until(ExpectedConditions.visibilityOfElementLocated(ScreenData));
        screenData.isDisplayed();

    }

}

/*


 */