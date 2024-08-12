package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;


public class PopularPage {
    By listOfMovies=By.cssSelector("div[class $=search-movies-container] li");
    By movieSpiderMan=By.xpath("//img[@alt ='The Amazing Spider-Man']");

    WebDriver driver;
    WebDriverWait wait;

    public PopularPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public int getAlLMoviesList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOfMovies));
        List<WebElement> list=driver.findElements(listOfMovies);
        return list.size();
    }

    public void clickOnSpiderManMovie(){
        driver.findElement(movieSpiderMan).click();
    }

}