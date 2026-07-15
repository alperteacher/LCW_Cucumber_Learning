package runner;

import java.util.logging.Level;
import java.util.logging.Logger;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import utility.GWD;

public class NavbarRun extends AbstractTestNGCucumberTests {
    public static void main(String[] args) throws Throwable {
        Logger.getLogger("").setLevel(Level.SEVERE);

        System.setProperty("logFileName","src/test/Logs/Automation-Logs.log");

        String[] cucumberOptions = {
                "classpath:features",
                "--glue", "StepDefinitions",
                "--tags","@navbar"
        };
        io.cucumber.core.cli.Main.run(cucumberOptions, Thread.currentThread().getContextClassLoader());
    }

    @AfterClass
    public void afterClass(){
        GWD.quitDriver();
    }
}
