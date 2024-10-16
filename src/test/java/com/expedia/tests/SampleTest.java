package com.expedia.tests;

import com.expedia.pages.HomePage;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        homePage.login("testuser", "testpassword");

    }
}
