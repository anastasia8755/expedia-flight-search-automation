package com.expedia.tests;

import com.expedia.utils.ConfigLoader;
import com.expedia.utils.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();
        driver.get(ConfigLoader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
