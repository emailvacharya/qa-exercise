package com.valtech.automation.pages;

import com.valtech.automation.driver.BaseDriver;
import com.valtech.automation.forms.PartnersForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PartnersPage {

    private BaseDriver driver;
    private PartnersForm partnersForm;

    public PartnersPage(BaseDriver driver){
        this.driver = driver;
        partnersForm = new PartnersForm(driver);
    }

    private int getTotalPartners(){
        return driver.getElements(By.xpath(partnersForm.getPartners().getXpath())).size();
    }

    public int getPartnerPosition(String partnerName){
        driver.wait(By.xpath(partnersForm.getOurPartners().getXpath()));
        List<WebElement> elementList = driver.getElements(By.xpath(partnersForm.getPartners().getXpath()));
        AtomicInteger position = new AtomicInteger();
        elementList.stream()
                .peek(element->position.incrementAndGet())
                .filter(element->element.getAttribute("class").contains(partnerName))
                .findFirst().orElse(null);
        return position.get();
    }

    public boolean isCommerceToolsLast(){
        return (getPartnerPosition("commercetools") == getTotalPartners());
    }
}
