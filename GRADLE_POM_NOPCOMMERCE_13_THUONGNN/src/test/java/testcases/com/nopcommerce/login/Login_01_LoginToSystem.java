package testcases.com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.pageObjects.HomePageObject;
import actions.pageObjects.LoginPageObject;
import actions.pageObjects.MyDashboardPageObject;

public class Login_01_LoginToSystem {

	private WebDriver driver;
	private HomePageObject homePageObject;
	private LoginPageObject loginPageObject;
	private MyDashboardPageObject myDashboardPageObject;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		homePageObject = new HomePageObject(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		loginPageObject = homePageObject.clickToLoginPage();

		loginPageObject.inputToEmailTextBox("");
		loginPageObject.inputToPasswordTextBox("");
		loginPageObject.clickToLoginButton();

		Assert.assertTrue(loginPageObject.isErrorEmailMessageDisplayed("Please enter your email"));
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		loginPageObject = homePageObject.clickToLoginPage();

		loginPageObject.inputToEmailTextBox("123123");
		loginPageObject.inputToPasswordTextBox("");
		loginPageObject.clickToLoginButton();

		Assert.assertTrue(loginPageObject.isErrorEmailMessageDisplayed("Wrong email"));
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail() {
		loginPageObject = homePageObject.clickToLoginPage();

		loginPageObject.inputToEmailTextBox("thuongnn_" + randomNumber() + "@gmail.com");
		loginPageObject.inputToPasswordTextBox("");
		loginPageObject.clickToLoginButton();

		Assert.assertTrue(loginPageObject.isErrorValidateMessageDisplayed("Login was unsuccessful. Please correct the errors and try again."));
	}

	@Test
	public void TC_04_LoginWithPasswordLessThan6Chars() {
		loginPageObject = homePageObject.clickToLoginPage();

		loginPageObject.inputToEmailTextBox("thuongnn_434204@gmail.com");
		loginPageObject.inputToPasswordTextBox("1234");
		loginPageObject.clickToLoginButton();

		Assert.assertTrue(loginPageObject.isErrorValidateMessageDisplayed("Login was unsuccessful. Please correct the errors and try again."));
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {
		loginPageObject = homePageObject.clickToLoginPage();

		loginPageObject.inputToEmailTextBox("thuongnn_434204@gmail.com");
		loginPageObject.inputToPasswordTextBox("0987654321");
		loginPageObject.clickToLoginButton();

		Assert.assertTrue(loginPageObject.isErrorValidateMessageDisplayed("Login was unsuccessful. Please correct the errors and try again."));
	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		loginPageObject = homePageObject.clickToLoginPage();

		loginPageObject.inputToEmailTextBox("thuongnn_434204@gmail.com");
		loginPageObject.inputToPasswordTextBox("abc123456");
		loginPageObject.clickToLoginButton();
		myDashboardPageObject = new MyDashboardPageObject(driver);

		Assert.assertTrue(myDashboardPageObject.isMyAccountLinkDisplayed("Wrong email"));
	}


	@AfterClass
	public void afterClass() {
		//Quit browser
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
