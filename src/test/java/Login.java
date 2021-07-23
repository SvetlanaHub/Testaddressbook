import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;
import static locators.MainPageLocators.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Login {

    private WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void setUp() {

        Log.info("Open the page a.testaddressbook.com/sign_in");
        driver.get("http://a.testaddressbook.com/sign_in");

    }

    @Test
    @DisplayName("The test checks the user's ability to log in to the site")
    public void login () {

        driver.findElement(By.cssSelector("#session_email")).sendKeys("mail12@gmail.com");
        driver.findElement(By.cssSelector("#session_password")).sendKeys("12467-A");
        driver.findElement(By.xpath("//input[@value ='Sign in']")).click();
    }

    @AfterAll
    public void tearDown() {

        Log.info("Close the browser");
        driver.quit();

    }
}

