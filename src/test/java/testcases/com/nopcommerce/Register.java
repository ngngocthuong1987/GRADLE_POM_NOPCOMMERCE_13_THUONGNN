package testcases.com.nopcommerce;

import actions.commons.AbstractTest;
import actions.commons.Function;
import actions.commons.PageGeneratorManager;
import actions.pageobjects.HomePageObject;
import actions.pageobjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testdata.com.nopcommerce.RegisterData;

public class Register extends AbstractTest {

    protected static String email;
    private WebDriver driver;
    private HomePageObject homePageObject;
    private RegisterPageObject registerPageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        homePageObject = PageGeneratorManager.getHomePageObject(driver);
        email = "thuongnn_" + Function.randomNumber() + "@gmail.com";
    }

    @BeforeMethod
    public void goToRegisterPage() {
        registerPageObject = homePageObject.clickToRegisterPage();
    }

    @Test
    public void testCase01RegisterWithEmptyData() {
        registerPageObject.clickToElement("register-button");

        Assert.assertEquals(registerPageObject.getErrorMessage("FirstName"), RegisterData.REQUIRED_FIRST_NAME_MESSAGE);
        Assert.assertEquals(registerPageObject.getErrorMessage("LastName"), RegisterData.REQUIRED_LAST_NAME_MESSAGE);
        Assert.assertEquals(registerPageObject.getErrorMessage("Email"), RegisterData.REQUIRED_EMAIL_MESSAGE);
        Assert.assertEquals(registerPageObject.getErrorMessage("Password"), RegisterData.REQUIRED_PASSWORD_MESSAGE);
        Assert.assertEquals(registerPageObject.getErrorMessage("ConfirmPassword"), RegisterData.REQUIRED_PASSWORD_MESSAGE);
    }

    @Test
    public void testCase02RegisterWithInvalidEmail() {
        registerPageObject.clickToElement("gender-male");
        registerPageObject.inputDataToElement("FirstName", RegisterData.FIRST_NAME);
        registerPageObject.inputDataToElement("LastName", RegisterData.LAST_NAME);
        registerPageObject.selectElement("DateOfBirthDay", RegisterData.BIRTH_DAY);
        registerPageObject.selectElement("DateOfBirthMonth", RegisterData.BIRTH_MONTH);
        registerPageObject.selectElement("DateOfBirthYear", RegisterData.BIRTH_YEAR);
        registerPageObject.inputDataToElement("Email", RegisterData.WRONG_EMAIL);
        registerPageObject.inputDataToElement("Company", RegisterData.COMPANY);
        registerPageObject.inputDataToElement("Password", RegisterData.PASSWORD);
        registerPageObject.inputDataToElement("ConfirmPassword", RegisterData.PASSWORD);
        registerPageObject.clickToElement("register-button");

        Assert.assertEquals(registerPageObject.getErrorMessage("Email"), RegisterData.WRONG_EMAIL_MESSAGE);
    }

    @Test
    public void testCase03RegisterWithExistEmail() {
        registerPageObject.clickToElement("gender-male");
        registerPageObject.inputDataToElement("FirstName", RegisterData.FIRST_NAME);
        registerPageObject.inputDataToElement("LastName", RegisterData.LAST_NAME);
        registerPageObject.selectElement("DateOfBirthDay", RegisterData.BIRTH_DAY);
        registerPageObject.selectElement("DateOfBirthMonth", RegisterData.BIRTH_MONTH);
        registerPageObject.selectElement("DateOfBirthYear", RegisterData.BIRTH_YEAR);
        registerPageObject.inputDataToElement("Email", RegisterData.EXIST_EMAIL);
        registerPageObject.inputDataToElement("Company", RegisterData.COMPANY);
        registerPageObject.inputDataToElement("Password", RegisterData.PASSWORD);
        registerPageObject.inputDataToElement("ConfirmPassword", RegisterData.PASSWORD);
        registerPageObject.clickToElement("register-button");

        Assert.assertEquals(registerPageObject.getErrorMessage(null), RegisterData.EXIST_EMAIL_MESSAGE);
    }

    @Test
    public void testCase04RegisterWithExistEmail() {
        registerPageObject.clickToElement("gender-male");
        registerPageObject.inputDataToElement("FirstName", RegisterData.FIRST_NAME);
        registerPageObject.inputDataToElement("LastName", RegisterData.LAST_NAME);
        registerPageObject.selectElement("DateOfBirthDay", RegisterData.BIRTH_DAY);
        registerPageObject.selectElement("DateOfBirthMonth", RegisterData.BIRTH_MONTH);
        registerPageObject.selectElement("DateOfBirthYear", RegisterData.BIRTH_YEAR);
        registerPageObject.inputDataToElement("Email", RegisterData.EXIST_EMAIL);
        registerPageObject.inputDataToElement("Company", RegisterData.COMPANY);
        registerPageObject.inputDataToElement("Password", RegisterData.PASSWORD_LESS_THAN_6_CHARS);
        registerPageObject.inputDataToElement("ConfirmPassword", RegisterData.PASSWORD_LESS_THAN_6_CHARS);
        registerPageObject.clickToElement("register-button");

        Assert.assertEquals(registerPageObject.getErrorMessage("Password"), RegisterData.PASSWORD_LESS_THAN_6_CHARS_MESSAGE);
    }

    @Test
    public void testCase05RegisterWithPasswordNotMatch() {
        registerPageObject.clickToElement("gender-male");
        registerPageObject.inputDataToElement("FirstName", RegisterData.FIRST_NAME);
        registerPageObject.inputDataToElement("LastName", RegisterData.LAST_NAME);
        registerPageObject.selectElement("DateOfBirthDay", RegisterData.BIRTH_DAY);
        registerPageObject.selectElement("DateOfBirthMonth", RegisterData.BIRTH_MONTH);
        registerPageObject.selectElement("DateOfBirthYear", RegisterData.BIRTH_YEAR);
        registerPageObject.inputDataToElement("Email", email);
        registerPageObject.inputDataToElement("Company", RegisterData.COMPANY);
        registerPageObject.inputDataToElement("Password", RegisterData.PASSWORD);
        registerPageObject.inputDataToElement("ConfirmPassword", RegisterData.CONFIRM_PASSWORD_NOT_MATCH);
        registerPageObject.clickToElement("register-button");

        Assert.assertEquals(registerPageObject.getErrorMessage("ConfirmPassword"), RegisterData.PASSWORD_NOT_MATCH_MESSAGE);
    }

    @Test
    public void testCase06RegisterSuccess() {
        registerPageObject.clickToElement("gender-male");
        registerPageObject.inputDataToElement("FirstName", RegisterData.FIRST_NAME);
        registerPageObject.inputDataToElement("LastName", RegisterData.LAST_NAME);
        registerPageObject.selectElement("DateOfBirthDay", RegisterData.BIRTH_DAY);
        registerPageObject.selectElement("DateOfBirthMonth", RegisterData.BIRTH_MONTH);
        registerPageObject.selectElement("DateOfBirthYear", RegisterData.BIRTH_YEAR);
        registerPageObject.inputDataToElement("Email", email);
        registerPageObject.inputDataToElement("Company", RegisterData.COMPANY);
        registerPageObject.inputDataToElement("Password", RegisterData.PASSWORD);
        registerPageObject.inputDataToElement("ConfirmPassword", RegisterData.PASSWORD);
        registerPageObject.clickToElement("register-button");

        Assert.assertEquals(registerPageObject.getSuccessMessage(), RegisterData.REGISTER_SUCCESS_MESSAGE);
    }

    @AfterClass
    public void afterClass() {
        //Quit browser
        driver.quit();
    }
}
