package POM;

import org.openqa.selenium.By;

 public class POM {
    public class AboutGitlab {

        public By whygitlab = By.name("Why GitLab");
        public By whyPremium = By.xpath("//*[@id=\"be-navigation-desktop\"]//h4[contains(text(),\"Why Premium\")]");
        public By getfreetrial = By.id("Get free trial");

    }
    public class Password {

        final By usernametwo = By.id("usernametwoID");
        final By passwordtwo = By.id("passwordtwoID");
        final By buttontwo = By.id("buttontwoID");

    }
}
