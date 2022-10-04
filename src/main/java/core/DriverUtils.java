package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static core.Utilities.globalProperties;


public class DriverUtils {

    private WebDriver driver;
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public DriverUtils() {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.gheko.driver", "/usr/local/bin/chromedriver");

    }

    public void createBrowserDriver(){

//        System.out.println("browser is " + globalProperties.getProperty("browser"));
        String driverName = globalProperties.getProperty(Utilities.Configs.BROWSER.getKey());

        if (driverName.equalsIgnoreCase(CHROME)){
            driver = new ChromeDriver();
        }
        else if (driverName.equalsIgnoreCase(FIREFOX)){
            driver = new FirefoxDriver();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void openBrowser (String url){
        driver.get(url);
    }

}
