package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import java.time.Duration;
import Pages.HeaderSectionPage;
import Pages.LoginPage;

public class HeaderSectionSteps {
    public WebDriver driver;
    HeaderSectionPage headerSectionPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win32-10-08-24 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Given("user is on any page with header section")
    public void anyPageONHeaderSetion(){
        driver.get("https://qamoviesapp.ccbp.tech");
        headerSectionPage = new HeaderSectionPage(driver);
        loginPage = new LoginPage(driver);


        loginPage.loginApplication("rahul", "rahul@2021");
        String actualUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualUrl));
    }

    @Then("header logo is displayed")
    public void headerSectionUi() {
        Assert.assertTrue(headerSectionPage.getHeaderWebsiteLogo().isDisplayed(), "Header Website Logo not displayed");

        Assert.assertTrue(headerSectionPage.getHomeWebsiteLogo().isDisplayed(), "Home Website Logo not displayed");

        Assert.assertTrue(headerSectionPage.getPopularWebsiteLogo().isDisplayed(), "Popular Website Logo not displayed");

        Assert.assertTrue(headerSectionPage.getSearchWebsiteLogo().isDisplayed(), "Search Website Logo not displayed");

        Assert.assertTrue(headerSectionPage.getAccountWebsiteLogo().isDisplayed(), "Account Website Logo not displayed");


    }


    @Then("Popular link is displayed and check Popular Functionality")
    public void headerSectionPopularFuctionality() {

        // checking the navigation of Popular page through elements in the header section

        headerSectionPage.clickPopularNavbar();
        String actualPopularUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(actualPopularUrl));

        String currentPopularUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualPopularUrl, currentPopularUrl, "Popular URLs do not match");


    }

    @Then("Search link is displayed and check Search Functionality")
    public void headerSectionSearchFuctionality() {

        // checking the navigation of Popular page through elements in the header section

        headerSectionPage.clickOnSearchEmptyIcon();

        String actualSearchUrl="https://qamoviesapp.ccbp.tech/search";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualSearchUrl));

        String currentSearchUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualSearchUrl,currentSearchUrl,"URLs do not match");


    }

    @Then("Account link is displayed and check Account Functionality")
    public void headerSectionAccountFuctionality(){

        headerSectionPage.clickAccountHomeNavbar();

        String actualAccountUrl="https://qamoviesapp.ccbp.tech/account";

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.urlToBe(actualAccountUrl));

        String currentAccountUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualAccountUrl,currentAccountUrl,"Account URLs do not match");
    }

    @Then("home link is displayed and check Home Functionality")
    public void headerSectionHomeFuctionality(){
        headerSectionPage.clickHomeNavbar();

        String actualHomeUrl="https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.urlToBe(actualHomeUrl));

        String currentHomeUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualHomeUrl,currentHomeUrl,"Home URLs do not match");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}