package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private final ITextBox searchBoxInputField = getElementFactory().getTextBox(By.id("searchInput"), "Search Box input field");
    private final IButton searchButton = getElementFactory().getButton(By.xpath("//*[@id='search-form']//button"), "Search button");

    public MainPage() {
        super(By.id("search-form"), "Wikipedia");
    }

    public void inputTextAndClickSubmitButton(String input) {
        searchBoxInputField.clearAndType(input);
        searchButton.click();
    }
}
