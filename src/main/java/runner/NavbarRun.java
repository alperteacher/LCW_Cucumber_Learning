package runner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import utility.GWD;

import org.testng.annotations.BeforeSuite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = {
                "src/test/java/SearchTests/CheckBoxClearTest.feature",
                "src/test/java/SearchTests/SearchAutoCompleteTest.feature",
                "src/test/java/SearchTests/SearchButtonCheck.feature"
        },
        glue = "StepDefinitions")
public class NavbarRun extends AbstractTestNGCucumberTests {
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
