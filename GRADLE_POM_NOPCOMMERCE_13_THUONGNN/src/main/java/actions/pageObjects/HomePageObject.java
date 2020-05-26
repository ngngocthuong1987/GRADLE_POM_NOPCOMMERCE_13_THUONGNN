package actions.pageObjects;

import org.openqa.selenium.WebDriver;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import interfaces.pageUIs.HomePageUI;

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

	public boolean isLoginSuccess() {
		return getCurrentUrl(driver).equals("https://demo.nopcommerce.com/abc");
	}

}
