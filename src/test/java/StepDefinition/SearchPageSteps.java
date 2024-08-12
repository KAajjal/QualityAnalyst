package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import java.time.Duration;
import Pages.*;

public class SearchPageSteps {
    public WebDriver driver;
    SearchPage searchPage;
    LoginPage loginPage;
    HeaderSectionPage headerSectionPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win32-10-08-24 (1)\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Given("user is on search page")
    public void userIsOnSearchPage(){

        driver.get("https://qamoviesapp.ccbp.tech");
        headerSectionPage = new HeaderSectionPage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);


        loginPage.loginApplication("rahul", "rahul@2021");
        String actualUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualUrl));

        headerSectionPage.clickPopularNavbar();
        String actualPopularUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.urlToBe(actualPopularUrl));
    }

    @When("user searches for movies and other search functionality")
    public void checkAllSearchFunctionality(){
        headerSectionPage.clickPopularNavbar();

        searchPage.clickOnSearchEmptyIcon();

        String actualSearchUrl="https://qamoviesapp.ccbp.tech/search";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualSearchUrl));

        String currentSearchUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualSearchUrl,currentSearchUrl,"URLs do not match");

        searchPage.searchApplication("a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-icon-item")));
        int actualCount = searchPage.getMoviesCount();
        Assert.assertEquals(actualCount,43,"Counting is not matched");


    }

    @When("user searches for movies and other failure search functionality")
    public void getfailureFunctionality(){

        searchPage.clickOnSearchEmptyIcon();

        String actualSearchUrl="https://qamoviesapp.ccbp.tech/search";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualSearchUrl));

        String currentSearchUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualSearchUrl,currentSearchUrl,"URLs do not match");

        searchPage.searchApplication("xyz");

        Assert.assertTrue(searchPage.getSearcgErrorImage().isDisplayed(),"Error image is not displayed");

        int actualCount = searchPage.getMoviesCount();

        System.out.println(actualCount);

        String actualError=searchPage.getErrorMesage();

        Assert.assertEquals(actualError,"Your search for xyz did not find any matches.","error message is not displayed");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}