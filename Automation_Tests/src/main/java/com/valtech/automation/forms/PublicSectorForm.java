package com.valtech.automation.forms;

import com.valtech.automation.controls.Label;
import com.valtech.automation.driver.BaseDriver;
import org.openqa.selenium.By;

public class PublicSectorForm {

    private Label caseStudies;

    public PublicSectorForm(BaseDriver driver){
        caseStudies = new Label(driver, By.xpath("//h3[text()='Public Sector']/../following-sibling::div[@class='site-nav__main__item']"));
    }

    public Label getCaseStudies() {
        return caseStudies;
    }
}
