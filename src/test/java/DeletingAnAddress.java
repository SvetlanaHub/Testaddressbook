import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DeletingAnAddress {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.cssSelector("#session_email")).sendKeys("mail12@gmail.com");
        driver.findElement(By.cssSelector("#session_password")).sendKeys("12467-A");
        driver.findElement(By.xpath("//input[@value ='Sign in']")).click();
        driver.findElement(By.xpath("//a[@href='/addresses']")).click();
        driver.findElement(By.xpath("//a[text()='Destroy']")).click();
        driver.switchTo().alert().accept();
        driver.quit();

    }
}