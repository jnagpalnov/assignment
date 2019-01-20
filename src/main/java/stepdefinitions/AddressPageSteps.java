package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import pageobjects.AddressPage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jatin on 1/20/2019.
 */
public class AddressPageSteps {
    AddressPage addressPage=new AddressPage();

    @Then("Verify delivery address, invoice address and continue to Shipping Page")
    public void verifyDeliverAddressInvoiceAddressAndContinue(DataTable dataTable) throws Throwable{
        Map<String, String> userDetails=  dataTable.asMap(String.class,String.class);
        addressPage
                .verifyDeliveryAddressPage(userDetails.get("firstName"),userDetails.get("lastName"),
                        userDetails.get("streetAddress"), userDetails.get("city"),userDetails.get("state"),
                        userDetails.get("postalCode"),userDetails.get("country"),
                        userDetails.get("mobile"))
                .verifyInvoiceAddressPage(userDetails.get("firstName"),userDetails.get("lastName"),
                        userDetails.get("streetAddress"), userDetails.get("city"),userDetails.get("state"),
                        userDetails.get("postalCode"),userDetails.get("country"),
                        userDetails.get("mobile"))
                .clickProceedToCheckout();

    }
}
