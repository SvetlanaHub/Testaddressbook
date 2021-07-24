package locators;
import org.openqa.selenium.By;

public class AllLocators {

    //Locators to login to the site

    public static final By EMAIL_FIELD = By.cssSelector("#session_email");
    public static final By PASSWORD_FIELD = By.cssSelector("#session_password");
    public static final By SIGN_IN_BUTTON = By.xpath("//input[@value ='Sign in']");
    public static final By TEXT = By.xpath("//h1[text()='Welcome to Address Book']");

    //Locators for adding an address

    public static final By ADDRESSES_LINK = By.xpath("//a[@href='/addresses']");
    public static final By NEW_ADDRESS_LINK = By.xpath("//a[@href='/addresses/new']");
    public static final By FIRST_NAME_FIELD = By.cssSelector("#address_first_name");
    public static final By LAST_NAME_FIELD = By.cssSelector("#address_last_name");
    public static final By ADDRESS1_FIELD = By.id("address_street_address");
    public static final By ADDRESS2_FIELD = By.id("address_secondary_address");
    public static final By CITY_FIELD = By.name("address[city]");
    public static final By STATE_FIELD = By.xpath("//select[@id='address_state']/child::option[33]");
    public static final By ZIP_CODE_FIELD = By.id("address_zip_code");
    public static final By COUNTRY_FIELD = By.id("address_country_us");
    public static final By BIRTHDAY_FIELD = By.id("address_birthday");
    public static final By COLOR_FIELD = By.id("address_color");
    public static final By AGE_FIELD = By.id("address_age");
    public static final By WEBSITE_FIELD = By.id("address_website");
    public static final By PICTURE_FIELD = By.cssSelector("#address_picture");
    public static final By PHONE_FIELD = By.xpath("//input[@type='tel']");
    public static final By COMMON_INTEREST_FIELD = By.id("address_interest_read");
    public static final By NOTE_FIELD = By.id("address_note");
    public static final By CREATE_ADDRESS_BUTTON = By.xpath("//input[@class='btn btn-primary']");
    public static final By MESSAGE = By.xpath("//div[contains(text(),'Address was successfully created.')]");

    //Locators for address change

    public static final By EDIT_LINK = By.xpath("//a[text()='Edit']");



    //Locators for address deletion

    //Locators for user logout




}
