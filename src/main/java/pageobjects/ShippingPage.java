package pageobjects;

import baseclasses.BasePage;
import org.openqa.selenium.By;

/**
 * Created by Jatin on 1/19/2019.
 */
public class ShippingPage extends BasePage {

    By termsAndConditionCheckbox=By.id("cgv");
    By proceedToCheckout=By.xpath("//button[contains(.,'Proceed to checkout')]");

    public PaymentPage agreeTermsAndConditionsAndContinue(){
        clickElement(findElementPresence(termsAndConditionCheckbox));
        clickElement(find(proceedToCheckout));
        return new PaymentPage();
    }
}
