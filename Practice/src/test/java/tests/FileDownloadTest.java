package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import pages.FileDownloadPage;
import utils.FileUtils;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends BaseTest {
    private final FileDownloadPage fileDownloadPage = new FileDownloadPage();
    private final String fileName = SettingsTestData.getFileData().getDownloadFile();
    private final String filePath = SettingsTestData.RESOURCES_PATH + fileName;
    private final File downloadedFile = new File(filePath);

    @Test
    public void fileDownloadTest() {
        mainPage.clickNavigationLink(MainPageNavigation.FILE_DOWNLOAD);
        Assert.assertTrue(fileDownloadPage.isFileDownloadLinkDisplayed(fileName), "File link is not displayed yet!");
        fileDownloadPage.clickFileDownloadLink(fileName);
        Assert.assertTrue(FileUtils.isFileExist(downloadedFile), "File is not downloaded yet!");
    }

    @AfterMethod
    public void deleteFile() {
        FileUtils.deleteFileIfExist(downloadedFile);
    }
}
