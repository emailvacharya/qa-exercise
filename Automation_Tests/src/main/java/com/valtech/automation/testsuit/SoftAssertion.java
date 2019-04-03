package com.valtech.automation.testsuit;

import org.testng.asserts.SoftAssert;

public class SoftAssertion {

    private SoftAssert softAssert = new SoftAssert();

    public SoftAssertion() {
    }

    public void assertAll(){
        softAssert.assertAll();
    }

    public  void assertTrue(boolean condition, String failMessage, String passMessage) {
        if (condition){
            softAssert.assertTrue( condition, failMessage);
            Report.testPass(passMessage);
        } else{
            softAssert.assertTrue( condition, failMessage);
            Report.testFail(failMessage);
        }
    }

    public void assertEquals(Object actual, Object expected, String failMessage, String passMessage) {
        if (actual.equals(expected)){
            softAssert.assertEquals(actual, expected, failMessage);
            Report.testPass(passMessage);
        }else {
            softAssert.assertEquals(actual, expected, failMessage);
            Report.testFail(failMessage);
        }
    }
}