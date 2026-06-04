package PAGES;

import Utility.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends HelperFunctions {

    // Element sayfası objesi oluşturur, 1 tanedir anatasyonlarla ulaşılır
    public MainPage(){
        PageFactory.initElements(GWD.getDriver(), this);
    }

    // Element bulma
    @FindBy(id = "cookieseal-banner-accept")
    public WebElement cookiesAcceptButton;

    @FindBy(className = "ins-web-opt-in-reminder-close-button")
    public WebElement closeNotificationButton;
}
