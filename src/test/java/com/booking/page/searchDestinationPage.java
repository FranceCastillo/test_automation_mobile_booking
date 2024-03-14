package com.booking.page;

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
import java.util.Map;

import com.booking.common.DropdownSelection;
import static com.booking.steps.config.Driver.androidDriver;

public class searchDestinationPage {
    static Gson gson = new Gson();
    static HashMap<String, Map> jsonData;
    static WebDriverWait wait = null;

    private static DropdownSelection dropdownSelection = new DropdownSelection();

    //Locators for elements
    private static final By StartButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    private static final By StaysButton = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.booking:id/facet_index_section_search_header']/android.widget.LinearLayout[1]");
    private static final By Search = By.id("com.booking:id/facet_search_box_accommodation_destination");
    private static final By inputSearch = By.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content");
    private static final By Select_destination = By.xpath("//android.widget.TextView[1][@resource-id='com.booking:id/view_disambiguation_destination_title']");
    private static final By Calendar = By.id("com.booking:id/calendar_month_list");
    private static final By ConfirDate_button = By.id("com.booking:id/facet_date_picker_confirm");
    private static final By Box_accupancy = By.id("com.booking:id/facet_search_box_accommodation_occupancy");
    private static final By Select_children_button = By.xpath("//android.view.ViewGroup[@resource-id='com.booking:id/group_config_children_count']/android.widget.LinearLayout/android.widget.Button[2]");
    private static final By Ok_button_age_children = By.id("android:id/button1");
    private static final By Button_apply_selectRoomsAndGuests = By.id("com.booking:id/group_config_apply_button");
    private static final By Search_button = By.id("com.booking:id/facet_search_box_legacy_theme_cta_border_bottom");
    private static final By Result = By.xpath("//android.widget.FrameLayout[@resource-id='com.booking:id/results_list_facet']");
    private static final By PriceInitial = By.xpath("//android.view.ViewGroup[@resource-id='com.booking:id/price_view_holder']/android.widget.TextView[2]");


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

    public void clicBuscador() {
        try {
            WebElement buttonStart = wait.until(ExpectedConditions.visibilityOfElementLocated(StartButton));
            buttonStart.click();
        } catch (Exception e)
        {
            WebElement buttonStays = wait.until(ExpectedConditions.visibilityOfElementLocated(StaysButton));
            buttonStays.click();
        }
    }

    public void enterDataSearch() {
        Map<String, Object> searchDetails = (Map<String, Object>) jsonData.get("Search");
        if (searchDetails != null) {
            String city = (String) searchDetails.get("city");
            String dateStart = (String) searchDetails.get("dateStart");
            String dateEnd = (String) searchDetails.get("dateEnd");
            String ageChildren = (String) searchDetails.get("dateEnd");
            By Select_start_date = By.xpath("//android.view.View[@content-desc='" + dateStart + "']");
            By Select_end_date = By.xpath("//android.view.View[@content-desc='" + dateEnd + "']");
            WebElement SearchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Search));
            SearchButton.click();
            WebElement inputCity = wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearch));
            inputCity.sendKeys(city);
            WebElement select_destination = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_destination));
            select_destination.click();
            WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(Calendar));
            calendar.click();
            WebElement select_start_date = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_start_date));
            select_start_date.click();
            WebElement select_end_date = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_end_date));
            select_end_date.click();
            WebElement confirDate_button = wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirDate_button));
            confirDate_button.click();
            WebElement box_accupancy = wait.until(ExpectedConditions.visibilityOfElementLocated(Box_accupancy));
            box_accupancy.click();
            WebElement select_children_button = wait.until(ExpectedConditions.visibilityOfElementLocated(Select_children_button));
            select_children_button.click();
            dropdownSelection.selectAge("5 years old", "android.widget.Button");

            WebElement ok_button_age_children = wait.until(ExpectedConditions.visibilityOfElementLocated(Ok_button_age_children));
            ok_button_age_children.click();

            WebElement button_apply_selectRoomsAndGuests = wait.until(ExpectedConditions.visibilityOfElementLocated(Button_apply_selectRoomsAndGuests));
            button_apply_selectRoomsAndGuests.click();

        } else {
            System.out.println("Los detalles de búsqueda no están disponibles");
        }
    }
    public void ClickOnButton() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(Search_button));
        button.click();
    }
    public void ValidResul() {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(Result));
        result.isDisplayed();
    }

    public String PriceInitial() {
        WebElement priceInitial = wait.until(ExpectedConditions.visibilityOfElementLocated(PriceInitial));
        String priceText = priceInitial.getText();
        return priceText;
    }

}

