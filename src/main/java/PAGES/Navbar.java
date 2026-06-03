package PAGES;

import Utility.GWD;
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
    public WebElement searchInput;

    @FindBy(css = ".advanced-search")
    public WebElement suggestionBox;

}
