package pages;

import utility.GWD;

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
    public WebElement COOKIES_ACCEPT_BUTTON;

    @FindBy(className = "ins-web-opt-in-reminder-close-button")
    public WebElement CLOSE_NOTIFICATION_BUTTON;
}
