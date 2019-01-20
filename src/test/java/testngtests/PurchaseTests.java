package testngtests;

import commonutils.CommonUtils;
import driversetup.DriverFactory;
import org.testng.annotations.*;
import pageobjects.HomePage;

import java.util.Random;

/**
 * Created by Jatin on 1/19/2019.
 */
public class PurchaseTests {
    HomePage homePage;

    @BeforeMethod()
    public void setUp() throws Exception {
        homePage=new HomePage();
        homePage.openWebApp(CommonUtils.getCentralData("AppUrl"));
    }

    @Test(priority = 1)
    public void testPurchaseNewUser(){
        String product="T-shirts";
        Random rand = new Random();
        int number = rand.nextInt(5000) + 1;
        String email= "email"+ number+"@sample"+ number+".com";
        System.out.println(email);
        homePage
                .searchItem(product)
                .AddToCart(product)
                .clickProceedToCheckout()
                .verifyProduct(product)
                .clickProceedToCheckout()
                .enterEmailAndCreateAccount(email)
                .enterPersonalInformationAndContinue("firstName","lastName", "StreeAddress", "New York","Alaska",99501,"United States", 1234567896)
                .verifyDeliveryAddressPage("firstName","lastName","StreeAddress","New York","Alaska","99501","United States","1234567896")
                .verifyInvoiceAddressPage("firstName","lastName","StreeAddress","New York","Alaska","99501","United States","1234567896")
                .clickProceedToCheckout()
                .agreeTermsAndConditionsAndContinue()
                .selectCheckPaymentAndConfirmOrder()
                .verifyOrderSuccessMessage("Your order on My Store is complete.");
    }

    @Test(priority = 2)
    public void testPurchaseExistingUser(){
        String product="T-shirts";
        String userEmail="email33@sample33.com";
        String userPassword="testPassword";
        homePage
                .clickSignIn()
                .login(userEmail,userPassword)
                .verifySuccessfulLogin("firstName","lastName")
                .getHomePage()
                .searchItem(product)
                .AddToCart(product)
                .clickProceedToCheckout()
                .verifyProduct(product)
                .proceedToAddressPage()
                .verifyDeliveryAddressPage("firstName","lastName","StreeAddress"+33,"New York","Alaska","99501","United States","1234567896")
                .verifyInvoiceAddressPage("firstName","lastName","StreeAddress"+33,"New York","Alaska","99501","United States","1234567896")
                .clickProceedToCheckout()
                .agreeTermsAndConditionsAndContinue()
                .selectCheckPaymentAndConfirmOrder()
                .verifyOrderSuccessMessage("Your order on My Store is complete.");
    }

    @AfterMethod()
    public void tearDown(){

        DriverFactory.getInstanceOfDriverFactory().quit();
    }
}
