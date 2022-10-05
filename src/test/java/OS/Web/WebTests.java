package OS.Web;

import core.DriverUtils;
import POM.POM;
import core.Utilities;
import core.WebActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class WebTests {

    private WebDriver driver;

    @Test (groups = {"ready"})
    public void login() {

        POM.AboutGitlab aboutGitlab = new POM().new AboutGitlab();


        DriverUtils driverUtils = new DriverUtils();
        driverUtils.createBrowserDriver();
        driver = driverUtils.getDriver();

        driverUtils.openBrowser("https://about.gitlab.com/");
        Assert.assertTrue(true);
        WebActions.click(driver, aboutGitlab.whygitlab);
        WebActions.click(driver, aboutGitlab.whyPremium);

        try {
            Thread.sleep(10000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void loadProperties(){
        System.out.println("Calling LoadProperties");

        Utilities.loadTestProperties();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        driver.quit();
    }

}
