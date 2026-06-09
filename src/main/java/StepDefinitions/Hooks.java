package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before(){
        System.out.println("Test başladı.");
    }

    @After
    public void after(){
        System.out.println("Test tamamlandı.");
    }

}
