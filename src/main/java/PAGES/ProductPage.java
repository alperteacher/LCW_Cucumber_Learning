package PAGES;

import Utility.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends HelperFunctions {

    public ProductPage(){
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = ".product-detail-description__model-description ul li")
    public WebElement productDetailsMiddle;

    @FindBy(css = ".product-detail-drawer__button")
    public WebElement mainDescriptionButton;
}
