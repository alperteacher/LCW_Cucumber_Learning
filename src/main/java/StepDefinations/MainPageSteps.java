package StepDefinations;

import PAGES.MainPage;
import Utility.GWD;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;

// Anasayfa adımları burada tanımlanır
public class MainPageSteps {

    MainPage mp = new MainPage();

    @Given("User navigate to main page")
    public void bb() {
        GWD.getDriver().get("https://www.lcwaikiki.com");
    }

    @Given("User navigate to website")
    public void userNavigateToWebsite() {
        GWD.getDriver().get("https://www.lcwaikiki.com");
        mp.clickElement(mp.cookiesAcceptButton);
        mp.clickElement(mp.closeNotificationButton);
    }
}


