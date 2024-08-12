package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HeaderSectionPage {
    By headerWebsiteLogo=By.cssSelector("div[class $=nav-content] img.website-logo");
    By headerNavHomeLOcator=By.linkText("Home");
    By headerNavPopularLOcator=By.linkText("Popular");
    By searchEmptyIcon=By.cssSelector("div.search-account-container >:first-child");
    By headerNavAccountLOcator=By.cssSelector("div[class $=nav-content] + div>:nth-child(2)");

    WebDriver driver;
    WebDriverWait wait;

    public HeaderSectionPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement getHeaderWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerWebsiteLogo));
        return driver.findElement(headerWebsiteLogo);
    }

    public WebElement getHomeWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerNavHomeLOcator));
        return driver.findElement(headerNavHomeLOcator);
    }

    public WebElement getPopularWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerNavPopularLOcator));
        return driver.findElement(headerNavPopularLOcator);
    }

    public WebElement getSearchWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmptyIcon));
        return driver.findElement(searchEmptyIcon);
    }

    public WebElement getAccountWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerNavHomeLOcator));
        return driver.findElement(headerNavHomeLOcator);
    }


    public void clickHomeNavbar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerNavHomeLOcator));
        driver.findElement(headerNavHomeLOcator).click();
    }

    public void clickPopularNavbar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerNavPopularLOcator));
        driver.findElement(headerNavPopularLOcator).click();
    }

    public void clickOnSearchEmptyIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmptyIcon));
        driver.findElement(searchEmptyIcon).click();
    }



    public void clickAccountHomeNavbar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerNavAccountLOcator));
        driver.findElement(headerNavAccountLOcator).click();
    }



}