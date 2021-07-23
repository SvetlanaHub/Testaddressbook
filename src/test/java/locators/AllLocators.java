package locators;

import org.openqa.selenium.By;

public class AllLocators {

    //Locators to login to the site
    public static final By EMAIL_FIELD = By.cssSelector("#session_email");
    public static final By PASSWORD_FIELD = By.cssSelector("#session_password");
    public static final By SIGN_IN_BUTTON = By.xpath("//input[@value ='Sign in']");
    public static final By MESSAGE = By.xpath("//h1[text()='Welcome to Address Book']");

    //Locators for adding an address




    //Locators for address change

    //Locators for address deletion

    //Locators for user logout


    public static final By BOOKS = By.cssSelector(".item-type-card__content .item-type-card__link");

    public static final By DISCOUNT = By.xpath("//*[contains(text(), 'Акции и скидки')]");
    public static final By CATEGORY_DISCOUNT = By.cssSelector(".landing-nav-list__item");

}
