package StepDefinations;

import PAGES.Navbar;
import PAGES.SearchPage;
import Utility.GWD;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;


// Arama sayfası adımları burada tanımlanır
public class SearchSteps extends GWD {


    SearchPage sp = new SearchPage();
    Navbar nb = new Navbar();

    @Then("Click to a product in search page and navigate to product page")
    public void aa() {
        sp.clickElement(sp.firstItem);
    }

    @When("Enter \"Kolsuz Tişört\" in search input and press enter")
    public void ac() {
        nb.sendKeys(nb.searchInput, "Kolsuz Tişört", Keys.ENTER);
    }

    @When("Enter \"ko\" in search input and user shouldn't see the autocomplete box")
    public void vv() {
        nb.sendKeys(nb.searchInput, "ko");
    }


}
