package steps;

import base.BaseTest;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        BaseTest.initDriver();
    }

    @AfterAll
    public static void tearDown() {
        BaseTest.quitDriver();
    }
}
