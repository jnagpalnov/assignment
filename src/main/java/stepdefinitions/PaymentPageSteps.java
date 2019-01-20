package stepdefinitions;

import cucumber.api.java.en.Then;
import pageobjects.PaymentPage;

/**
 * Created by Jatin on 1/20/2019.
 */
public class PaymentPageSteps {
    PaymentPage paymentPage=new PaymentPage();
    @Then("User select payment method as Check and confirm order")
    public void selectCheckPaymentAndConinue() throws Throwable{
        paymentPage.selectCheckPaymentAndConfirmOrder();

    }

    @Then("Order placed successfully  message is displayed")
    public void orderPlacedSuccessMessage() throws Throwable{
        paymentPage.verifyOrderSuccessMessage("Your order on My Store is complete.");
    }
}
