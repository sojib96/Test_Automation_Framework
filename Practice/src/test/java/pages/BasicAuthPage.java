package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;

public class BasicAuthPage extends Form {
    private static final String NAME = "Basic Auth";
    private final By successMsgLocator = By.xpath("//*[@class='example']/p");
    private final ILabel successMsg = AqualityServices.getElementFactory().getLabel(successMsgLocator, "Success Message");

    public BasicAuthPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME)), NAME);
    }

    public boolean isSuccessMsgDisplayed() {
        return successMsg.state().isDisplayed();
    }
}
