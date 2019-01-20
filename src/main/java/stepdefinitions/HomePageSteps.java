package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;

/**
 * Created by Jatin on 1/20/2019.
 */
public class HomePageSteps {
    HomePage homePage=new HomePage();

    @When("^User search for the product \"(.*)\"$")
    public void searchProduct(String product) throws Throwable{
        homePage.searchItem(product);
    }

}
