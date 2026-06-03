package PAGES;

import Utility.GWD;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Diğer tüm sayfalar bu class tan extend bu sayede methodları taşırlar
public class HelperFunctions {

    // Element alır, visible olana kadar bekler, element içerisine string i gönderir
    public void sendKeys(WebElement element, String string){
        waitVisible(element);
        element.sendKeys(string);
    }

    // Element alır, visible olana kadar bekler, element içerisine string i ve key i gönderir
    public void sendKeys(WebElement element, String string, Keys keys){
        waitVisible(element);
        element.sendKeys(string, keys);
    }

    // Element alır, visible olana kadar bekler, elemente kadar scroll yapar ve tıklar
    public void clickElement(WebElement element){
        waitVisible(element);
        GWD.js.executeScript("arguments[0].scrollIntoView(false)", element);
        GWD.js.executeScript("window.scrollTo(0, 500)", element);
        element.click();
    }

    // Element alır, visible olana kadar bekler
    public void waitVisible(WebElement element){
        GWD.wait.until(ExpectedConditions.visibilityOf(element));
    }
}
