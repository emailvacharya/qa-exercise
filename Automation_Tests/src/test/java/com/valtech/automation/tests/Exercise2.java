package com.valtech.automation.tests;

import com.valtech.automation.pages.HomePage;
import com.valtech.automation.testsuit.BaseTest;
import com.valtech.automation.testsuit.Report;
import com.valtech.automation.testsuit.SoftAssertion;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.valtech.automation.helpers.TestHelper.testHelper;

public class Exercise2 extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void navigateToHomePage(){
        homePage = testHelper.navigateToHomePage().clickMenuButton();
    }

   @Test
    public void verifyLinks(){

        Report.startReport("Exercise #2 - Verify Links on Home Page",
                "1) Navigate to https://www.valtech.com/en-gb/ HOME PAGE</br>" +
                             "2) Assert that the drop down menu on the right displays the following Links : " +
                             "Work, Public Sector, Services, Career, Insights");

        SoftAssertion softAssert = new SoftAssertion();
        ArrayList<String> expectedMenuLinks = new ArrayList<>(Arrays.asList("Work","Public Sector","Services","Career","Insights"));

        ArrayList<String> actualMenuLinks = homePage.getMenuLinks();

        softAssert.assertTrue(actualMenuLinks.containsAll(expectedMenuLinks),"Drop down menu on the right does not display the Links",
                "Drop down menu on the right displays the Links : " + expectedMenuLinks);

        softAssert.assertAll();
    }

    @Test
    public void verifyProjectCaseStudies(){
        Report.startReport("Exercise #2 - Verify Public Sector project case studies",
                "1) Navigate to https://www.valtech.com/en-gb/ HOME PAGE</br>" +
                             "2) Click on the Public Sector and validate the following:</br>" +
                             "a) List out how many Project case studies are listed</br>" +
                             "b) The project case studies are in the order of CSHR, TFGM, DVLA, DWP");

        SoftAssertion softAssert = new SoftAssertion();
        ArrayList<String> expectedCaseStudies = new ArrayList<>(Arrays.asList("Civil Service Human Resources","Transport for Greater Manchester","DVLA",
                "Department for Work and Pensions"));

        ArrayList<String> actualCaseStudies = homePage.clickPublicSectorButton().getCaseStudies();

        Report.logInfo("The Project case studies listed are : " +actualCaseStudies.size());

        softAssert.assertTrue(actualCaseStudies.equals(expectedCaseStudies),"The Project case studies are not in the order of CSHR, TFGM, DVLA, DWP."
             + "Actual order is : " +actualCaseStudies,"The Project case studies are in the order of CSHR, TFGM, DVLA, DWP : " + actualCaseStudies);

        softAssert.assertAll();
    }
}