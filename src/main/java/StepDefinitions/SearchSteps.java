package StepDefinitions;

import pages.Navbar;
import pages.SearchPage;
import utility.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


// Arama sayfası adımları burada tanımlanır
public class SearchSteps extends GWD {

    private static final Logger logger = LogManager.getLogger(MainPageSteps.class);
    SearchPage sp = new SearchPage();
    Navbar nb = new Navbar();

    @Then("Click to a product in search page and navigate to product page")
    public void aa() {
        sp.clickElement(sp.FIRST_ITEM);
        logger.info("İlk ürüne tıklandı");
    }

    @When("Enter {string} in search input")
    public void enterInSearchInput(String arg0) {
        nb.clickElement(nb.SEARCH_INPUT);
        logger.info("Search input a tıklandı.");
        nb.sendKeys(nb.SEARCH_INPUT, arg0);
        logger.info("Search input kelime gönderildi");
    }

    @When("Enter {string} in search input and search")
    public void enterInSearchInputAndSearch(String arg0) {
        nb.clickElement(nb.SEARCH_INPUT);
        logger.info("Search input a tıklandı.");
        nb.sendKeys(nb.SEARCH_INPUT, arg0, Keys.ENTER);
        logger.info("Search input kelime gönderildi ve enter a basıldı");
    }

    @And("User must see the search page with {string} header")
    public void userMustSeeTheSearchPageWithHeader(String arg0) {
        try {
            Assert.assertTrue(sp.HEADER.getText().contains(arg0));
            logger.info("Header da text kontrolü başarılı.");
        } catch (AssertionError e){
            logger.warn(e.getMessage());
            throw e;
        }
    }


    @Then("User must see the no found page with {string}")
    public void userMustSeeTheNoFoundPageWith(String arg0) {
        try {
            Assert.assertTrue(sp.NOT_FOUND_TEXT.getText().contains(arg0));
            logger.info("Bulunamadı doğrulaması gerçekleşti.");
        } catch (AssertionError e){
            logger.warn(e.getMessage());
            throw e;
        }
    }

    @Then("User must see {string} in products 10 at least")
    public void userMustSeeInProductsAtLeast(String arg0) {
        logger.info("Ürün isimleri alınıyor.");
        int i = 0;
        for (WebElement element : sp.PRODUCT_NAMES){
            if (element.getText().toLowerCase().contains(arg0)){
                i++;
            }
            if (i == 10){
                break;
            }
        }
        logger.info("Ürün isimleri sayıldı.");
        if(!(i == 10)){
            Assert.fail();
        }
        logger.info("Ürün isimleri kontrolü doğru.");
    }

    @Then("User shouldn't see the autocomplete box")
    public void userShouldnTSeeTheAutocompleteBox() {
        logger.info("Trend aramalar kontrolü.");
        if (!nb.TRENT_ARAMALAR_TEXT.isDisplayed()) {
            Assert.fail();
        }
        logger.info("Trend aramalar gözükmüyor.");
    }

    @And("User should see the autocomplete box")
    public void userShouldSeeTheAutocompleteBox() {
        logger.info("Önerilen aramalar kontrolü.");
        if (!nb.ONERILEN_ARAMALAR_TEXT.isDisplayed()) {
            Assert.fail();
        }

        logger.info("Önerilen aramalar gözüküyor.");
    }

    @And("Click to close button in input")
    public void clickToCloseButtonInInput() {
        nb.clickElement(nb.INPUT_CLOSE_BUTTON);
        logger.info("Kapatma butonuna tıklanıldı.");
    }

    @Then("Inputs area must be clear")
    public void inputsAreaMustBeClear() {
        logger.info("Input temizleme kontrolü.");
        try {
            Assert.assertTrue(nb.SEARCH_INPUT.getAttribute("value").isEmpty());
            logger.info("Input temizlendiği kontrol edildi.");
        } catch (AssertionError e){
            logger.warn(e.getMessage());
            throw e;
        }
    }

    @Then("User must see {string} in products brands 10 at least")
    public void userMustSeeInProductsBrandsAtLeast(String arg0) {
        logger.info("Marka isimleri alınıyor.");
        int i = 0;
        for (WebElement element : sp.BRADING_NAMES){
            if (element.getText().toLowerCase().contains(arg0.toLowerCase())){
                i++;
            }
            if (i == 10){
                break;
            }
        }
        logger.info("Marka isimleri alındı.");

        if(!(i == 10)){
            Assert.fail();
        }
        logger.info("Marka isimleri doğru.");
    }

    @And("Enter words in search input and search")
    public void enterWordsInSearchInputAndSearch(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String word1 = data.get(0).get("word1");
        String word2 = data.get(0).get("word2");
        String completeString = word1 + " " + word2;
        nb.clickElement(nb.SEARCH_INPUT);
        logger.info("Search input a tıklanıldı.");
        nb.sendKeys(nb.SEARCH_INPUT, completeString, Keys.ENTER);
        logger.info("Serach input a verilen kelimeler girildi. ("+ word1 + " - " + word2 +")");
    }

    @Then("User must see searched words in url")
    public void userMustSeeSearchedWordsInUrl(DataTable dataTable) throws UnsupportedEncodingException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String decodedUrl = java.net.URLDecoder.decode(getDriver().getCurrentUrl(), "UTF-8");
        Assert.assertTrue(decodedUrl.contains(data.get(0).get("word1")));
        Assert.assertTrue(decodedUrl.contains(data.get(0).get("word2")));

        logger.info("Decoded URL alındı : " + decodedUrl);
        logger.info("URL Aranan kelimeleri içeriyor.");
    }

    @Then("User must see searched word in url")
    public void userMustSeeSearchedWordInUrl(DataTable dataTable) throws UnsupportedEncodingException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String decodedUrl = java.net.URLDecoder.decode(getDriver().getCurrentUrl(), "UTF-8");
        Assert.assertTrue(decodedUrl.contains(data.get(0).get("word1")));

        logger.info("Decoded URL alındı : " + decodedUrl);
        logger.info("URL Aranan kelimeleri içeriyor.");
    }

    @And("Click to search button")
    public void clickToSearchButton() {
        nb.clickElement(nb.SEARCH_BUTTON);
        logger.info("Arama butonuna tıklanıldı.");
    }

    @Then("Product size must be same with search page info")
    public void productSizeMustBeSameWithSearchPageInfo() {
        logger.info("Sayfadaki ürün sayısı alınıyor.");

        try {
            Assert.assertTrue(sp.PRODUCT_NAMES.size() == Integer.parseInt(sp.PRODUCT_COUNT_INFO.getText()));
            logger.info("Sayfadaki ürün sayısı doğrulandı.");
        } catch (AssertionError e){
            logger.warn(e.getMessage());
            throw e;
        }



    }
}















