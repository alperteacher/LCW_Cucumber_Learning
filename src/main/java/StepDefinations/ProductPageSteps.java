package StepDefinations;

import PAGES.ProductPage;
import Utility.GWD;
import io.cucumber.java.en.Then;
import org.testng.Assert;



// Ürün sayfası adımları burada tanımlanır
public class ProductPageSteps extends GWD {

    ProductPage pp = new ProductPage();

    @Then("User be able to see \"Kolsuz\" and \"Tişört\" in the product description")
    public void aa() {
        pp.clickElement(pp.mainDescriptionButton);
        String description = pp.productDetailsMiddle.getText().toLowerCase();

        if (!description.contains("kolsuz") && !description.contains("tişört")){
            Assert.fail();
        }
    }

}


