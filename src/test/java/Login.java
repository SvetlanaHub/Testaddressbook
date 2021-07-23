import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.Log;
import static locators.AllLocators.*;

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

        Log.info("In the 'Email' field, enter the value 'mail12@gmail.com'");
        driver.findElement(EMAIL_FIELD).sendKeys("mail12@gmail.com");

        Log.info("In the 'Password' field, enter the value '12467-A'");
        driver.findElement(PASSWORD_FIELD).sendKeys("12467-A");

        Log.info("Click on the 'Sign in' button");
        driver.findElement(SIGN_IN_BUTTON).click();

        Log.info("We receive the message");
        WebElement text = driver.findElement(MESSAGE);

        Log.info("We check that the user has successfully logged in with the message 'Welcome to Address Book'");
        Assertions.assertEquals(MESSAGE, "'Error: user is not logged in'");

        //String loginInfo = driver.getTitle (AllLocators.MESSAGE);
        //Assert.assertEquals(loginInfo, );



    }

    @AfterAll
    public void tearDown() {

        Log.info("Close the browser");
        driver.quit();

    }
}

