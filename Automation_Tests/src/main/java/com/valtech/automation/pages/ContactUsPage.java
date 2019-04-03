package com.valtech.automation.pages;

import com.valtech.automation.driver.BaseDriver;
import com.valtech.automation.forms.ContactUsForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;

public class ContactUsPage {

    private BaseDriver driver;
    private ContactUsForm contactUsForm;

    public ContactUsPage(BaseDriver driver){
        this.driver = driver;
        contactUsForm = new ContactUsForm(driver);
    }

    public HashMap<String, Integer> getTotalOffices(){
        contactUsForm.getCloseButton().click();
        driver.waitForInvisibility(By.xpath(contactUsForm.getCloseButton().getXpath()));
        int [] officeCount= {0};
        HashMap<String, Integer> officesInfo = new HashMap<>();

        List<WebElement> countriesList = driver.getElements(By.xpath(contactUsForm.getCountries().getXpath()));

        countriesList.forEach(country->{
                    driver.scrollElementIntoMiddleView(country);
                    driver.waitElementAndClick(By.xpath(contactUsForm.getCountries().getXpath()), country);
                    driver.wait(By.xpath(contactUsForm.getCountryExpanded().getXpath()));
                    String currentCountry = driver.getElement(By.xpath(contactUsForm.getCurrentCountry().getXpath())).getText();
                    int offices = driver.getElements(By.xpath("//*[@id='" + currentCountry + contactUsForm.getOffices().getXpath())).size();
                    officesInfo.put(currentCountry, offices);
                    officeCount[0] = officeCount[0] + offices;
                    officesInfo.put("Total Valtech Offices", officeCount[0]);
                    });
        return officesInfo;
    }
}
