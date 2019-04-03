package com.valtech.automation.helpers;

import com.valtech.automation.driver.BaseDriver;
import com.valtech.automation.forms.HomePageForm;
import com.valtech.automation.pages.ContactUsPage;
import com.valtech.automation.pages.HomePage;
import com.valtech.automation.pages.PartnersPage;


public class TestHelper {

    public static TestHelper testHelper = new TestHelper();
    private BaseDriver driver = new BaseDriver();
    private HomePageForm homePageForm = new HomePageForm(driver);

    public HomePage navigateToHomePage(){
        driver.navigateTo("https://www.valtech.com/en-gb/");
        acceptCookies();
        return new HomePage(driver);
    }

    public ContactUsPage navigateToContactUsPage(){
        driver.navigateTo("https://www.valtech.com/en-gb/about/contact-us");
        return new ContactUsPage(new BaseDriver());
    }

    public PartnersPage navigateToPartnersPage(){
        driver.navigateTo("https://www.valtech.com/en-gb/partners/");
        return new PartnersPage(new BaseDriver());
    }

    private void acceptCookies(){
        if (homePageForm.getAcceptCookies().isDisplayed())
            homePageForm.getAcceptCookies().click();
    }
}
