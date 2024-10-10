package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DownloadPage;
import pages.SearchResultPage;
import utils.FileUtils;
import utils.SettingsTestData;

import java.io.File;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class WikipediaTest extends BaseTest {
    private final String inputString = SettingsTestData.getInputStringData().getInputString();

    @Test
    public void wikipediaTest() {
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main Page is not displayed yet");
        mainPage.inputTextAndClickSubmitButton(inputString);
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.clickToolMenuButton();
        searchResultPage.clickDownloadLink();
        DownloadPage downloadPage = new DownloadPage();
        downloadPage.clickDownloadButton();
        File donwloadedFile = new File(getBrowser().getDownloadDirectory() + File.separator + downloadPage.getFileName());
        Assert.assertTrue(FileUtils.isFileExist(donwloadedFile), "File does not exist!");
    }
}
