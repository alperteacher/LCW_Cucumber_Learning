package runner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import utility.GWD;

import org.testng.annotations.BeforeSuite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "classpath:features",
        glue = "StepDefinitions",
        tags = "@navbar"
        )
public class NavbarRun extends AbstractTestNGCucumberTests {
    public static void main(String[] args) throws Throwable {
        Logger.getLogger("").setLevel(Level.SEVERE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        System.setProperty("logFileName","src/test/Logs/Automation-Logs-" + timestamp + ".log");

        String[] argv = {"--glue", "StepDefinitions",
                "classpath:features"};
        io.cucumber.core.cli.Main.run(argv, Thread.currentThread().getContextClassLoader());
    }

    @AfterClass
    public void afterClass(){
        GWD.quitDriver();
    }

    @BeforeSuite
    public void beforeSuite(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        System.setProperty("logFilePath","src/test/Logs/Automation-Logs-" + timestamp + ".log");
    }
}
