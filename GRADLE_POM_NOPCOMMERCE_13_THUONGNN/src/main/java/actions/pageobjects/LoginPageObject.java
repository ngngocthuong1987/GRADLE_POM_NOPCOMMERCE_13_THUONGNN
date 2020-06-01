package actions.pageobjects;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import interfaces.pageuis.LoginPageUI;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends AbstractPages {

    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputDataToElement(String idElement, String valueInput) {
        waitToElementDisplayedByXpath(driver, LoginPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement);
        sendKeyToElement(driver, LoginPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement, valueInput);
    }

    public HomePageObject clickToLoginButton() {
        waitToElementDisplayedByXpath(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePageObject(driver);
    }

    public String getErrorMessage(String idElement) {
        if (StringUtils.isNotEmpty(idElement)) {
            waitToElementDisplayedByCss(driver, LoginPageUI.DYNAMIC_ERROR_MESSAGE, idElement);
            return getTextElementByCss(driver, LoginPageUI.DYNAMIC_ERROR_MESSAGE, idElement);
        } else {
            return getTextElementByCss(driver, LoginPageUI.NOT_REGIST_EMAIL_MESSAGE);
        }
    }
}
