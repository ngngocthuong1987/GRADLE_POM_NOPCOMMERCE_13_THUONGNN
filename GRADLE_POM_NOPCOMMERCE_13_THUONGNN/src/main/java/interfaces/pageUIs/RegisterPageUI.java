package interfaces.pageUIs;

public class RegisterPageUI {
	public static final String GENDER_MALE = "//input[@id='gender-male']";
	public static final String FIRST_NAME = "//input[@id='FirstName']";
	public static final String LAST_NAME = "//input[@id='LastName']";
	public static final String BIRTH_DAY = "//select[@name='DateOfBirthDay']";
	public static final String BIRTH_MONTH = "//select[@name='DateOfBirthMonth']";
	public static final String BIRTH_YEAR = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL = "//input[@id='Email']";
	public static final String PASSWORD = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//input[@id='register-button']";
	public static final String COMPANY = "//input[@id='Company']";
	public static final String REGIST_SUCCESS = "//div[@class='result' and text()='Your registration completed']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout' and text()='Log out']";
}
