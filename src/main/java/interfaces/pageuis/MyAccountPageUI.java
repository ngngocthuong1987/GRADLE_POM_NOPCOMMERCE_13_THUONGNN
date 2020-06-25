package interfaces.pageuis;

public class MyAccountPageUI {

    //Dynamic locators
    public static final String DYNAMIC_LOCATOR_INPUT_ELEMENTS = "//input[@id='%s']";
    public static final String DYNAMIC_LOCATOR_SUBMIT_BUTTON_ELEMENTS = "//input[@value='%s']";
    public static final String DYNAMIC_LOCATOR_SELECT_ELEMENTS = "//select[@name='%s']";
    public static final String DYNAMIC_LOCATOR_MENU_ELEMENTS = "//div[@class='listbox']//a[contains(text(), '%s')]";

    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
}
