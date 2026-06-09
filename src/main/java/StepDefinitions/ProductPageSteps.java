package StepDefinitions;

import PAGES.ProductPage;
import Utility.GWD;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;



// Ürün sayfası adımları burada tanımlanır
public class ProductPageSteps extends GWD {

    ProductPage pp = new ProductPage();
    private static final Logger logger = LogManager.getLogger(MainPageSteps.class);

    @Then("User be able to see {string} in the product description")
    public void aa(String arg0) {
        pp.clickElement(pp.mainDescriptionButton);
        logger.info("Kullanıcı ürün açıklaması butonuna tıkladı.");
        String description = pp.productDetailsMiddle.getText().toLowerCase();
        logger.info("Ürün açıklaması alındı:" + description);

        String firstKey = arg0.substring(0, arg0.indexOf(" ")).toLowerCase();
        String lastKey = arg0.substring(arg0.indexOf(" ") + 1).toLowerCase();

        Assert.assertTrue(description.contains(firstKey), "Değerler eş değil.");
        Assert.assertTrue(description.contains(lastKey), "Değerler eş değil");
        logger.info("Ürün isimleri açıklama içerisinde yer alıyor.");
    }

}


