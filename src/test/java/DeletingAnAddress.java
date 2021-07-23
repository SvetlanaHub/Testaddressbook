import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import utils.Driver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class DeletingAnAddress extends StartAndClose {

    private WebDriver driver = Driver.getChromeDriver();

    @Test
    public void editAnAddress (){

        driver.findElement(By.cssSelector("#session_email")).sendKeys("mail12@gmail.com");
        driver.findElement(By.cssSelector("#session_password")).sendKeys("12467-A");
        driver.findElement(By.xpath("//input[@value ='Sign in']")).click();
        driver.findElement(By.xpath("//a[@href='/addresses']")).click();
        driver.findElement(By.xpath("//a[text()='Destroy']")).click();
        driver.switchTo().alert().accept();
        driver.quit();

    }
}