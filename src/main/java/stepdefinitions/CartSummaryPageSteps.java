package stepdefinitions;

import cucumber.api.java.en.Then;
import pageobjects.CartSummaryPage;

/**
 * Created by Jatin on 1/20/2019.
 */
public class CartSummaryPageSteps {
     CartSummaryPage cartSummaryPage=new CartSummaryPage();

    @Then("Verify product detail for \"(.*)\" and continue to SignIn page")
    public void verifyProductDetailAndContinueToSignIN(String product) throws Throwable{
        cartSummaryPage
                .verifyProduct(product)
                .clickProceedToCheckout();
    }

    @Then("Verify product detail for \"(.*)\" and continue to delivery address page")
    public void verifyProductDetailAndContinueToAddressPage(String product) throws Throwable{
        cartSummaryPage
                .verifyProduct(product)
                .proceedToAddressPage();
    }
}
