package actions.commons;

import actions.pageObjects.HomePageObject;
import actions.pageObjects.LoginPageObject;
import actions.pageObjects.MyAccountPageObject;
import actions.pageObjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static HomePageObject getHomePageObject(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static LoginPageObject getLoginPageObject(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
        return new MyAccountPageObject(driver);
    }
}
