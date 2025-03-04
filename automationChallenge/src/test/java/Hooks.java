import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BaseTest;

public class Hooks {

    @Before()
    public void setup() {
        BaseTest.initializeDriver("chrome");
    }

    @After()
    public void teardown() {
        BaseTest.quitDriver();
    }
}

