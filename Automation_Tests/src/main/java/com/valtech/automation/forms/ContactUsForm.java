package com.valtech.automation.forms;

import com.valtech.automation.controls.Button;
import com.valtech.automation.controls.Label;
import com.valtech.automation.driver.BaseDriver;
import org.openqa.selenium.By;

public class ContactUsForm {

    private Label countries;
    private Label countryExpanded;
    private Label currentCountry;
    private Label offices;
    private Button close;

    public ContactUsForm(BaseDriver driver){
        countries = new Label(driver, By.xpath("//div[@class='contact-item']"));
        countryExpanded = new Label(driver, By.xpath("//div[@class='contact-item is-active']"));
        currentCountry = new Label(driver, By.xpath("//div[@class='contact-item is-active']/div/*[@class='contact-item__title']"));
        offices = new Label(driver, By.xpath("']/div[2]/div[@class='contact-item__offices u-grid u-grid--default']/div"));
        close = new Button(driver, By.xpath("//*[@class='svg-close']"));
    }

    public Label getCountries() {
        return countries;
    }

    public Label getCountryExpanded() {
        return countryExpanded;
    }

    public Label getCurrentCountry() {
        return currentCountry;
    }

    public Label getOffices() {
        return offices;
    }

    public Button getCloseButton() {
        return close;
    }
}
