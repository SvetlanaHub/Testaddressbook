import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import utils.Driver;
import utils.Log;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Login {

    private WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void setUp() {

        Log.info("Open the page a.testaddressbook.com/sign_in");
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @AfterAll
    public void tearDown() {

        Log.info("Close the browser");
        driver.quit();

    }

    @Test //login
    public void login () {
        driver.findElement(By.cssSelector("#session_email")).sendKeys("mail12@gmail.com");
        driver.findElement(By.cssSelector("#session_password")).sendKeys("12467-A");
        driver.findElement(By.xpath("//input[@value ='Sign in']")).click();
    }

}

