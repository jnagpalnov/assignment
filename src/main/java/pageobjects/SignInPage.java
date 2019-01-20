package pageobjects;

import baseclasses.BasePage;
import org.openqa.selenium.By;

/**
 * Created by Jatin on 1/18/2019.
 */
public class SignInPage extends BasePage {

    By signUpEmailField =By.id("email_create");
    By createAccountButton=By.id("SubmitCreate");
    By firstNameField=By.id("customer_firstname");
    By lastNameField=By.id("customer_lastname");
    By signUpPasswordField=By.id("passwd");
    By cityField=By.id("city");
    By stateField=By.id("id_state");
    By postCodeField=By.id("postcode");
    By countryField=By.id("id_country");
    By mobileField=By.id("phone_mobile");
    By registerButton=By.id("submitAccount");
    By addressFirstName=By.id("firstname");
    By addressLastName=By.id("lastname");
    By address=By.id("address1");
    By aliasAddress=By.id("alias");
    By emailField=By.id("email");
    By passwordField=By.id("passwd");
    By signInButton=By.id("SubmitLogin");

    public SignInPage enterEmailAndCreateAccount(String email){
        enterText(find(signUpEmailField),email);
        clickElement(find(createAccountButton));
        return this;
    }

    public MyAccountPage login(String email,String password){
        enterText(find(emailField),email);
        enterText(find(passwordField),password);
        clickElement(find(signInButton));
        return new MyAccountPage();
    }

    public AddressPage enterPersonalInformationAndContinue(String firstName, String lastName, String streetAddress, String city, String state, int postalCode, String country, int mobile){
         enterText(find(firstNameField),firstName);
         enterText(find(lastNameField),lastName);
         enterText(find(signUpPasswordField),"testPassword");
         enterText(find(addressFirstName),firstName);
         enterText(find(addressLastName),lastName);
         enterText(find(address),streetAddress);
         enterText(find(cityField),city);
         selectOption(state,stateField);
         enterText(find(postCodeField),String.valueOf(postalCode));
         selectOption(country,countryField);
         enterText(find(mobileField),String.valueOf(mobile));
         enterText(find(aliasAddress),streetAddress);
         clickElement(find(registerButton));
         return new AddressPage();
    }


}
