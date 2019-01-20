package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import pageobjects.HomePage;
import pageobjects.SignInPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Jatin on 1/20/2019.
 */
public class SignInPageSteps {
    SignInPage signInPage=new SignInPage();
    @Then("User create a new account and continue to delivery address page")
    public void createNewAccountAndContinue(DataTable dataTable) throws Throwable{
        Random rand = new Random();
        int number = rand.nextInt(5000) + 1;
        String email= "email"+ number+"@sample"+ number+".com";
        Map<String, String> userDetails=  dataTable.asMap(String.class,String.class);
        signInPage.enterEmailAndCreateAccount(email)
                .enterPersonalInformationAndContinue(userDetails.get("firstName"),userDetails.get("lastName"),
                        userDetails.get("streetAddress"), userDetails.get("city"),userDetails.get("state"),
                        Integer.parseInt(userDetails.get("postalCode")),userDetails.get("country"),
                        Integer.parseInt(userDetails.get("mobile")));
    }

    @Then("User Sign in to the application using \"(.*)\" email and \"(.*)\" password")
    public void login(String userEmail, String userPassword){
       HomePage homePage=new HomePage();
        homePage
                .clickSignIn()
                .login(userEmail,userPassword);
    }
}
