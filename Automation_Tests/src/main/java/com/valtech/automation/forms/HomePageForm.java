package com.valtech.automation.forms;

import com.valtech.automation.controls.Button;
import com.valtech.automation.controls.Label;
import com.valtech.automation.driver.BaseDriver;
import org.openqa.selenium.By;

public class HomePageForm {

    private Button menuButton;
    private Button acceptCookies;
    private Button publicSector;
    private Label menuLinks;

    public HomePageForm(BaseDriver driver){
        menuButton = new Button(driver, By.xpath("//Button[@class = 'icon-menu']"));
        acceptCookies = new Button(driver, By.xpath("//*[@id='CybotCookiebotDialogBodyButtonAccept']"));
        publicSector = new Button(driver, By.xpath("//Button[text()='Public Sector']"));
        menuLinks = new Label(driver, By.xpath("//ul[@class='site-nav__menu__primary']/li/button[@type='button']"));
    }

    public Button getMenuButton() {
        return menuButton;
    }

    public Button getAcceptCookies() {
        return acceptCookies;
    }

    public Button getPublicSectorButton() {
        return publicSector;
    }

    public Label getMenuLinks() {
        return menuLinks;
    }
}
