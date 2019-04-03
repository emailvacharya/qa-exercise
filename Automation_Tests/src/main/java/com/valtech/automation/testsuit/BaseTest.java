package com.valtech.automation.testsuit;

import com.valtech.automation.driver.BaseDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private BaseDriver driver;

    public BaseTest() {
    }

    @BeforeSuite(
            alwaysRun = true
    )
    public void setUp() {
        Report.setReport();

    }

    @BeforeTest(
            alwaysRun = true
    )

    public BaseDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new BaseDriver();
        ChromeDriver chromeDriver = new ChromeDriver(options);
        this.driver.setDriver(chromeDriver);
        driver.setTimeOuts();
        System.out.println("Browser name: "+chromeDriver.getCapabilities().getBrowserName());
        System.out.println("Browser version: "+chromeDriver.getCapabilities().getVersion()+"\n");

        return this.driver;
    }

    @AfterMethod(
            alwaysRun = true
    )
    public void afterMethodGetResult(ITestResult result) {
        Report.getResult(result);
    }

    @AfterTest(
            alwaysRun = true
    )
    public void afterTestCase() {
        BaseDriver.quitDriver();
    }

    @AfterSuite(
            alwaysRun = true
    )
    public void tearDown() {
        Report.endReport();
    }

}