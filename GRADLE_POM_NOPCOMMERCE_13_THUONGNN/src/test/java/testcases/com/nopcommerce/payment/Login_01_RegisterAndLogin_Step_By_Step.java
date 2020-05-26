package testcases.com.nopcommerce.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_01_RegisterAndLogin_Step_By_Step {

	WebDriver driver;
	String email;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "thuongnn_" + randomNumber() + "@gmail.com";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register() {

		//Click to Register page
		driver.findElement(By.xpath("//a[@class='ico-register' and text()='Register']")).click();

		//Verify Register page display
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page registration-page']")).isDisplayed());

		//Click Gender radio button
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();

		//Input to Firstname textbox
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Thuong");

		//Input to Lastname textbox
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nguyen");

		//Select Date of birth dropdown
		Select daySelection = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		daySelection.selectByVisibleText("16");

		Select monthSelection = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		monthSelection.selectByVisibleText("February");

		Select yearSelection = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		yearSelection.selectByVisibleText("1987");

		//Input to Email textbox
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);

		//Input to Company textbox
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("FPT Software Company");

		//Input to Password textbox
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abc123456");

		//Input to Confirm Password textbox
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("abc123456");

		//Click to Register button
		driver.findElement(By.xpath("//input[@id='register-button']")).click();

		//Verify register is success
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result' and text()='Your registration completed']")).isDisplayed());

		//Click to Logout page
		driver.findElement(By.xpath("//a[@class='ico-logout' and text()='Log out']")).click();

		//Verify navigate to Home page
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_02_Login() {

		//Click to Login page
		driver.findElement(By.xpath("//a[@class='ico-login' and text()='Log in']")).click();

		//Verify Login page display
		driver.findElement(By.xpath("//div[@class='page login-page']")).isDisplayed();

		//Input to Email textbox
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);

		//Input to Password textbox
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abc123456");

		//Click to Login button
		driver.findElement(By.xpath("//input[@type='submit' and @value='Log in']")).click();

		//Verify My account link display
		driver.findElement(By.xpath("//a[@class='ico-account' and text()='My account']")).isDisplayed();
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
