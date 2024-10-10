package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DownloadPage extends Form {
    private final ILabel fileName = getElementFactory().getLabel(By.className("mw-electronpdfservice-selection-label-desc"), "File name");
    private final IButton downloadButton = getElementFactory().getButton(By.className("oo-ui-labelElement-label"), "Download button");

    public DownloadPage() {
        super(By.id("ca-sitesupport"), "Download as PDF");
    }

    public String getFileName() {
        return fileName.getText();
    }

    public void clickDownloadButton() {
        downloadButton.click();
    }
}
