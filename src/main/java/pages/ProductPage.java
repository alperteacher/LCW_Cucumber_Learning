package pages;

import utility.GWD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends HelperFunctions {

    public ProductPage(){
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = ".product-detail-description__model-description ul li")
    public WebElement PRODUCT_DETAILS_MIDDLE;

    @FindBy(className = "product-detail-drawer__button")
    public WebElement MAIN_DESCRIPTION_BUTTON;

    @FindBy(className = "add-to-card")
    public WebElement ADD_TO_CART_BUTTON;

}
