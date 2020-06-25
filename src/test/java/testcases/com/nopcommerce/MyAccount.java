package testcases.com.nopcommerce;

import actions.commons.AbstractTest;
import actions.commons.PageGeneratorManager;
import actions.pageobjects.HomePageObject;
import actions.pageobjects.LoginPageObject;
import actions.pageobjects.MyAccountPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testdata.com.nopcommerce.LoginData;
import testdata.com.nopcommerce.MyAccountData;

public class MyAccount extends AbstractTest {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private LoginPageObject loginPageObject;
    private MyAccountPageObject myAccountPageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        homePageObject = PageGeneratorManager.getHomePageObject(driver);
        loginPageObject = homePageObject.clickToLoginPage();

        loginPageObject.inputDataToElement("Email", Register.email);
        loginPageObject.inputDataToElement("Password", LoginData.PASSWORD);
        homePageObject = loginPageObject.clickToLoginButton();
    }

    @BeforeMethod
    public void goToMyAccountPage() {
        myAccountPageObject = homePageObject.clickToMyAccountPage();
    }

    @Test
    public void testCase01CustomerInfo() {
        myAccountPageObject.clickToElement("gender-female");
        myAccountPageObject.inputDataToElement("FirstName", MyAccountData.UPDATE_FIRST_NAME);
        myAccountPageObject.inputDataToElement("LastName", MyAccountData.UPDATE_LAST_NAME);
        myAccountPageObject.selectElement("DateOfBirthDay", MyAccountData.UPDATE_BIRTH_DAY);
        myAccountPageObject.selectElement("DateOfBirthMonth", MyAccountData.UPDATE_BIRTH_MONTH);
        myAccountPageObject.selectElement("DateOfBirthYear", MyAccountData.UPDATE_BIRTH_YEAR);
        myAccountPageObject.inputDataToElement("Email", MyAccountData.UPDATE_EMAIL);
        myAccountPageObject.inputDataToElement("Company", MyAccountData.UPDATE_COMPANY);
        myAccountPageObject.clickToButton("Save");

        Assert.assertEquals(myAccountPageObject.getCustomerInfo("FirstName", "input"), MyAccountData.UPDATE_FIRST_NAME);
        Assert.assertEquals(myAccountPageObject.getCustomerInfo("LastName", "input"), MyAccountData.UPDATE_LAST_NAME);
        Assert.assertEquals(myAccountPageObject.getCustomerInfo("DateOfBirthDay", "select"), MyAccountData.UPDATE_BIRTH_DAY);
        Assert.assertEquals(myAccountPageObject.getCustomerInfo("DateOfBirthMonth", "select"), MyAccountData.UPDATE_BIRTH_MONTH);
        Assert.assertEquals(myAccountPageObject.getCustomerInfo("DateOfBirthYear", "select"), MyAccountData.UPDATE_BIRTH_YEAR);
        Assert.assertEquals(myAccountPageObject.getCustomerInfo("Email", "input"), MyAccountData.UPDATE_EMAIL);
        Assert.assertEquals(myAccountPageObject.getCustomerInfo("Company", "input"), MyAccountData.UPDATE_COMPANY);
    }

    @Test
    public void testCase02AddAddressesInfo() {
        myAccountPageObject.clickToMyAccountMenu("Addresses");
        myAccountPageObject.clickToButton("Add new");

        myAccountPageObject.inputDataToElement("Address_FirstName", MyAccountData.UPDATE_FIRST_NAME);
        myAccountPageObject.inputDataToElement("Address_LastName", MyAccountData.UPDATE_LAST_NAME);
        myAccountPageObject.inputDataToElement("Address_Email", MyAccountData.UPDATE_EMAIL);
        myAccountPageObject.inputDataToElement("Address_Company", MyAccountData.UPDATE_COMPANY);
    }

    @AfterClass
    public void afterClass() {

        //Quit browser
        driver.quit();
    }
}
