package com.valtech.automation.utility;

import com.valtech.automation.driver.BaseDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    public Screenshot() {
    }

    public static String takeScreenshot(String screenshotName) {
        try {
            WebDriver driver = BaseDriver.getDriver();
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "./test-output/screenshots/" + screenshotName + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            return "./screenshots/" + screenshotName + ".png";
        } catch (Exception var7) {
            System.out.println("Exception while taking screenshot " + var7.getMessage());
            return var7.getMessage();
        }
    }
}
