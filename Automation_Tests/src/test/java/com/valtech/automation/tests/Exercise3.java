package com.valtech.automation.tests;

import com.valtech.automation.pages.PartnersPage;
import com.valtech.automation.testsuit.BaseTest;
import com.valtech.automation.testsuit.Report;
import com.valtech.automation.testsuit.SoftAssertion;
import org.testng.annotations.Test;
import java.util.HashMap;

import static com.valtech.automation.helpers.TestHelper.testHelper;

public class Exercise3 extends BaseTest {

    @Test
    public void verifyPartnerPosition(){
        Report.startReport("Exercise #3 -  Verify Valtech Partners position",
                "1) Navigate to https://www.valtech.com/en-gb/partners/ and validate the following</br>" +
                             "2) Adobe is the 2nd in the partner list</br>" +
                             "3) CommerceTools is last in the partner list");

        SoftAssertion softAssert = new SoftAssertion();
        PartnersPage partnersPage = testHelper.navigateToPartnersPage();
        int adobePosition = partnersPage.getPartnerPosition("adobe");
        int comPosition = partnersPage.getPartnerPosition("commercetools");

        softAssert.assertEquals(adobePosition, 2,"Adobe is not the 2nd in the partner list. It is at position " + adobePosition,
                "Adobe is the 2nd in the partner list");

        softAssert.assertTrue(partnersPage.isCommerceToolsLast(),"CommerceTools is not last in the partner list. It is at position " +comPosition,
                "CommerceTools is last in the partner list");

        softAssert.assertAll();
    }

    @Test
    public void getTotalOffices(){
        Report.startReport("Exercise #3 - Output total Valtech offices",
                "1) Navigate to Navigate to https://www.valtech.com/en-gb/about/contact-us/</br>" +
                            "2) Output total Valtech offices");

        HashMap<String, Integer> valtechOffices = testHelper.navigateToContactUsPage().getTotalOffices();
        valtechOffices.keySet().forEach(key->
            Report.logInfo( key + " : " + valtechOffices.get(key)));

        Report.logInfo("Total Valtech Offices : " + valtechOffices.get("Total Valtech Offices"));
    }
}
