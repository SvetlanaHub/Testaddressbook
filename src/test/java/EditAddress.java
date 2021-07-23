import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class EditAddress extends StartAndClose {

    private WebDriver driver = Driver.getChromeDriver();

    @Test
    public void editAnAddress (){
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
