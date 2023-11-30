package com.demo.sauce.tests;

import com.demo.sauce.pages.BaseDriver;
import com.demo.sauce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

//Inheritance
public class LoginTest extends BaseDriver {
    WebDriver driver;
    @BeforeMethod

    public void reportGeneration() {
        //logger = extent.createTest(testMethod.getName());
        loadDataProperties();
        this.driver = browserSetup(prop.getProperty("browser"));
        driver.get(prop.getProperty("BASE_URL"));
    }


    @Test(priority = 1)
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}
