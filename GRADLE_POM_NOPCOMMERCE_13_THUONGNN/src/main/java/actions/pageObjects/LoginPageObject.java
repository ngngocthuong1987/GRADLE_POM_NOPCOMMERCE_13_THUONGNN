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
		waitToElementDisplayedByXpath(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public void inputToEmailTextBox(String email) {
		waitToElementDisplayedByXpath(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitToElementDisplayedByXpath(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getErrorMessage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
