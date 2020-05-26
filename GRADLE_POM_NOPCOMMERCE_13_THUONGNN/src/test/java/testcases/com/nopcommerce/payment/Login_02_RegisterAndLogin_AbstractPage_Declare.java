package testcases.com.nopcommerce.payment;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.commons.AbstractPage;

public class Login_02_RegisterAndLogin_AbstractPage_Declare {

	WebDriver driver;
	String email;
	AbstractPage abstractPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "thuongnn_" + randomNumber() + "@gmail.com";
		abstractPage = new AbstractPage(driver);
		abstractPage.openUrl("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register() {

		//Click to Register page
		abstractPage.clickToElement("//a[@class='ico-register' and text()='Register']");

		//Verify Register page display
		abstractPage.isElementDisplay("//div[@class='page registration-page']");

		//Click Gender radio button
		abstractPage.clickToElement("//input[@id='gender-male']");

		//Input to Firstname textbox
		abstractPage.sendKeyToElement("//input[@id='FirstName']", "Thuong");

		//Input to Lastname textbox
		abstractPage.sendKeyToElement("//input[@id='LastName']", "Nguyen");

		//Select Date of birth dropdown
		abstractPage.selectItemInHtmlDropdown("//select[@name='DateOfBirthDay']", "16");

		abstractPage.selectItemInHtmlDropdown("//select[@name='DateOfBirthMonth']", "February");

		abstractPage.selectItemInHtmlDropdown("//select[@name='DateOfBirthYear']", "1987");

		//Input to Email textbox
		abstractPage.sendKeyToElement("//input[@id='Email']", email);

		//Input to Company textbox
		abstractPage.sendKeyToElement("//input[@id='Company']", "FPT Software Company");

		//Input to Password textbox
		abstractPage.sendKeyToElement("//input[@id='Password']", "abc123456");

		//Input to Confirm Password textbox
		abstractPage.sendKeyToElement("//input[@id='ConfirmPassword']", "abc123456");

		//Click to Register button
		abstractPage.clickToElement("//input[@id='register-button']");

		//Verify register is success
		abstractPage.isElementDisplay("//div[@class='result' and text()='Your registration completed']");

		//Click to Logout page
		abstractPage.clickToElement("//a[@class='ico-logout' and text()='Log out']");

		//Verify navigate to Home page
		Assert.assertEquals(abstractPage.getCurrentUrl(), "https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_02_Login() {

		//Click to Login page
		abstractPage.clickToElement("//a[@class='ico-login' and text()='Log in']");

		//Verify Login page display
		abstractPage.isElementDisplay("//div[@class='page login-page']");

		//Input to Email textbox
		abstractPage.sendKeyToElement("//input[@id='Email']", email);

		//Input to Password textbox
		abstractPage.sendKeyToElement("//input[@id='Password']", "abc123456");

		//Click to Login button
		abstractPage.clickToElement("//input[@type='submit' and @value='Log in']");

		//Verify My account link display
		abstractPage.isElementDisplay("//a[@class='ico-account' and text()='My account']");
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
