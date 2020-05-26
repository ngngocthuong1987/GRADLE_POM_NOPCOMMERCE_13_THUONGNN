package actions.pageObjects;

import org.openqa.selenium.WebDriver;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import interfaces.pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPages {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		waitToElementDisplayed(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public void inputToEmailTextBox(String email) {
		waitToElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitToElementDisplayed(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public boolean isErrorEmailMessageDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(LoginPageUI.EMAIL_ERROR_MESSAGE, errorMessage));
		return isElementDisplay(driver, String.format(LoginPageUI.EMAIL_ERROR_MESSAGE, errorMessage));
	}

	public boolean isErrorValidateMessageDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(LoginPageUI.VALIDTE_EMAIL_ERROR_MESSAGE, errorMessage));
		return isElementDisplay(driver, String.format(LoginPageUI.VALIDTE_EMAIL_ERROR_MESSAGE, errorMessage));
	}

}
