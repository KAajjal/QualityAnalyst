package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchPage {
    By searchEmptyIcon=By.cssSelector("div.search-account-container >:first-child");
    By searchInputField=By.cssSelector("input#search");
    By searchIconButton=By.className("search-button");
    By moviesCount=By.cssSelector("ul.search-movies-container li");
    By searchPageErrorMsgImage=By.className("not-found-search-image");
    By searchPageErrorMsgText=By.className("not-found-search-paragraph");

    WebDriver driver;
    WebDriverWait wait;
    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void clickOnSearchEmptyIcon(){
        driver.findElement(searchEmptyIcon).click();
    }

    public void enterSearchInputField(String movieName){
        driver.findElement(searchInputField).sendKeys(movieName);
    }

    public void clickOnSearchIcon(){
        driver.findElement(searchIconButton).click();
    }

    public void searchApplication(String moviesName){
        enterSearchInputField(moviesName);
        clickOnSearchIcon();
    }

    public int getMoviesCount() {
        List<WebElement> list = driver.findElements(moviesCount);
        return list.size();
    }

    public String getErrorMesage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchPageErrorMsgText)).getText();
    }

    public WebElement getSearcgErrorImage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchPageErrorMsgImage));
        return driver.findElement(searchPageErrorMsgImage);
    }

}
