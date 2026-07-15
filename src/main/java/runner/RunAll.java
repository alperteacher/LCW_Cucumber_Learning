package runner;

import utility.GWD;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class RunAll extends AbstractTestNGCucumberTests {

    public static void main(String[] args) throws Throwable {
        Logger.getLogger("").setLevel(Level.SEVERE);

        System.setProperty("logFileName","src/test/Logs/Automation-Logs.log");

        String[] cucumberOptions = {
                "classpath:features",
                "--glue", "StepDefinitions"
        };
        io.cucumber.core.cli.Main.run(cucumberOptions, Thread.currentThread().getContextClassLoader());
    }


    @AfterClass
    public void afterClass(){
        GWD.quitDriver();
    }

}
