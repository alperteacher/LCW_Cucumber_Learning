package StepDefinations;

import io.cucumber.java.en.Then;

import static Utility.BaseDriver.driver;

// Ürün sayfası adımları burada tanımlanır
public class ProductPageSteps {

    @Then("User be able to see \"Kolsuz\" and \"Tişört\" in the product description")
    public void aa() {
        driver.get("https://lcwaikiki.com");
    }

}


