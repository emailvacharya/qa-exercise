package com.valtech.automation.forms;

import com.valtech.automation.controls.Label;
import com.valtech.automation.driver.BaseDriver;
import org.openqa.selenium.By;

public class PartnersForm {

    private Label partners;
    private Label ourPartners;

    public PartnersForm(BaseDriver driver){
        partners = new Label(driver, By.xpath("//a[starts-with(@class,'logo-block__logo logo-block__logo')]"));
        ourPartners = new Label(driver, By.xpath("//*[@class='masthead-people__text masthead-people__text--light']"));
    }

    public Label getPartners() {
        return partners;
    }

    public Label getOurPartners() {
        return ourPartners;
    }
}
