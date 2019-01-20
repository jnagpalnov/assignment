package pageobjects;

import baseclasses.BasePage;
import org.openqa.selenium.By;

/**
 * Created by Jatin on 1/18/2019.
 */
public class HomePage extends BasePage {

    By searchBox=By.id("search_query_top");
    By searchIcon=By.name("submit_search");
    By signIn=By.xpath("//div[@class='header_user_info']//a[contains(.,'Sign in')]");

    public SearchResultsPage searchItem(String item){
        enterText(find(searchBox),item);
        clickElement(find(searchIcon));
        return  new SearchResultsPage();
    }

    public SignInPage clickSignIn(){
        clickElement(find(signIn));
        return new SignInPage();
    }


}
