package com.booking.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.booking.steps.config.Driver.androidDriver;

public class SearchPage {
    WebElement startButton = androidDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));

        public void clicBuscador(){
        startButton.click();
    }

    public void clicbuscarDestino(){
        androidDriver.findElement(By.id("com.airbnb.android:id/search_input")).click();
    }

    public void escribirDestino(String sDestino){
        Actions actions = new Actions(androidDriver);
        actions.sendKeys(sDestino).perform();
        androidDriver.findElement(By.id("com.airbnb.android:id/icon")).click();
    }

    public void validarPantalla(){
        String resultadoEsperado = "February 2023";
        String resultadoActual= androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.GridView/android.widget.TextView")).getText();
        Assert.assertEquals(resultadoEsperado,resultadoActual);

    }
}

