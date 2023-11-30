package com.demo.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    //Parametrized Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }
    //Objects
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;
//getter method
    public WebElement getUsername(){
        return username;
    }

    @FindBy(xpath="//input[@id='password']")
    private WebElement password;
    public WebElement getPassword(){
        return password;
    }

    @FindBy(xpath="//input[@id='login-button']")
    private WebElement loginButton;

    public WebElement getLoginButton(){
        return loginButton;
    }




    //Actions
    public void login(String userName, String passWord){
        getUsername().sendKeys(userName);
        getPassword().sendKeys(passWord);
        getLoginButton().click();

    }


}
