package stepdefinitions;

import commonutils.CommonUtils;
import cucumber.api.java.en.Given;
import driversetup.DriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jatin on 1/20/2019.
 */
public class BackgroundSteps {

    @Given("User is on the Home page")
    public void navigateToHomePage() throws Throwable{
        WebDriver driver= DriverFactory.getInstanceOfDriverFactory().getDriver();
        driver.get(CommonUtils.getCentralData("AppUrl"));
    }

}
