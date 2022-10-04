package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActions {
    public static void click (WebDriver driver, By locator){
        Utilities.logTestSteps("Performing Click on element " + locator.toString());
        WebElement object =  Utilities.findElementByLocator(driver, locator);
        object.click();
    }
}
