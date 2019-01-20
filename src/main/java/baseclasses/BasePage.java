package baseclasses;

import commonutils.CommonUtils;
import driversetup.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;

/**
 * Created by Jatin on 1/18/2019.
 */
public class BasePage {

    public WebDriver driver;
    WebDriverWait wait;

    protected BasePage(){
        this.driver= DriverFactory.getInstanceOfDriverFactory().getDriver();
        setWait(Integer.parseInt(CommonUtils.getCentralData("WaitTimeoutInSeconds")));
    }

    public void openWebApp(String AppUrl ) {
        Reporter.log("Opening URl:" + AppUrl);
        driver.get(AppUrl);
    }

    /**
     * @param by
     * @return wait for visibility of element and then return true if element is present else false
     */
    protected boolean isElementPresent(By by){
        try {
            Reporter.log("Waiting for visibility of element having locator:" + by);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)) != null;
        }
        catch (TimeoutException ex){
            return false;
        }
    }

    protected boolean isElementPresent(WebElement webElement){
        try {
            Reporter.log("Waiting for visibility of element " + webElement);
            return wait.until(ExpectedConditions.visibilityOf(webElement)) != null;
        }
        catch (TimeoutException ex){
            return false;
        }
    }

    /**
     * @param by
     * @return return inner text of the element
     */
    protected String getElementText(By by){
        return find(by).getText();
    }

    /**
     * @param by
     * @return return list of web elements
     */
    protected List<WebElement> findElements(By by){
        try {
            Reporter.log("Waiting for visibility of elements having locator:" + by);
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        }
        catch (TimeoutException ex){
            return null;
        }
    }

    protected WebElement find(By by){
        try {
            // wait.until(ExpectedConditions.stalenessOf(driver.findElement(by)));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (TimeoutException ex){
            return null;
        }
    }

    protected WebElement findElementPresence(By by){
        try {
            // wait.until(ExpectedConditions.stalenessOf(driver.findElement(by)));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch (TimeoutException ex){
            return null;
        }
    }

    protected void selectOption(String text, By by){
        Reporter.log("Select option :" + text);
        Select select=new Select(findElementPresence(by));
        select.selectByVisibleText(text);
    }

    protected String getFirstSelectedOption(By by){
        Select select=new Select(find(by));
        return select.getFirstSelectedOption().getText();
    }


    protected void clickElement(WebElement webElement){
        webElement.click();
    }

    protected void moveToElement(WebElement webElement){
        Actions actions=new Actions(driver);
        actions.moveToElement(webElement).perform();
    }


    protected void clickJS(WebElement webElement){
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",webElement);
    }

    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    protected void enterText(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    private void setWait(long timeoutInSeconds ){
        wait=new WebDriverWait(driver,timeoutInSeconds);
    }
}
