package interfaces.pageuis;

public class RegisterPageUI {

    //Dynamic locators
    public static final String DYNAMIC_LOCATOR_INPUT_ELEMENTS = "//input[@id='%s']";
    public static final String DYNAMIC_LOCATOR_SELECT_ELEMENTS = "//select[@name='%s']";
    public static final String DYNAMIC_ERROR_MESSAGE = "#%s-error";

    //Other locators
    public static final String EXIST_EMAIL_MESSAGE = ".message-error li";
    public static final String REGIST_SUCCESS_MESSAGE = ".result";

}
