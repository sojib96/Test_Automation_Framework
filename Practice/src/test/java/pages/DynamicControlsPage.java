package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;

public class DynamicControlsPage extends Form {
    private final static String NAME = "Dynamic Controls";
    private final By enableDisableButtonLocator = By.xpath("//*[@id='input-example']/button");
    private final By inputTextBoxLocator = By.xpath("//*[@id='input-example']/input");
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private IButton enableDisableBtn = elementFactory.getButton(enableDisableButtonLocator, "Enable Disable Button");
    private ITextBox inputTxtBox = elementFactory.getTextBox(inputTextBoxLocator, "Input Text Box");


    public DynamicControlsPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME)), NAME);
    }

    public void clickEnableButton() {
        enableDisableBtn.click();
    }

    public boolean isTextBoxEnabled() {
        return inputTxtBox.state().waitForEnabled();
    }

    public void sendRandomText(String text) {
        inputTxtBox.clearAndType(text);
    }

    public String getValueOfInputBox() {
        inputTxtBox.state().waitForDisplayed();
        return inputTxtBox.getValue();
    }

}
