package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import pages.BasicAuthPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.SettingsTestData;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class BasicAuthTest extends BaseTest {
    private final BasicAuthPage basicAuthPage = new BasicAuthPage();

    @BeforeMethod
    public void auth() {
        getBrowser().network().addBasicAuthentication(
                SettingsTestData.getEnvData().getDomain(),
                SettingsTestData.getUserData().getUsername(),
                SettingsTestData.getUserData().getPassword()
        );
    }

    @Test
    public void basicAuthTest() {
        mainPage.clickNavigationLink(MainPageNavigation.BASIC_AUTH);
        Assert.assertTrue(basicAuthPage.isSuccessMsgDisplayed(), "Login failed!");
    }
}
