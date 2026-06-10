package StepDefinitions;

import pages.MainPage;
import utility.GWD;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Anasayfa adımları burada tanımlanır
public class MainPageSteps {

    static int i;
    MainPage mp = new MainPage();
    private static final Logger logger = LogManager.getLogger(MainPageSteps.class);

    @Given("User navigate to main page")
    public void bb() {
        logger.info("Kullanıcı anasayfaya yönlendirildi.");
        GWD.getDriver().get("https://www.lcwaikiki.com");
        logger.info("Kullanıcı anasayfaya geldi.");
    }

    @Given("User navigate to website")
    public void userNavigateToWebsite() {
        logger.info("Kullanıcı anasayfaya yönlendirildi.");
        GWD.getDriver().get("https://www.lcwaikiki.com");
        logger.info("Kullanıcı anasayfaya geldi.");
        if(i != 1){
            mp.clickElement(mp.CLOSE_NOTIFICATION_BUTTON);
            logger.info("Kullanıcı notificationsları kapattı.");
            mp.clickElement(mp.COOKIES_ACCEPT_BUTTON);
            logger.info("Kullanıcı cookileri kabul etti.");
            i++;
        }
    }
}


