package runner;

import org.testng.annotations.BeforeSuite;
import utility.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CucumberOptions(
        features = "classpath:features",
        glue = "StepDefinitions"
)
public class RunAll extends AbstractTestNGCucumberTests {

    public static void main(String[] args) throws Throwable {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        System.setProperty("logFileName","src/test/Logs/Automation-Logs-" + timestamp + ".log");

        String[] argv = {"--glue", "StepDefinitions",
                "classpath:features"};
        io.cucumber.core.cli.Main.run(argv, Thread.currentThread().getContextClassLoader());
    }

    @BeforeClass
    public void beforeClass(){}

    @AfterClass
    public void afterClass(){
        GWD.quitDriver();
    }

    @BeforeSuite
    public void beforeSuite(){}
}
