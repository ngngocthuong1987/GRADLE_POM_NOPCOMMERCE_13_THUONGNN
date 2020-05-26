package interfaces.pageUIs;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String LOGIN_BUTTON = "//input[@value='Log in']";
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error' and text()='%s']";
	public static final String VALIDTE_EMAIL_ERROR_MESSAGE = "//div[@class='message-error validation-summary-errors' and text()='%s']";
}
