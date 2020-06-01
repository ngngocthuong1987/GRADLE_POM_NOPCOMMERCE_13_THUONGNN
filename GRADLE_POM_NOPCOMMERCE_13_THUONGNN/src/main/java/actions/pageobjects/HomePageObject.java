package actions.pageobjects;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import interfaces.pageuis.HomePageUI;

import org.openqa.selenium.WebDriver;

public class HomePageObject extends AbstractPages {

    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObject clickToLoginPage() {
        waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPageObject(driver);
    }

    public RegisterPageObject clickToRegisterPage() {
        waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPageObject(driver);
    }

    public MyAccountPageObject clickToMyAccountPage() {
        waitToElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getMyAccountPageObject(driver);
    }

}
