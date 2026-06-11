package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void before(Scenario scenario){
        String featureFileName = scenario.getUri().toString();
        featureFileName = featureFileName.substring(featureFileName.lastIndexOf("/") + 1).replace(".feature", "");

        logger.trace("------------------------*--------------------------");
        logger.trace("Başlatılan Feature Testi : " + featureFileName);
        logger.trace("Başlatılan Test Seneryosu : " + scenario.getName());

        if (!scenario.getSourceTagNames().isEmpty()) {
            logger.trace("Seneryo etiketleri : " + scenario.getSourceTagNames());
        }
    }

    @After
    public void after(Scenario scenario){
        logger.trace(scenario.getName() + " tamamlandı.");
        logger.trace("------------------------*--------------------------");
    }
}
