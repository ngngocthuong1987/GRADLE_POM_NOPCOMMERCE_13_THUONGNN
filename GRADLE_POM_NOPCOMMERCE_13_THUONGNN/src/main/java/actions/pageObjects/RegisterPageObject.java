package actions.pageObjects;

import org.openqa.selenium.WebDriver;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import interfaces.pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPages {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLogOutLink() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public void selectMaleGender() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_MALE);
		clickToElement(driver, RegisterPageUI.GENDER_MALE);
	}

	public void inputFistName(String value) {
		waitToElementDisplayed(driver, RegisterPageUI.FIRST_NAME);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME, value);
	}

	public void inputLastName(String value) {
		waitToElementDisplayed(driver, RegisterPageUI.LAST_NAME);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME, value);
	}

	public void selectBirthDay(String valueItem) {
		waitToElementDisplayed(driver, RegisterPageUI.BIRTH_DAY);
		selectItemInHtmlDropdown(driver, RegisterPageUI.BIRTH_DAY, valueItem);
	}

	public void selectBirthMonth(String valueItem) {
		waitToElementDisplayed(driver, RegisterPageUI.BIRTH_MONTH);
		selectItemInHtmlDropdown(driver, RegisterPageUI.BIRTH_MONTH, valueItem);
	}

	public void selectBirthYear(String valueItem) {
		waitToElementDisplayed(driver, RegisterPageUI.BIRTH_YEAR);
		selectItemInHtmlDropdown(driver, RegisterPageUI.BIRTH_YEAR, valueItem);
	}

	public void inputEmail(String value) {
		waitToElementDisplayed(driver, RegisterPageUI.EMAIL);
		sendKeyToElement(driver, RegisterPageUI.EMAIL, value);

	}

	public void inputCompanyName(String value) {
		waitToElementDisplayed(driver, RegisterPageUI.COMPANY);
		sendKeyToElement(driver, RegisterPageUI.COMPANY, value);

	}

	public void inputPassword(String value) {
		waitToElementDisplayed(driver, RegisterPageUI.PASSWORD);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD, value);

	}

	public void inputConfirmPassword(String value) {
		waitToElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD, value);

	}

	public void clickRegisterButton() {
		waitToElementDisplayed(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public boolean isRegistSuccess() {
		return isElementDisplay(driver, RegisterPageUI.REGIST_SUCCESS);
	}

}
