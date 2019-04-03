package com.valtech.automation.pages;

import com.valtech.automation.driver.BaseDriver;
import com.valtech.automation.forms.HomePageForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class HomePage {

    private BaseDriver driver;
    private HomePageForm homePageForm;

    public HomePage(BaseDriver driver){
        this.driver = driver;
        homePageForm = new HomePageForm(driver);
    }

    public HomePage clickMenuButton(){
        homePageForm.getMenuButton().click();
        return this;
    }

    public PublicSectorPage clickPublicSectorButton(){
        homePageForm.getPublicSectorButton().click();
        return new PublicSectorPage(new BaseDriver());
    }

    public ArrayList<String> getMenuLinks(){
        driver.wait(By.xpath(homePageForm.getMenuLinks().getXpath()));
        ArrayList<String> actualList = new ArrayList<>();
        List<WebElement> menuElementList = driver.getElements(By.xpath(homePageForm.getMenuLinks().getXpath()));
        menuElementList.forEach(menuElement->actualList.add(menuElement.getText()));
        return actualList;
    }
}