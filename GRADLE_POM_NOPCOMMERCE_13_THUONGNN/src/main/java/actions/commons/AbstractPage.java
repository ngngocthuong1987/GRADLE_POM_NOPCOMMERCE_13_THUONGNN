package actions.commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	public WebDriver driver;
	public Actions action;
	public Select select;
	JavascriptExecutor jsExecutor;
	WebDriverWait waitExplicit;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Open maxium browser with an Url
	 *
	 * @param url The url value need access
	 */
	public void openUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/**
	 * Get the title of the current page.
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Get the current URL that the browser is looking at
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Move back in the browser's history
	 */
	public void back() {
		driver.navigate().back();
	}

	/**
	 * Refresh the current page
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * Click OK button in alert
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * Click Cancel button in alert
	 */
	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Get text in alert
	 */
	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	/**
	 * Input value into alert
	 */
	public void sendKeyToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public WebElement findElementByXpath(String locator) {
		return driver.findElement(byXpath(locator));
	}

	public List<WebElement> findElementsByXpath(String locator){
		return driver.findElements(byXpath(locator));
	}

	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(String locator) {
		findElementByXpath(locator).click();
	}

	public void sendKeyToElement(String locator, String value) {
		findElementByXpath(locator).sendKeys(value);
	}

	public void selectItemInHtmlDropdown(String locator, String value) {
		select = new Select(findElementByXpath(locator));
		select.selectByVisibleText(value);
	}

	public WebElement getSelectItemInHtmlDropdown(String locator) {
		select = new Select(findElementByXpath(locator));
		return select.getFirstSelectedOption();
	}

	public void selectItemInCustomDropdown(String dropdownLocator,
			String allItemInDropdownLocator,
			String expectedItemValue) throws InterruptedException {
		jsExecutor = (JavascriptExecutor) driver;
		waitExplicit = new WebDriverWait(driver, 30);

		// Click in dropdown for display all items
		WebElement paretnDropdown = findElementByXpath(dropdownLocator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", paretnDropdown);
		Thread.sleep(2000);
		jsExecutor.executeScript("arguments[0].click();", paretnDropdown);
		Thread.sleep(2000);

		// Wait all items loaded
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(allItemInDropdownLocator)));

		// Loop and get expected item
		List<WebElement> allItems = findElementsByXpath(allItemInDropdownLocator);
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedItemValue)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				Thread.sleep(1000);
				item.click();
				break;
			}
		}
	}

	public String getAttributeValue(String locator, String attributeName) {
		return findElementByXpath(locator).getAttribute(attributeName);
	}

	public String getTextElement(String locator) {
		return findElementByXpath(locator).getText();
	}

	public int countElementNumber(String locator) {
		return findElementsByXpath(locator).size();
	}

	public boolean isElementDisplay(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}

	public boolean isElementSelected(String locator) {
		return findElementByXpath(locator).isSelected();
	}

	public boolean isElementEnabled(String locator) {
		return findElementByXpath(locator).isEnabled();
	}

	/**
	 * Switch to another window by page tile
	 *
	 * @param title The title of window need switch
	 */
	public void switchToWindowByTile(String title) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			driver.switchTo().window(runWindow);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	/**
	 * Close all window with out parrent window
	 *
	 * @param parrentWindowTitle The title of parent window
	 */
	public void closeAllWindowsWithoutParent(String parrentWindowTitle) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			if (!runWindow.equals(parrentWindowTitle)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
	}

	public void switchToFrame(String locator) {
		driver.switchTo().frame(findElementByXpath(locator));
	}

	public void doubleClickToElement(String locator) {
		action = new Actions(driver);
		action.doubleClick(findElementByXpath(locator)).perform();
	}

	public void hoverMouseToElement(String locator) {
		action = new Actions(driver);
		action.moveToElement(findElementByXpath(locator)).perform();
	}

	public void rightClick(String locator) {
		action = new Actions(driver);
		action.contextClick(findElementByXpath(locator)).perform();
	}

	public void dragAndDrop(String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(findElementByXpath(sourceLocator), findElementByXpath(targetLocator)).perform();
	}

	public void sendKeyboardToElement(String locator, String value) {
		action = new Actions(driver);
		action.sendKeys(findElementByXpath(locator), value).perform();
	}
}
