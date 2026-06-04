package PAGES;

import Utility.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends HelperFunctions {

    // Element sayfası objesi oluşturur, 1 tanedir anatasyonlarla ulaşılır
    public SearchPage(){
        PageFactory.initElements(GWD.getDriver(), this);
    }

    // Element bulma
    @FindBy(css = "[data-product-order=\"0\"]")
    public WebElement firstItem;

    @FindBy(css = "h1.product-list-heading__title")
    public WebElement header;

    @FindBy(css = ".not-found-keyword__text")
    public WebElement notFoundText;

    @FindBy(css = ".product-description.product-card-info__description")
    public List<WebElement> productNames;
}
