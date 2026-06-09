package Runner;

import Utility.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/java/",
        glue = "StepDefinitions"
)
public class RunAll extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void beforeClass(){

    }

    @AfterClass
    public void afterClass(){
        GWD.quitDriver();
    }

}
