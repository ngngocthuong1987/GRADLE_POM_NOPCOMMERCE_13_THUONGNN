package actions.pageobjects;

import actions.commons.AbstractPages;
import interfaces.pageuis.RegisterPageUI;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends AbstractPages {

    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToElement(String idElement) {
        waitToElementDisplayedByXpath(driver, RegisterPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement);
        clickToElement(driver, RegisterPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement);
    }

    public void inputDataToElement(String idElement, String valueInput) {
        waitToElementDisplayedByXpath(driver, RegisterPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement);
        sendKeyToElement(driver, RegisterPageUI.DYNAMIC_LOCATOR_INPUT_ELEMENTS, idElement, valueInput);
    }

    public void selectElement(String nameElement, String valueItem) {
        waitToElementDisplayedByXpath(driver, RegisterPageUI.DYNAMIC_LOCATOR_SELECT_ELEMENTS, nameElement);
        selectItemInHtmlDropdown(driver, RegisterPageUI.DYNAMIC_LOCATOR_SELECT_ELEMENTS, nameElement, valueItem);
    }

    public String getErrorMessage(String nameElement) {
        if (StringUtils.isNotEmpty(nameElement)) {
            waitToElementDisplayedByCss(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, nameElement);
            return getTextElementByCss(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE, nameElement);
        } else {
            return getTextElementByCss(driver, RegisterPageUI.EXIST_EMAIL_MESSAGE);
        }

    }

    public String getSuccessMessage() {
        return getTextElementByCss(driver, RegisterPageUI.REGIST_SUCCESS_MESSAGE);
    }

}
