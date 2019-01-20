package driversetup;

import commonutils.CommonUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jatin on 1/18/2019.
 */
public class DriverFactory {
    private WebDriver driver;

    /**
     * Singleton class
     */
    private DriverFactory() {
        initializeWebDriver();
    }

    private static DriverFactory instanceOfDriverFactory;

    public static DriverFactory getInstanceOfDriverFactory() {
        if(instanceOfDriverFactory ==null)
        {
            instanceOfDriverFactory = new DriverFactory();
        }
        return instanceOfDriverFactory;
    }

    /**
     * Initialize Web driver
     */
    private void initializeWebDriver()  {
        String browser= System.getProperty("browser")!=null?System.getProperty("browser"):CommonUtils.getCentralData("Browser");

        if(browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            WebDriverManager.iedriver().setup();
            //System.setProperty("webdriver.ie.driver",CommonUtils.getCentralData("IEDriverExePath"));
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * @return instance of Webdriver
     */
    public WebDriver getDriver(){
        return  driver;
    }

    /**
     *  Set driverFactory instance null and quit WebDriver
     */
    public void quit(){
        instanceOfDriverFactory=null;
        driver.quit();
    }
}
