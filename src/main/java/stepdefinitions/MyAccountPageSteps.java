package stepdefinitions;

import cucumber.api.java.en.Then;
import pageobjects.MyAccountPage;

/**
 * Created by Jatin on 1/20/2019.
 */
public class MyAccountPageSteps {
     MyAccountPage myAccountPage=new MyAccountPage();
    @Then("Verify user with \"(.*)\" first name and \"(.*)\" password  is successfully signed in to application")
    public void verifyUserSuccessfullySignedIn(String firstName, String lastName) throws Throwable{
        myAccountPage.verifySuccessfulLogin(firstName,lastName);
    }
}
