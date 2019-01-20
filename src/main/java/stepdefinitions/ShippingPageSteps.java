package stepdefinitions;

import cucumber.api.java.en.Then;
import pageobjects.ShippingPage;

/**
 * Created by Jatin on 1/20/2019.
 */
public class ShippingPageSteps {
    ShippingPage shippingPage=new ShippingPage();

    @Then("User agree the terms and conditions and continue to payment page")
    public void agreeToTermsAndConditionAndContinue() throws Throwable{
        shippingPage.agreeTermsAndConditionsAndContinue();
    }
}
