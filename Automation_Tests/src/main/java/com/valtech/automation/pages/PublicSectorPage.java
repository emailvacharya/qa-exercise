package com.valtech.automation.pages;

import com.valtech.automation.driver.BaseDriver;
import com.valtech.automation.forms.PublicSectorForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PublicSectorPage {

    private BaseDriver driver;
    private PublicSectorForm publicSectorForm;

    public PublicSectorPage(BaseDriver driver){
        this.driver = driver;
        publicSectorForm = new PublicSectorForm(driver);
    }

    public ArrayList<String> getCaseStudies(){
        driver.wait(By.xpath(publicSectorForm.getCaseStudies().getXpath()));
        List<WebElement> elementList = driver.getElements(By.xpath(publicSectorForm.getCaseStudies().getXpath()));
        ArrayList<String> caseStudiesList = new ArrayList<>();
        elementList.forEach(element -> caseStudiesList.add(element.getText()));
        return caseStudiesList;
    }
}
