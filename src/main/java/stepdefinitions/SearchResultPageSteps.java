package stepdefinitions;

import cucumber.api.java.en.Then;
import pageobjects.SearchResultsPage;

/**
 * Created by Jatin on 1/20/2019.
 */
public class SearchResultPageSteps {
    SearchResultsPage searchResultsPage=new SearchResultsPage();

    @Then("User add product \"(.*)\" to cart and continue to cart summary page")
    public void addProductToCartAndContinueToSummaryDetail(String product) throws Throwable{
        searchResultsPage
                .AddToCart(product)
                .clickProceedToCheckout();
    }

    @Then("Search results for \"(.*)\" product are displayed")
    public void verifySearchResults(String product) throws Throwable{
        searchResultsPage.verifySearchResults(product);
    }


}
