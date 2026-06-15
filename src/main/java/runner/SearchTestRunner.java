package runner;

import utility.GWD;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class SearchTestRunner extends AbstractTestNGCucumberTests {
    public static void main(String[] args) throws Throwable {
        Logger.getLogger("").setLevel(Level.SEVERE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        System.setProperty("logFileName","src/test/Logs/Automation-Logs-" + timestamp + ".log");

        String[] cucumberOptions = {
                "src/test/resources/features/SearchTests",
                "--glue", "StepDefinitions"
        };
        io.cucumber.core.cli.Main.run(cucumberOptions, Thread.currentThread().getContextClassLoader());
    }

        @BeforeClass
        public void beforeClass(){

        }
        @AfterClass
        public void afterClass(){
            GWD.quitDriver();
        }

        @BeforeSuite
        public void beforeSuite(){
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            System.setProperty("logFileName","src/test/Logs/Automation-Logs-" + timestamp + ".log");
        }
}
