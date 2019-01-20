package pageobjects;

import baseclasses.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Jatin on 1/19/2019.
 */
public class PaymentPage extends BasePage {

    By payByCheck=By.xpath("//a[contains(.,'Pay by check')]");
    By confirmOrder=By.xpath("//button[contains(.,'I confirm my order')]");
    By orderSuccess=By.cssSelector(".alert.alert-success");

    public PaymentPage selectCheckPaymentAndConfirmOrder(){
        clickElement(find(payByCheck));
        clickElement(find(confirmOrder));
        return this;
    }
    public PaymentPage verifyOrderSuccessMessage(String message){
        String actualMessage=getElementText(orderSuccess);
        Assert.assertTrue(actualMessage.contains(message),"Actual message:" +actualMessage+"Expected :" + message);
        return this;
    }
}
