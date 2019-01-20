package pageobjects;

import baseclasses.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Jatin on 1/19/2019.
 */
public class AddressPage extends BasePage {

    By deliveryAddressHeading=By.cssSelector("#address_delivery .address_title");
    By deliveryAddressFirstNameLastName=By.cssSelector("#address_delivery .address_firstname.address_lastname");
    By deliveryAddressStreet=By.cssSelector("#address_delivery .address_address1");
    By deliveryAddressCityStatePostCode=By.cssSelector("#address_delivery .address_city.address_state_name.address_postcode");
    By deliveryAddressCountry=By.cssSelector("#address_delivery .address_country_name");
    By deliveryAddressPhone=By.cssSelector("#address_delivery .address_phone_mobile");

    By invoiceAddressHeading=By.cssSelector("#address_invoice .address_title");
    By invoiceAddressFirstNameLastName=By.cssSelector("#address_invoice .address_firstname.address_lastname");
    By invoiceAddressStreet=By.cssSelector("#address_invoice .address_address1");
    By invoiceAddressCityStatePostCode=By.cssSelector("#address_invoice .address_city.address_state_name.address_postcode");
    By invoiceAddressCountry=By.cssSelector("#address_invoice .address_country_name");
    By invoiceAddressPhone=By.cssSelector("#address_invoice .address_phone_mobile");
    By proceedToCheckout=By.xpath("//button[contains(.,'Proceed to checkout')]");

    public AddressPage verifyDeliveryAddressPage(String firstName, String lastName, String street, String city, String state, String postCode, String country, String mobilePhone){
        Assert.assertTrue(getElementText(deliveryAddressHeading).contains("YOUR DELIVERY ADDRESS"));
        Assert.assertTrue(getElementText(deliveryAddressFirstNameLastName).contains(firstName+ " " +lastName));
        Assert.assertTrue(getElementText(deliveryAddressStreet).contains(street));
        Assert.assertTrue(getElementText(deliveryAddressCityStatePostCode).contains(city + "," + " " + state+ " " +postCode));
        Assert.assertTrue(getElementText(deliveryAddressCountry).contains(country));
        Assert.assertTrue(getElementText(deliveryAddressPhone).contains(mobilePhone));
        return this;
    }

    public AddressPage verifyInvoiceAddressPage(String firstName, String lastName, String street, String city, String state, String postCode, String country, String mobilePhone){
        Assert.assertTrue(getElementText(invoiceAddressHeading).contains("YOUR BILLING ADDRESS"));
        Assert.assertTrue(getElementText(invoiceAddressFirstNameLastName).contains(firstName+ " " +lastName));
        Assert.assertTrue(getElementText(invoiceAddressStreet).contains(street));
        Assert.assertTrue(getElementText(invoiceAddressCityStatePostCode).contains(city + "," + " " + state+ " " +postCode));
        Assert.assertTrue(getElementText(invoiceAddressCountry).contains(country));
        Assert.assertTrue(getElementText(invoiceAddressPhone).contains(mobilePhone));
        return this;
    }

    public ShippingPage clickProceedToCheckout(){
        clickElement(find(proceedToCheckout));
        return new ShippingPage();
    }

}
