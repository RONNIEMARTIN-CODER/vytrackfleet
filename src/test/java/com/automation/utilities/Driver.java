package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    // same for everyone
    private static WebDriver driver;
    // so no one can create object of Driver class.
    // everyone should call static getter method instead
    private Driver(){

    }

    public static WebDriver getDriver(){
        // if webdriver object doesn't exist
        // create it
        if(driver == null){
            String browser =  ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
                    driver =new ChromeDriver(chromeOptions);
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }

        return driver;
    }
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }

}
