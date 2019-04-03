package com.valtech.automation.testsuit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.valtech.automation.driver.BaseDriver;
import com.valtech.automation.utility.Screenshot;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    public Report() {
    }

    public static void setReport() {
        htmlReporter = new ExtentHtmlReporter("./test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("User Name", getUserName());
        extent.setSystemInfo("OS", getOSName());
        extent.setSystemInfo("OS Version", getOSVersion());
        extent.setSystemInfo("OS Architecture", getOSArchitecture());
        htmlReporter.config().setDocumentTitle("Valtech Extent Report");
        htmlReporter.config().setReportName("Web Test Framework by Vikrant Chaudhari, 2019");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setCSS("img{display: block; margin-left: auto; margin-right: auto; width:60%;} ");
    }

    public static void getResult(ITestResult result) {
        if (result.getStatus() == 2) {
            String screenshotPath = Screenshot.takeScreenshot(result.getName() + getCurrentTimeStamp());

            try {
                test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable().toString(), ExtentColor.RED)).addScreenCaptureFromPath(screenshotPath).debug(result.getThrowable());
            } catch (Exception var3) {
                var3.getMessage();
            }
        } else if (result.getStatus() == 3) {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test case SKIPPED", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
        }
    }

    public static void startReport(String testName, String testDescription) {
        test = extent.createTest(testName, testDescription);
    }

    public static void endReport() {
        extent.setSystemInfo("Browser", getBrowserVersion());
        extent.flush();
    }

    private static String getBrowserVersion() {
        WebDriver driver = BaseDriver.getDriver();
        Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
        return caps.getBrowserName() + " " + caps.getVersion();
    }

    private static String getOSName() {
        return System.getProperty("os.name");
    }

    private static String getOSVersion() {
        return System.getProperty("os.version");
    }

    private static String getOSArchitecture() {
        return System.getProperty("os.arch");
    }

    private static String getUserName() {
        return System.getProperty("user.name");
    }

    public static void testPass(String passMessage) {
        test.log(Status.PASS, MarkupHelper.createLabel(passMessage, ExtentColor.GREEN));
    }

    public static void testFail(String failMessage) {
        test.log(Status.FAIL, MarkupHelper.createLabel(failMessage, ExtentColor.RED));
    }

    public static void logInfo(String logMessage) {
        test.log(Status.INFO, MarkupHelper.createLabel(logMessage, ExtentColor.BLUE));
    }

    private static String getCurrentTimeStamp() {
        Date now = new Date();
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
        return sdfDate.format(now);
    }
}