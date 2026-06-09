package StepDefinations;

import PAGES.Navbar;
import PAGES.SearchPage;
import Utility.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


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



    @When("Enter {string} in search input")
    public void enterInSearchInput(String arg0) {
        nb.clickElement(nb.searchInput);
        nb.sendKeys(nb.searchInput, arg0);
    }

    @When("Enter {string} in search input and search")
    public void enterInSearchInputAndSearch(String arg0) {
        nb.clickElement(nb.searchInput);
        nb.sendKeys(nb.searchInput, arg0, Keys.ENTER);
    }

    @And("User must see the search page with {string} header")
    public void userMustSeeTheSearchPageWithHeader(String arg0) {
        Assert.assertTrue(sp.header.getText().contains(arg0));
    }


    @Then("User must see the no found page with {string}")
    public void userMustSeeTheNoFoundPageWith(String arg0) {
        Assert.assertTrue(sp.notFoundText.getText().contains(arg0));
    }

    @Then("User must see {string} in products 10 at least")
    public void userMustSeeInProductsAtLeast(String arg0) {
        int i = 0;
        for (WebElement element : sp.productNames){
            if (element.getText().toLowerCase().contains(arg0)){
                i++;
            }
            if (i == 10){
                break;
            }
        }

        if(!(i == 10)){
            Assert.fail();
        }
    }

    @Then("User shouldn't see the autocomplete box")
    public void userShouldnTSeeTheAutocompleteBox() {
        if (!nb.trendAramalarText.isDisplayed()) {
            Assert.fail();
        }
    }

    @And("User should see the autocomplete box")
    public void userShouldSeeTheAutocompleteBox() {
        if (!nb.onerilenAramalarText.isDisplayed()) {
            Assert.fail();
        }
    }

    @And("Click to close button in input")
    public void clickToCloseButtonInInput() {
        nb.clickElement(nb.inputCloseButton);
    }

    @Then("Inputs area must be clear")
    public void inputsAreaMustBeClear() {
        Assert.assertTrue(nb.searchInput.getAttribute("value").isEmpty());
    }

    @Then("User must see {string} in products brands 10 at least")
    public void userMustSeeInProductsBrandsAtLeast(String arg0) {
        int i = 0;
        for (WebElement element : sp.brandingNames){
            if (element.getText().toLowerCase().contains(arg0.toLowerCase())){
                i++;
            }
            if (i == 10){
                break;
            }
        }

        if(!(i == 10)){
            Assert.fail();
        }

        getDriver().getCurrentUrl();
    }

    @And("Enter words in search input and search")
    public void enterWordsInSearchInputAndSearch(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String word1 = data.get(0).get("word1");
        String word2 = data.get(0).get("word2");
        String completeString = word1 + " " + word2;
        nb.clickElement(nb.searchInput);
        nb.sendKeys(nb.searchInput, completeString, Keys.ENTER);
    }

    @Then("User must see searched words in url")
    public void userMustSeeSearchedWordsInUrl(DataTable dataTable) throws UnsupportedEncodingException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String decodedUrl = java.net.URLDecoder.decode(getDriver().getCurrentUrl(), "UTF-8");
        Assert.assertTrue(decodedUrl.contains(data.get(0).get("word1")));
        Assert.assertTrue(decodedUrl.contains(data.get(0).get("word2")));
    }

    @Then("User must see searched word in url")
    public void userMustSeeSearchedWordInUrl(DataTable dataTable) throws UnsupportedEncodingException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String decodedUrl = java.net.URLDecoder.decode(getDriver().getCurrentUrl(), "UTF-8");
        Assert.assertTrue(decodedUrl.contains(data.get(0).get("word1")));
    }

    @And("Click to search button")
    public void clickToSearchButton() {
        nb.clickElement(nb.searchButton);
    }

    @Then("Product size must be same with search page info")
    public void productSizeMustBeSameWithSearchPageInfo() {
        Assert.assertTrue(sp.productNames.size() == Integer.parseInt(sp.productCountInfo.getText()));
    }
}















