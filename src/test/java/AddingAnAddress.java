import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class AddingAnAddress extends StartAndClose {

    private WebDriver driver = Driver.getChromeDriver();

        @Test
        public void addindAnAddress (){
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.cssSelector("#session_email")).sendKeys("mail12@gmail.com");
        driver.findElement(By.cssSelector("#session_password")).sendKeys("12467-A");
        driver.findElement(By.xpath("//input[@value ='Sign in']")).click();
        driver.findElement(By.xpath("//a[@href='/addresses']")).click();
        driver.findElement(By.xpath("//a[@href='/addresses/new']")).click();
        driver.findElement(By.cssSelector("#address_first_name")).sendKeys("Julia");
        driver.findElement(By.cssSelector("#address_last_name")).sendKeys("Brosn");
        driver.findElement(By.id("address_street_address")).sendKeys("Park Ave");
        driver.findElement(By.id("address_secondary_address")).sendKeys("Park Ave S");
        driver.findElement(By.name("address[city]")).sendKeys("New York");
        driver.findElement(By.xpath("//select[@id='address_state']/child::option[33]")).click();
        driver.findElement(By.id("address_zip_code")).sendKeys("10001");
        driver.findElement(By.id("address_country_us")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("12.06.1953");
        driver.findElement(By.id("address_color")).sendKeys("#DC143C");
        driver.findElement(By.id("address_age")).sendKeys("68");
        driver.findElement(By.id("address_website")).sendKeys("https://www.whitepages.com");
        WebElement uploadElement = driver.findElement (By.cssSelector("#address_picture"));
        uploadElement.sendKeys("c:\\Users\\Svetik\\Downloads\\address_book.png");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("+1 212 678-193-206");
        driver.findElement(By.id("address_interest_read")).click();
        driver.findElement(By.id("address_note")).sendKeys("_");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        driver.quit();

    }
}
