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
import testdata.Payment.LoginData;

public class Login_06_RegisterAndLogin_MultiBrowser extends AbstractTest {
	AbstractPage abstractPage;

	private WebDriver driver;
	private String email = "thuongnn_" + randomNumber() + "@gmail.com";
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
		registerPageObject.inputFistName(LoginData.FIRST_NAME);
		Thread.sleep(2000);
		registerPageObject.inputLastName(LoginData.LAST_NAME);
		registerPageObject.selectBirthDay(LoginData.BIRTH_DAY);
		registerPageObject.selectBirthMonth(LoginData.BIRTH_MONTH);
		registerPageObject.selectBirthYear(LoginData.BIRTH_YEAR);
		registerPageObject.inputEmail(email);
		registerPageObject.inputCompanyName(LoginData.COMPANY);
		registerPageObject.inputPassword(LoginData.PASSWORD);
		registerPageObject.inputConfirmPassword(LoginData.PASSWORD);
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
		loginPageObject.inputToPasswordTextBox(LoginData.PASSWORD);
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
