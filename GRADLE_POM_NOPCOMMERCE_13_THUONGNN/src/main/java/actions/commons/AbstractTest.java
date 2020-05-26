package actions.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;

	public WebDriver getBrowser(String browserName) {
		if ("firefox".equalsIgnoreCase(browserName)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if ("headless_firefox".equalsIgnoreCase(browserName)) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if ("chrome".equalsIgnoreCase(browserName)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if ("headless_chrome".equalsIgnoreCase(browserName)) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}

		driver.get(Constants.URL);
		driver.manage().window().maximize();
		return driver;
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				//				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				//				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			//			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				//				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				//				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			//			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			//			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			//			log.info(" -------------------------- FAILED -------------------------- ");
			//			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
