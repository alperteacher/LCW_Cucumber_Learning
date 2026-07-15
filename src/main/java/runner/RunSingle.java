package runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utility.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RunSingle extends AbstractTestNGCucumberTests {
    public static void main(String[] args) throws Throwable {
        Logger.getLogger("").setLevel(Level.SEVERE);

        System.setProperty("logFileName","src/test/Logs/Automation-Logs.log");

        String[] cucumberOptions = {
                "src/test/resources/features/SearchTests/SearchKeysInProductsTest.feature",
                "--glue", "StepDefinitions"
        };
        io.cucumber.core.cli.Main.run(cucumberOptions, Thread.currentThread().getContextClassLoader());
    }

    @AfterClass
    public void afterClass(){
        GWD.quitDriver();
    }

}
