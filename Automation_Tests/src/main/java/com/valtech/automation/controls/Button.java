package com.valtech.automation.controls;

import com.valtech.automation.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends WebControl {

    public Button(BaseDriver driver, By locator) {
        super(driver, locator);
    }

    public void click() {
        WebElement e = this.getElement();
        this.driver.waitElementAndClick(this.locator, e);
    }

}