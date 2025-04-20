package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ElementHelper;

import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    static WebDriver driver;
    static ElementHelper elementHelper;
    private Map<String, By> locators = new HashMap<>();
    private Map<String, String> dataStore = new HashMap<>();

    public void setDataStore(String value,String key) throws Exception {

        dataStore.put(key,value);
        if(dataStore.get(key)==null){
            throw new Exception("dataStore'a eklenmedi");
        }else{
            System.out.println(key +" keyine "+value+" eklendi");
        }


    }
    public String getDataStore(String key) {

        return dataStore.get(key);
    }

    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);

        locators.put("signup/login", By.xpath("//a[@href='/login']"));
        locators.put("signupName", By.cssSelector("input[data-qa='signup-name']"));
        locators.put("signup-email", By.cssSelector("input[data-qa='signup-email']"));
        locators.put("signup-button", By.cssSelector("button[data-qa='signup-button']"));
        locators.put("genderMr", By.cssSelector("input[id='id_gender1']"));
        locators.put("signupPassword", By.cssSelector("input[id='password']"));
        locators.put("birthDay", By.cssSelector("select[id='days']"));
        locators.put("birthMonths", By.cssSelector("select[id='months']"));
        locators.put("birthYears", By.cssSelector("select[id='years']"));

        locators.put("newsletterCheckbox", By.cssSelector("input[id='newsletter']"));
        locators.put("specialOffers", By.cssSelector("input[id='optin']"));
        locators.put("signup-firstname", By.cssSelector("input[id='first_name'"));
        locators.put("signup-lastname", By.cssSelector("input[id='last_name'"));
        locators.put("signup-company", By.cssSelector("input[id='company'"));
        locators.put("signup-address1", By.cssSelector("input[id='address1'"));
        locators.put("signup-address2", By.cssSelector("input[id='address2'"));
        locators.put("signup-country", By.cssSelector("select[id='country']"));
        locators.put("signup-state", By.cssSelector("input[id='state']"));
        locators.put("signup-city", By.cssSelector("input[id='city']"));
        locators.put("signup-zipcode", By.cssSelector("input[id='zipcode']"));
        locators.put("signup-mobile_number", By.cssSelector("input[id='mobile_number']"));
        locators.put("signup-createAccountButton", By.cssSelector("button[data-qa='create-account']"));
        locators.put("signup-continueButton", By.cssSelector("a[data-qa='continue-button']"));
        locators.put("deleteAccount", By.cssSelector("a[href='/delete_account']"));
        locators.put("homePageCategoryTitle", By.xpath("//h2[normalize-space()='Category']"));
        locators.put("homePageFeaturesItemsTitle", By.xpath("//h2[normalize-space()='Features Items']"));
        locators.put("signupPageSignUpTitle", By.xpath("//h2[normalize-space()='New User Signup!']"));
        locators.put("signupPageEnterAccountInformationTitle", By.xpath("//h2[normalize-space()='Enter Account Information']"));
        locators.put("signupPageAccountCreatedTitle", By.xpath("//h2[normalize-space()='Account Created!']"));
        locators.put("signupPageAccountDeletedTitle", By.xpath("//h2[normalize-space()='Account Deleted!']"));

        locators.put("loginPageLoginTitle", By.xpath("//h2[normalize-space()='Login to your account']"));
        locators.put("login-email", By.cssSelector("input[data-qa='login-email'"));
        locators.put("login-password", By.cssSelector("input[data-qa='login-password'"));
        locators.put("login-button", By.cssSelector("button[data-qa='login-button']"));
        locators.put("firstProduct", By.cssSelector("a[href='/product_details/1']"));
        locators.put("productNameText", By.xpath("//div[@class='product-information']//h2"));
        locators.put("productPriceText", By.xpath("//div[@class='product-information']//span//span"));
        locators.put("addToCartButton", By.cssSelector("button[class='btn btn-default cart']"));
        locators.put("addedToCartTitle", By.xpath("//h4[normalize-space()='Added!']"));
        locators.put("viewCartButton", By.xpath("//a[@href='/view_cart' and normalize-space()='View Cart']"));
        locators.put("firstProductNameInCart", By.xpath("//a[@href='/product_details/1']"));
        locators.put("firstProductPriceInCart", By.cssSelector("td[class='cart_price']"));
        locators.put("firstProductTotalPriceInCart", By.cssSelector("p[class='cart_total_price']"));
        locators.put("proceedToCheckoutButton", By.cssSelector("a[class='btn btn-default check_out']"));
        locators.put("checkoutTitle", By.xpath("//li[@class='active' and normalize-space()='Checkout']"));
        locators.put("checkoutTotalAmount", By.xpath("//td[not(contains(@class,'cart_total'))]//p[@class='cart_total_price']"));
        locators.put("placeOrderButton", By.cssSelector("a[href='/payment']"));
        locators.put("paymentTitle", By.xpath("//h2[normalize-space()='Payment']"));

        locators.put("paymentNameOnCard", By.cssSelector("input[name='name_on_card']"));
        locators.put("paymentCardNumber", By.cssSelector("input[name='card_number']"));
        locators.put("paymentCvc", By.cssSelector("input[name='cvc']"));
        locators.put("paymentExpiryMonth", By.cssSelector("input[name='expiry_month']"));
        locators.put("paymentExpiryYear", By.cssSelector("input[name='expiry_year']"));
        locators.put("paymentPayAndConfirmOrderButton", By.cssSelector("button[id='submit']"));
        locators.put("paymentOrderPlacedTitle", By.xpath("//h2[normalize-space()='Order Placed!']"));
        locators.put("downloadInvoiceButton", By.cssSelector("a[class='btn btn-default check_out']"));


    }


    public By getElement(String elementName) {

        By locator = locators.get(elementName);
        if (locator != null) {
            logger.info(elementName + " elementinin locator'ı alindi");

        }
        //       else {
//            throw new IllegalArgumentException("Locator not found for element: " + elementName);
//        }
        return locator;
    }

}

