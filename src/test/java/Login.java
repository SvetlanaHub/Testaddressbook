import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login {

    private WebDriver driver;

            @BeforeAll
            public static void setupTest() {
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.get("http://a.testaddressbook.com/sign_in");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }

            @AfterAll
            public void closeTest () {
                if (driver != null) {
                    driver.quit();
                }
            }

            @Test //login
            public void login () {
                driver.findElement(By.cssSelector("#session_email")).sendKeys("mail12@gmail.com");
                driver.findElement(By.cssSelector("#session_password")).sendKeys("12467-A");
                driver.findElement(By.xpath("//input[@value ='Sign in']")).click();
            }

            //@Test //add
        }

