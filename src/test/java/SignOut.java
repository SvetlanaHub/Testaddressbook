import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class SignOut extends StartAndClose {

    private WebDriver driver = Driver.getChromeDriver();

    @Test
    public void signOut (){

        driver.findElement(By.cssSelector("#session_email")).sendKeys("mail12@gmail.com");
        driver.findElement(By.cssSelector("#session_password")).sendKeys("12467-A");
        driver.findElement(By.xpath("//input[@value ='Sign in']")).click();
        driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();
        driver.quit();

    }
}
