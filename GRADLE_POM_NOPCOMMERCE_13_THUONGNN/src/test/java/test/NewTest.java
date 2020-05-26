package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest extends AbstractTest {

	WebDriver driver;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowser(browserName);
	}

	@Test
	public void TC_01() {
		Assert.assertEquals(driver.getCurrentUrl(), "AAAA");
	}

	@Test
	public void TC_02() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://vnexpress.net/");
	}

	@Test
	public void TC_03() {
		By element = By.xpath("//li[@class='thethao']//a[@href='/the-thao']");
		findElm(driver, element).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(), "https://vnexpress.net/the-thao");
	}

	@AfterMethod
	public void getResultTest(ITestResult result) throws Exception
	{

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public static WebElement findElm(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
