package pageobjects;

import baseclasses.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Jatin on 1/18/2019.
 */
public class SearchResultsPage extends BasePage {
    By productContainer=By.cssSelector("div.product-container");
    By productName=By.cssSelector("div.product-container .product-name");
    By proceedToCheckout=By.xpath("//div[@id='layer_cart']//a[contains(@title,'Proceed to checkout')]");
    By productAddedModalWindow=By.xpath("//div[@id='layer_cart' and contains(.,'Product successfully added to your shopping cart')]");

    public SearchResultsPage verifySearchResults(String item){
        Assert.assertTrue(findElements(productContainer).size()>0,"There are no search results");
        Assert.assertTrue(getElementText(productName).contains(item), "Search result does not conatin any item :"+ item);
        return this;
    }

    public SearchResultsPage AddToCart(String product){
        By addToCart=By.xpath("//div[contains(@class,'product-container')]//h5[contains(.,'"+product+"')]//following-sibling::div//span[contains(.,'Add to cart')]");
        moveToElement(find(productContainer));
        clickElement(find(addToCart));
        return this;
    }

    public SearchResultsPage verifyProductSuccessfullyAddedPopUp(String product){
        Assert.assertTrue(isElementPresent(productAddedModalWindow),"Product successfully added pop up not displayed");
        return this;
    }

    public CartSummaryPage clickProceedToCheckout(){
        clickElement(find(proceedToCheckout));
        return new CartSummaryPage();
    }


}
