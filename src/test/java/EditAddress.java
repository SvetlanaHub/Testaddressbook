import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class EditAddress {

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
        driver.findElement(By.xpath("//a[text()='Edit']")).click();
        driver.findElement(By.id("address_street_address")).clear();
        driver.findElement (By.id("address_street_address")).sendKeys("Fulton Street");
        driver.findElement(By.id("address_secondary_address")).clear();
        driver.findElement(By.id("address_secondary_address")).sendKeys("Park Avenue");
        driver.findElement(By.id("address_phone")).clear();
        driver.findElement(By.id("address_phone")).sendKeys("+1 212 691-509-210");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        driver.quit();

    }
}
