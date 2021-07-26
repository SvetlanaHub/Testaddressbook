package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;
import static locators.AllLocators.*;
import org.openqa.selenium.WebElement;
import java.io.File;
import static dataConstants.DataConstants.*;


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

        Log.info("In the 'Email' field, enter the email");
        driver.findElement(EMAIL_FIELD).sendKeys(EMAIL);

        Log.info("In the 'Password' field, enter the password");
        driver.findElement(PASSWORD_FIELD).sendKeys(PASSWORD);

        Log.info("Click on the 'Sign in' button");
        driver.findElement(SIGN_IN_BUTTON).click();

        Log.info("Finding text on the page sign in 'Welcome to Address Book' ");
        WebElement text = driver.findElement(TEXT);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Welcome to Address Book'");
        Assertions.assertEquals("Welcome to Address Book", textTitle, "Error: user is not sign in");

    }

    @Test
    @Order(1)
    @DisplayName("Checking the address addition")

    public void addingAnAddress() {

        Log.info("Finding an addresses link and clicking on it");
        driver.findElement(ADDRESSES_LINK).click();

        Log.info("Finding an new address link and clicking on it");
        driver.findElement(NEW_ADDRESS_LINK).click();

        Log.info("In the 'First name' field, enter the first name");
        driver.findElement(FIRST_NAME_FIELD).sendKeys(FIRST_NAME);

        Log.info("In the 'Last name' field, enter the last name");
        driver.findElement(LAST_NAME_FIELD).sendKeys(LAST_NAME);

        Log.info("In the 'Address1' field, enter the address1");
        driver.findElement(ADDRESS1_FIELD).sendKeys(ADDRESS1);

        Log.info("In the 'Address2' field, enter the address2");
        driver.findElement(ADDRESS2_FIELD).sendKeys(ADDRESS2);

        Log.info("In the 'City' field, enter the city");
        driver.findElement(CITY_FIELD).sendKeys(CITY);

        Log.info("In the 'State' field, select the state");
        driver.findElement(STATE_FIELD).click();

        Log.info("In the 'Zip code' field, enter the zip code");
        driver.findElement(ZIP_CODE_FIELD).sendKeys(ZIP_CODE);

        Log.info("In the 'Country' field, select the country");
        driver.findElement(COUNTRY_FIELD).click();

        Log.info("In the 'Birthday' field, enter the birthday");
        driver.findElement(BIRTHDAY_FIELD).sendKeys(BIRTHDAY);

        Log.info("In the 'Color' field, select the color");
        driver.findElement(COLOR_FIELD).sendKeys(COLOR);

        Log.info("In the 'Age' field, enter the age");
        driver.findElement(AGE_FIELD).sendKeys(AGE);

        Log.info("In the 'Website' field, enter the website");
        driver.findElement(WEBSITE_FIELD).sendKeys(WEBSITE);

        Log.info("In the 'Picture' field, select the picture");
        WebElement uploadElement = driver.findElement(PICTURE_FIELD);
        uploadElement.sendKeys(PICTURE);

        Log.info("In the 'Phone' field, enter the phone");
        driver.findElement(PHONE_FIELD).sendKeys(PHONE);

        Log.info("In the 'Common Interests' field, select the common interests");
        driver.findElement(COMMON_INTEREST_FIELD).click();

        Log.info("In the 'Note' field, enter the note");
        driver.findElement(NOTE_FIELD).sendKeys(NOTE);

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
    @Disabled
    @DisplayName("Checking the change of address")

    public void editAnAddress () {

        Log.info("Finding an addresses link and clicking on it");
        driver.findElement(ADDRESSES_LINK).click();

        Log.info("Finding an edit link and clicking on it");
        driver.findElement(EDIT_LINK).click();

        Log.info("Delete the entry in the address field 1");
        driver.findElement(ADDRESS1_FIELD).clear();

        Log.info("In the 'Address1' field, enter a new address1");
        driver.findElement(ADDRESS1_FIELD).sendKeys(ADDRESS1_NEW);

        Log.info("Delete the entry in the address field 2");
        driver.findElement(ADDRESS2_FIELD).clear();

        Log.info("In the 'Address2' field, enter a new address2");
        driver.findElement(ADDRESS2_FIELD).sendKeys(ADDRESS2_NEW);

        Log.info("Delete the entry in the phone field ");
        driver.findElement(PHONE_FIELD).clear();

        Log.info("In the 'Phone' field, enter a new phone");
        driver.findElement(PHONE_FIELD).sendKeys(PHONE_NEW);

        Log.info("Click the button 'Update Address'");
        driver.findElement(UPDATE_ADDRESS_BUTTON).click();

        Log.info("Find the text on the page to edit the address 'Address was successfully updated.'");
        WebElement text = driver.findElement(MESSAGE_EDIT);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Address was successfully updated.'");
        Assertions.assertEquals("Address was successfully updated.", textTitle, "Error: address not changed");

    }

    @Test
    @Disabled
    @DisplayName("Checking for address deletion")

    public void deletingAnAddress (){

        Log.info("Finding an addresses link and clicking on it");
        driver.findElement(ADDRESSES_LINK).click();

        Log.info("Finding a destroy link and clicking on it");
        driver.findElement(DESTROY_LINK).click();

        Log.info("In the pop-up window, click OK");
        driver.switchTo().alert().accept();

        Log.info("Find the text on the page to edit the address 'Address was successfully destroyed.'");
        WebElement text = driver.findElement(MESSAGE_DELETE);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Address was successfully destroyed.'");
        Assertions.assertEquals("Address was successfully destroyed.", textTitle, "Error: the address was not deleted");

    }

    @AfterAll
    public void tearDown() {

        Log.info("We check that the user can sign out of the site");
        driver.findElement(SIGN_OUT_LINK).click();

        Log.info("Сheck that the user has sign out the site and is on the page sign in");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL, "A page not logging into the site is open or an incorrect URL is specified");

        Log.info("Close the browser");
        driver.quit();

    }

}


