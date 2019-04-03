package com.valtech.automation.controls;

import com.valtech.automation.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

public class WebControl {
    BaseDriver driver;
    By locator;

    public WebControl(BaseDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    protected WebElement getElement() {
        WebElement element;
        this.driver.wait(this.locator);
        element = this.driver.getElement(this.locator);
        if (element == null) {
                throw new NotFoundException("Element not found" + this.locator);
        }
        return element;
    }

    public boolean isDisplayed() {
        return this.driver.isDisplayed(this.locator);
    }

    public String getXpath() {
        return this.locator.toString().replace("By.xpath: ", "");
    }
}
