package actions.pageobjects;

import actions.commons.AbstractPages;
import interfaces.pageuis.MyAccountPageUI;

import org.openqa.selenium.WebDriver;

public class MyAccountPageObject extends AbstractPages {

    private WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToElement(String idElement) {
        waitToElementDisplayedByXpath(driver, MyAccountPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement);
        clickToElement(driver, MyAccountPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement);
    }

    public void clickToButton(String nameElement) {
        waitToElementDisplayedByXpath(driver, MyAccountPageUI.DYNAMIC_LOCATOR_SUBMIT_BUTTON_ELEMENTS, nameElement);
        clickToElement(driver, MyAccountPageUI.DYNAMIC_LOCATOR_SUBMIT_BUTTON_ELEMENTS, nameElement);
    }

    public void inputDataToElement(String idElement, String valueInput) {
        waitToElementDisplayedByXpath(driver, MyAccountPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement);
        sendKeyToElement(driver, MyAccountPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement, valueInput);
    }

    public void selectElement(String nameElement, String valueItem) {
        waitToElementDisplayedByXpath(driver, MyAccountPageUI.DYNAMIC_LOCATOR_SELECT_ELEMENTS, nameElement);
        selectItemInHtmlDropdown(driver, MyAccountPageUI.DYNAMIC_LOCATOR_SELECT_ELEMENTS, nameElement, valueItem);
    }

    public String getCustomerInfo(String idElement, String typeElement) {
        if ("input".equals(typeElement)) {
            waitToElementDisplayedByXpath(driver, MyAccountPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement);
            return getAttributeValueXpath(driver, MyAccountPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement);
        } else {
            waitToElementDisplayedByXpath(driver, MyAccountPageUI.DYNAMIC_LOCATOR_SELECT_ELEMENTS, idElement);
            return getSelectItemInHtmlDropdown(driver, MyAccountPageUI.DYNAMIC_LOCATOR_SELECT_ELEMENTS, idElement).getText();
        }
    }

    public void clickToMyAccountMenu(String nameElement) {
        waitToElementDisplayedByXpath(driver, MyAccountPageUI.DYNAMIC_LOCATOR_MENU_ELEMENTS, nameElement);
        clickToElement(driver, MyAccountPageUI.DYNAMIC_LOCATOR_MENU_ELEMENTS, nameElement);
    }
}
