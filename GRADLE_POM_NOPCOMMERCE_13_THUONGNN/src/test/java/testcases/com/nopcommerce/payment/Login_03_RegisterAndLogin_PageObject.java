package testcases.com.nopcommerce.payment;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.commons.AbstractPage;
import actions.pageObjects.HomePageObject;
import actions.pageObjects.LoginPageObject;
import actions.pageObjects.RegisterPageObject;

public class Login_03_RegisterAndLogin_PageObject {
	AbstractPage abstractPage;

	private WebDriver driver;
	private String email = "thuongnn_" + randomNumber() + "@gmail.com";
	private String password = "abc123456";
	private HomePageObject homePageObject;
	private LoginPageObject loginPageObject;

	private RegisterPageObject registerPageObject;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".//libraries//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		homePageObject = new HomePageObject(driver);
	}

	@Test
	public void TC_01_Register() {

		registerPageObject = homePageObject.clickToRegisterPage();

		registerPageObject.selectMaleGender();
		registerPageObject.inputFistName("Thuong");
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
		homePageObject = registerPageObject.clickToLogOutLink();
	}

	@Test
	public void TC_02_Login() {
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
