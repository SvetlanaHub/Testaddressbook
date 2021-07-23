import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import utils.Driver;


public class StartAndClose {

    protected WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void setUp() {
        driver.get("http://a.testaddressbook.com/sign_in");

    }

    @AfterAll
    public void tearDown() {

        driver.quit();
    }
}
