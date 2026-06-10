package pages;

import utility.GWD;
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
    public WebElement FIRST_ITEM;

    @FindBy(css = "h1.product-list-heading__title")
    public WebElement HEADER;

    @FindBy(css = ".not-found-keyword__text")
    public WebElement NOT_FOUND_TEXT;

    @FindBy(css = ".product-description.product-card-info__description")
    public List<WebElement> PRODUCT_NAMES;

    @FindBy(className = "product-brand")
    public List<WebElement> BRADING_NAMES;

    @FindBy(className = "load-more__info-text-viewed-products")
    public WebElement PRODUCT_COUNT_INFO;
}
