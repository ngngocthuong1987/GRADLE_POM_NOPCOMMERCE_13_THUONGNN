package testcases.com.nopcommerce;

import actions.commons.AbstractTest;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageobjects.HomePageObject;
import actions.pageobjects.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testdata.com.nopcommerce.LoginData;

public class Login extends AbstractTest {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private LoginPageObject loginPageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        homePageObject = PageGeneratorManager.getHomePageObject(driver);
    }

    @BeforeMethod
    public void goToLoginPage() {
        loginPageObject = homePageObject.clickToLoginPage();
    }

    @Test
    public void testCase01LoginEmptyData() {
        loginPageObject.clickToLoginButton();

        Assert.assertEquals(loginPageObject.getErrorMessage("Email"), LoginData.REQUIRED_EMAIL_MESSAGE);
    }

    @Test
    public void testCase02LoginInvalidEmail() {
        loginPageObject.inputDataToElement("Email", LoginData.WRONG_EMAIL);
        loginPageObject.inputDataToElement("Password", LoginData.PASSWORD);
        loginPageObject.clickToLoginButton();

        Assert.assertEquals(loginPageObject.getErrorMessage("Email"), LoginData.WRONG_EMAIL_MESSAGE);
    }

    @Test
    public void testCase03LoginWithEmailNotRegist() {
        loginPageObject.inputDataToElement("Email", LoginData.NOT_REGIST_EMAIL);
        loginPageObject.inputDataToElement("Password", LoginData.PASSWORD);
        loginPageObject.clickToLoginButton();

        Assert.assertEquals(loginPageObject.getErrorMessage(null), LoginData.NOT_REGIST_EMAIL_MESSAGE);
    }

    @Test
    public void testCase04LoginWithEmptyPassword() {
        loginPageObject.inputDataToElement("Email", Register.email);
        loginPageObject.clickToLoginButton();

        Assert.assertEquals(loginPageObject.getErrorMessage(null), LoginData.WRONG_PASSWORD_MESSAGE);
    }

    @Test
    public void testCase05LoginWithWrongPassword() {
        loginPageObject.inputDataToElement("Email", Register.email);
        loginPageObject.inputDataToElement("Password", LoginData.WRONG_PASSWORD);
        loginPageObject.clickToLoginButton();

        Assert.assertEquals(loginPageObject.getErrorMessage(null), LoginData.WRONG_PASSWORD_MESSAGE);
    }

    @Test
    public void testCase06LoginSuccess() {
        loginPageObject.inputDataToElement("Email", Register.email);
        loginPageObject.inputDataToElement("Password", LoginData.PASSWORD);
        homePageObject = loginPageObject.clickToLoginButton();

        Assert.assertEquals(homePageObject.getCurrentUrl(driver), Constants.URL);
    }

    @AfterClass
    public void afterClass() {

        //Quit browser
        driver.quit();
    }
}
