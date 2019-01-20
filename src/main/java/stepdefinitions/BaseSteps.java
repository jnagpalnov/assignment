package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driversetup.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jatin on 1/20/2019.
 */
public class BaseSteps {

    public DriverFactory driverFactory;

    @Before
    public void setUP() {
        driverFactory = DriverFactory.getInstanceOfDriverFactory();
        WebDriver driver=driverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @After
    public void tearDown(){
        driverFactory.quit();
    }
}
