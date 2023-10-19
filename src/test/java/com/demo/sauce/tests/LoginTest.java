package com.demo.sauce.tests;

import com.demo.sauce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver(); //chrome browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//wait for 10 seconds
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
