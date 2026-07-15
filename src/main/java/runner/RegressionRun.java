package runner;

import utility.GWD;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class RegressionRun extends AbstractTestNGCucumberTests {
    public static void main(String[] args) throws Throwable {
        Logger.getLogger("").setLevel(Level.SEVERE);

        System.setProperty("logFileName","src/test/Logs/Automation-Logs.log");

        String[] cucumberOptions = {
                "src/test/resources/features",
                "--glue", "StepDefinitions",
                "--tags", "@Regression"
        };

        io.cucumber.core.cli.Main.run(cucumberOptions, Thread.currentThread().getContextClassLoader());
    }

    @AfterClass
    public void afterClass(){
        GWD.quitDriver();
    }
}
