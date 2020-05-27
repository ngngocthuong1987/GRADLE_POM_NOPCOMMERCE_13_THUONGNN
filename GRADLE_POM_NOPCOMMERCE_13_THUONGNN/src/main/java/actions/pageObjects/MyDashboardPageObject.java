package actions.pageObjects;

import org.openqa.selenium.WebDriver;

import actions.commons.AbstractPages;
import interfaces.pageUIs.MyDashBoradPageUI;

public class MyDashboardPageObject extends AbstractPages {

	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountLinkDisplayed(String value) {
		waitToElementDisplayedByXpath(driver, MyDashBoradPageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, MyDashBoradPageUI.MY_ACCOUNT_LINK);
	}
}
