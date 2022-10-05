package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {

    public static Properties globalProperties;

    /**
     * Config object representing properties used during test.
     */
    public enum Configs {
        BROWSER("browser"),
        ENV("env"),
        TESTTYPE("testtype"),
        LOGTESTSTEPS("logteststeps");

        private final String key;
        Configs (String key){
            this.key = key;
        }
        public String getKey(){
            return key;
        }
    }

    /**
     * Method to load properties defined in properties file. Properties will be loaded to globlal variable globalProperties.
     */
    public static void loadTestProperties() {
        try {

            //POM.PageOne
            String projectPath = System.getProperty("user.dir");

            System.out.println(projectPath);

            InputStream input = new FileInputStream(projectPath + "/src/test/resources/data/testProperties.properties");

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            String envVal = prop.getProperty(Configs.ENV.key);

            globalProperties = new Properties();
            globalProperties.put("browser", prop.getProperty(envVal + "." + Configs.BROWSER.key));
            globalProperties.put("testtype", prop.getProperty(envVal + "." + Configs.TESTTYPE.key));
            globalProperties.put("logteststeps", prop.getProperty(envVal + "." + Configs.LOGTESTSTEPS.key));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method to find desired element by its locator.
     * @param driver driver object
     * @param locator locator defined in the Page Object Model (POM) class
     * @return  located element's object
     *          null when element is not located
     */
    public static WebElement findElementByLocator (WebDriver driver, By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e){
            e.getSuppressed();
            System.out.println("NoSuchElementException: " + "Targeted Locator " + locator.toString() + " was not found.");
            return null;
        }
    }

    /**
     * Function to print the step being executed. Print could be turned  ON or OFF depending on property value
     * LOGTESTSTEPS defined in Config.
     * @param stepInfo Executed step information
     * @see Configs Config property defined according depending on testProperties.properties file
     * @see WebActions each Selenium action contains the String of the step being executed(action, object, input, output)
     */
    public static void logTestSteps(String stepInfo){
        if (Configs.LOGTESTSTEPS.key.equals("true")){
            System.out.println(stepInfo);
        }
    }
}
