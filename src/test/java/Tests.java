import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;
import static locators.AllLocators.*;
import org.openqa.selenium.WebElement;
import java.io.File;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Tests {

    private WebDriver driver = Driver.getChromeDriver();

    private static final String PICTURE = new File("src/main/resources/address_book.png").getAbsolutePath();

    @BeforeAll
    public void setUp() {

        Log.info("Open the page a.testaddressbook.com/sign_in");
        driver.get("http://a.testaddressbook.com/sign_in");

        Log.info("We check that the user can sign in to the site");

        Log.info("In the 'Email' field, enter the value 'mail12@gmail.com'");
        driver.findElement(EMAIL_FIELD).sendKeys("mail12@gmail.com");

        Log.info("In the 'Password' field, enter the value '12467-A'");
        driver.findElement(PASSWORD_FIELD).sendKeys("12467-A");

        Log.info("Click on the 'Sign in' button");
        driver.findElement(SIGN_IN_BUTTON).click();

        Log.info("Finding text on the page sign in 'Welcome to Address Book' ");
        WebElement text = driver.findElement(TEXT);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Welcome to Address Book'");
        Assertions.assertEquals("Welcome to Address Book", textTitle, "Error: user is not logged in");

    }

    @Test
    @Order(1)
    @DisplayName("Checking the address addition")

    public void addingAnAddress() {

        Log.info("Finding an addresses link and clicking on it");
        driver.findElement(ADDRESSES_LINK).click();

        Log.info("Finding an new address link and clicking on it");
        driver.findElement(NEW_ADDRESS_LINK).click();

        Log.info("In the 'First name' field, enter the value 'Julia'");
        driver.findElement(FIRST_NAME_FIELD).sendKeys("Julia");

        Log.info("In the 'Last name' field, enter the value 'Brosn'");
        driver.findElement(LAST_NAME_FIELD).sendKeys("Brosn");

        Log.info("In the 'Address1' field, enter the value 'Park Ave'");
        driver.findElement(ADDRESS1_FIELD).sendKeys("Park Ave");

        Log.info("In the 'Address2' field, enter the value 'Park Ave S'");
        driver.findElement(ADDRESS2_FIELD).sendKeys("Park Ave S");

        Log.info("In the 'City' field, enter the value 'New York'");
        driver.findElement(CITY_FIELD).sendKeys("New York");

        Log.info("In the 'State' field, select 'New York'");
        driver.findElement(STATE_FIELD).click();

        Log.info("In the 'Zip code' field, enter the value '10001'");
        driver.findElement(ZIP_CODE_FIELD).sendKeys("10001");

        Log.info("In the 'Country' field, select 'United States'");
        driver.findElement(COUNTRY_FIELD).click();

        Log.info("In the 'Birthday' field, enter the value '12.06.1953'");
        driver.findElement(BIRTHDAY_FIELD).sendKeys("12.06.1953");

        Log.info("In the 'Color' field, select red");
        driver.findElement(COLOR_FIELD).sendKeys("#DC143C");

        Log.info("In the 'Age' field, enter the value '68'");
        driver.findElement(AGE_FIELD).sendKeys("68");

        Log.info("In the 'Website' field, enter the value 'www.whitepages.com'");
        driver.findElement(WEBSITE_FIELD).sendKeys("https://www.whitepages.com");

        Log.info("In the 'Picture' field, select the picture'");
        WebElement uploadElement = driver.findElement(PICTURE_FIELD);
        uploadElement.sendKeys(PICTURE);

        Log.info("In the 'Phone' field, enter the value '+1 212 678-193-206'");
        driver.findElement(PHONE_FIELD).sendKeys("+1 212 678-193-206");

        Log.info("In the 'Common Interests' field, select Reading");
        driver.findElement(COMMON_INTEREST_FIELD).click();

        Log.info("In the 'Note' field, enter the value '-'");
        driver.findElement(NOTE_FIELD).sendKeys("_");

        Log.info("Click the button 'Create Address'");
        driver.findElement(CREATE_ADDRESS_BUTTON).click();

        Log.info("Find the text on the page to add the address 'Address was successfully created.'");
        WebElement text = driver.findElement(MESSAGE_ADD);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Address was successfully created.'");
        Assertions.assertEquals("Address was successfully created.", textTitle, "Error: No address added");

    }

    @Test
    @Order(2)
    @DisplayName("Checking the change of address")

    public void editAnAddress () {

        Log.info("Finding an addresses link and clicking on it");
        driver.findElement(ADDRESSES_LINK).click();

        Log.info("Finding an edit link and clicking on it");
        driver.findElement(EDIT_LINK).click();

        Log.info("Delete the entry in the address field 1");
        driver.findElement(ADDRESS1_FIELD).clear();

        Log.info("In the 'Address1' field, enter the value 'Fulton Street'");
        driver.findElement(ADDRESS1_FIELD).sendKeys("Fulton Street");

        Log.info("Delete the entry in the address field 2");
        driver.findElement(ADDRESS2_FIELD).clear();

        Log.info("In the 'Address2' field, enter the value 'Park Avenue'");
        driver.findElement(ADDRESS2_FIELD).sendKeys("Park Avenue");

        Log.info("Delete the entry in the phone field ");
        driver.findElement(PHONE_FIELD).clear();

        Log.info("In the 'Phone' field, enter the value '+1 212 691-509-210'");
        driver.findElement(PHONE_FIELD).sendKeys("+1 212 691-509-210");

        Log.info("Click the button 'Update Address'");
        driver.findElement(UPDATE_ADDRESS_BUTTON).click();

        Log.info("Find the text on the page to edit the address 'Address was successfully updated.'");
        WebElement text = driver.findElement(MESSAGE_EDIT);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Address was successfully updated.'");
        Assertions.assertEquals("Address was successfully updated.", textTitle, "Error: address not changed");

    }

    @AfterAll
    public void tearDown() {

        Log.info("Close the browser");
        driver.quit();

    }

}


