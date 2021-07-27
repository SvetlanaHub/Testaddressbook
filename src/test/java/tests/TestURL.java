package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestURL {

    private WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void setUp() {

        Log.info("Open the page a.testaddressbook.com/sign_in");
        driver.get("http://a.testaddressbook.com/sign_in");

    }

    @Test
    @Order(1)
    @DisplayName("We check if the URL of the site's login page is correct")

    public void urlPage() {

        Log.info("Open the page a.testaddressbook.com/sign_in" + driver.getCurrentUrl());

        Log.info("We check if the URL of the site's login page is correct");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL, "Url wrong");

    }

    @AfterAll
    public void tearDown() {

        Log.info("Close the browser");
        driver.quit();

    }
}
