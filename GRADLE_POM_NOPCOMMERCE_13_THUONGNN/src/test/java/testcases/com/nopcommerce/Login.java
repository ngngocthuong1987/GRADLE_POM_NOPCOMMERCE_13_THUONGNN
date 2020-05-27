package testcases.com.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actions.commons.AbstractTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.HomePageObject;
import actions.pageObjects.LoginPageObject;
import testdata.RegisterData;

public class Login extends AbstractTest {

	private WebDriver driver;
	private HomePageObject homePageObject;
	private LoginPageObject loginPageObject;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		homePageObject = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void testCase01RegisterEmptyData() throws InterruptedException {
		loginPageObject = homePageObject.clickToLoginPage();
		loginPageObject.clickToLoginButton();

		Assert.assertEquals(loginPageObject.getErrorMessage("FirstName"), RegisterData.REQUIRED_FIRST_NAME_MESSAGE);

	}

	@AfterClass
	public void afterClass() {

		//Quit browser
		driver.quit();
	}
}
