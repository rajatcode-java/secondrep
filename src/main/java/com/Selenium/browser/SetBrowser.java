package com.Selenium.browser;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.Selenium.driver.Driver;
import com.Selenium.listeners.WebDriverListener;
import com.fileUtils.ReadConfig;

public class SetBrowser {
    ReadConfig readConfig=new ReadConfig();
    WebDriverListener driverListener = new WebDriverListener();
    //what browsers are we interested in implementing
    public void browserSet(String browser ) throws Exception {
        switch (browser) {        //check our browser
            case "Firefox": {
                Driver.driver = new FirefoxDriver();
                Driver.e_driver=new EventFiringWebDriver(Driver.driver);
                Driver.e_driver.register(driverListener);
                break;
            }
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver",readConfig.getDriver());
                Driver.driver = new ChromeDriver();
                Driver.e_driver=new EventFiringWebDriver(Driver.driver);
                Driver.e_driver.register(driverListener);
                Driver.driver.manage().window().maximize();
                break;
            }
            case "InternetExplorer": {
                Driver.driver = new InternetExplorerDriver();
                Driver.e_driver=new EventFiringWebDriver(Driver.driver);
                Driver.e_driver.register(driverListener);
                break;
            }
            case "Safari": {
                Driver.driver = new SafariDriver();
                Driver.e_driver=new EventFiringWebDriver(Driver.driver);
                Driver.e_driver.register(driverListener);
                break;
            }
            //if our browser is not listed, throw an error
            default: {
                throw new Exception();
            }
            
        }
    }
}
