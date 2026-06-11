package StepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages.ProductPage;
import utility.GWD;

// Ürün sayfası adımları burada tanımlanır
public class ProductPageSteps extends GWD {

    private static final Logger logger = LogManager.getLogger(MainPageSteps.class);
    ProductPage pp = new ProductPage();

    @Then("User be able to see {string} in the product description")
    public void aa(String arg0) {
        pp.clickElement(pp.MAIN_DESCRIPTION_BUTTON);
        logger.info("Kullanıcı ürün açıklaması butonuna tıkladı.");

        String description = pp.PRODUCT_DETAILS_MIDDLE.getText().toLowerCase();
        logger.info("Ürün açıklaması alındı:" + description);

        String firstKey = arg0.substring(0, arg0.indexOf(" ")).toLowerCase();
        String lastKey = arg0.substring(arg0.indexOf(" ") + 1).toLowerCase();

        Assert.assertTrue(description.contains(firstKey), "Değerler eş değil.");
        Assert.assertTrue(description.contains(lastKey), "Değerler eş değil");
        logger.info("Ürün isimleri açıklama içerisinde yer alıyor.");
    }

    @When("User click to add to cart button")
    public void userClickToAddToCartButton() {
        pp.clickElement(pp.ADD_TO_CART_BUTTON);
        logger.info("Sepete ekle butonuna tıklandı.");
    }

    @Then("User able to see \"select a variation\" message")
    public void userAbleToSeeMessage() {
        logger.info("Buton değişimi kontrol ediliyor.");
        try {
            Assert.assertTrue(pp.ADD_TO_CART_BUTTON.getAttribute("class").contains("add-to-card--select-size"));
            logger.info("Buton değişimi onaylandı.");
        } catch (Exception e) {
            logger.info("Buton değişimi onaylanmadı.");
            throw e;
        }
    }
}


