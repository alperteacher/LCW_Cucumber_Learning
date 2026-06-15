package pages;

import utility.GWD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navbar extends HelperFunctions {

    // Element sayfası objesi oluşturur, 1 tanedir anatasyonlarla ulaşılır
    public Navbar(){
        PageFactory.initElements(GWD.getDriver(), this);
    }

    // Element bulma
    @FindBy(id = "search-form__input-field__search-input")
    public WebElement SEARCH_INPUT;

    @FindBy(xpath = "//div[text()=\"Trend Aramalar\"]")
    public WebElement TRENT_ARAMALAR_TEXT;

    @FindBy(xpath = "//div[text()=\"Önerilen Aramalar\"]")
    public WebElement ONERILEN_ARAMALAR_TEXT;

    @FindBy(className = "search-bar-close-icon")
    public WebElement INPUT_CLOSE_BUTTON;

    @FindBy(className = "search-form__input-field__btn-search")
    public WebElement SEARCH_BUTTON;

}
