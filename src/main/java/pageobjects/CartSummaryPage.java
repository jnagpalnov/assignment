package pageobjects;

import baseclasses.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Jatin on 1/18/2019.
 */
public class CartSummaryPage extends BasePage {

    By productName=By.xpath("//td[@class='cart_description']//p[contains(@class,'product-name')]//a");
    By proceedToCheckout=By.xpath("(//a[contains(@title,'Proceed to checkout')])[last()]");

    public CartSummaryPage verifyProduct(String product){
        Assert.assertTrue(getElementText(productName).contains(product),"Product '"+product + "' is not present on page");
        return this;
    }

    public SignInPage clickProceedToCheckout(){
        clickElement(find(proceedToCheckout));
        return new SignInPage();
    }

    public AddressPage proceedToAddressPage(){
        clickElement(find(proceedToCheckout));
        return new AddressPage();
    }
}
