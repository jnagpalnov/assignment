package pageobjects;

import baseclasses.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Jatin on 1/20/2019.
 */
public class MyAccountPage extends BasePage {
    By signOut=By.xpath("//div[@class='header_user_info']//a[contains(.,'Sign out')]");
    By userNameAndEmail=By.xpath("//div[@class='header_user_info']//a[contains(@class,'account')]");

    public MyAccountPage verifySuccessfulLogin(String firstName, String lastName){
        Assert.assertTrue(isElementPresent(find(signOut)),"Sign out link is not present");
        Assert.assertTrue(getElementText(userNameAndEmail).contains(firstName + " " + lastName), "Expected:" +firstName + " " + lastName + "Actual:"+ getElementText(userNameAndEmail));
        return this;
    }

    public HomePage getHomePage(){
        return new HomePage();
    }
}
