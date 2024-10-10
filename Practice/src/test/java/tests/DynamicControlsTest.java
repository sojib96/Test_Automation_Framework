package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import pages.DynamicControlsPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class DynamicControlsTest extends BaseTest {
    private final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    private final String randomText = UUID.randomUUID().toString();

    @Test
    public void dynamicControlsTest() {
        mainPage.clickNavigationLink(MainPageNavigation.DYNAMIC_CONTROLS);
        dynamicControlsPage.clickEnableButton();
        Assert.assertTrue(dynamicControlsPage.isTextBoxEnabled(), "TextBox is not enabled");
        dynamicControlsPage.sendRandomText(randomText);
        Assert.assertEquals(dynamicControlsPage.getValueOfInputBox(), randomText, "String does not match");
    }
}
