package com.valtech.automation.driver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriver {
    private static WebDriver driver;

    public BaseDriver() {
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void setDriver(WebDriver driver) {
        BaseDriver.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }

    public void setTimeOuts() {
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void wait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForInvisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5L);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitElementAndClick(By locator, WebElement element) {
        try {
            this.waitForJSToLoad();
            this.scrollElementIntoMiddleView(element);
            WebDriverWait wait = new WebDriverWait(driver, 10L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (StaleElementReferenceException var4) {
            var4.getMessage();
        }
    }

    public boolean waitForJSToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30L);
        ExpectedCondition<Boolean> jsLoad = (WebDriver driver)->
                ((JavascriptExecutor)BaseDriver.getDriver()).executeScript("return document.readyState").toString().equals("complete");

        return wait.until(jsLoad);
    }

    public void scrollElementIntoMiddleView(WebElement element) {
        String scrollElementIntoMiddleJS = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);var elementTop = " +
                "arguments[0].getBoundingClientRect().top;window.scrollBy(0, elementTop-(viewPortHeight/2));";
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript(scrollElementIntoMiddleJS, element);
    }

    public boolean isDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (StaleElementReferenceException var3) {
            var3.getMessage();
        } catch (TimeoutException var4) {
            return false;
        }
        return true;
    }
}