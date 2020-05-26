package testcases.com.nopcommerce.payment;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actions.commons.AbstractPage;
import actions.commons.AbstractTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.HomePageObject;
import actions.pageObjects.LoginPageObject;
import actions.pageObjects.RegisterPageObject;

public class Login_06_RegisterAndLogin_MultiBrowser extends AbstractTest {
	AbstractPage abstractPage;

	private WebDriver driver;
	private String email = "thuongnn_" + randomNumber() + "@gmail.com";
	private String password = "abc123456";
	private HomePageObject homePageObject;
	private LoginPageObject loginPageObject;

	private RegisterPageObject registerPageObject;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);

		homePageObject = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void TC_01_Register() throws InterruptedException {

		registerPageObject = homePageObject.clickToRegisterPage();
		Thread.sleep(2000);
		registerPageObject.selectMaleGender();
		Thread.sleep(2000);
		registerPageObject.inputFistName("Thuong");
		Thread.sleep(2000);
		registerPageObject.inputLastName("Nguyen");
		registerPageObject.selectBirthDay("16");
		registerPageObject.selectBirthMonth("February");
		registerPageObject.selectBirthYear("1987");
		registerPageObject.inputEmail(email);
		registerPageObject.inputCompanyName("FPT Software Company");
		registerPageObject.inputPassword(password);
		registerPageObject.inputConfirmPassword(password);
		registerPageObject.clickRegisterButton();

		registerPageObject.isRegistSuccess();

		Thread.sleep(2000);
		homePageObject = registerPageObject.clickToLogOutLink();
	}

	@Test
	public void TC_02_Login() throws InterruptedException {
		Thread.sleep(2000);
		loginPageObject = homePageObject.clickToLoginPage();

		loginPageObject.inputToEmailTextBox(email);
		loginPageObject.inputToPasswordTextBox(password);
		homePageObject = loginPageObject.clickToLoginButton();

		homePageObject.isLoginSuccess();
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
