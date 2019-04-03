package com.valtech.automation.controls;

import com.valtech.automation.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Label extends WebControl {
    public Label(BaseDriver driver, By locator) {
        super(driver, locator);
    }

    public String getAttribute(String attributeName) {
        WebElement e = this.getElement();
        return e.getAttribute(attributeName);
    }
}