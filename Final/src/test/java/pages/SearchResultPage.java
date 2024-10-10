package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SearchResultPage extends Form {
    private final IButton toolMenuButton = getElementFactory().getButton(By.id("vector-page-tools-dropdown"), "Tools menu button");
    private final ILink downloadLink = getElementFactory().getLink(By.id("coll-download-as-rl"), "Download Link");

    public SearchResultPage() {
        super(By.id("ca-nstab-main"), "Article");
    }

    public void clickToolMenuButton() {
        toolMenuButton.click();
    }

    public void clickDownloadLink() {
        downloadLink.click();
    }
}
