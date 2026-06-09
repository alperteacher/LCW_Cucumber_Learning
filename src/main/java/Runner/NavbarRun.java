package Runner;


import Utility.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = {
                "src/test/java/SearchTests/CheckBoxClearTest.feature",
                "src/test/java/SearchTests/SearchAutoCompleteTest.feature",
                "src/test/java/SearchTests/SearchButtonCheck.feature"
        },
        glue = "StepDefinitions"
)
public class NavbarRun extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void beforeClass(){}

    @AfterClass
    public void afterClass(){
        GWD.quitDriver();
    }
}
