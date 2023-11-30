package com.demo.sauce.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseDriver {
    public ExtentReports extent;
    public ExtentTest logger;
    public WebDriver driver;
    public Properties prop;
    public WebDriver browserSetup(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(); //chrome browser
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(); //Edge browser
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//wait for 10 seconds
       return driver;
    }

    public void loadDataProperties() {
        prop = new Properties();

        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "src/main/java/utils/Constant.Properties");
        try {
            FileInputStream fis = new FileInputStream(file);

            prop.load(fis);
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }

    public void extentReport() {

        ExtentSparkReporter spark = new ExtentSparkReporter("/Users/yogavardhani/IdeaProjects/SeleniumPom/target/reports");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }


}
