package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import java.time.Duration;
import Pages.*;

public class PopularPageSteps {
    public WebDriver driver;
    PopularPage popularPage;
    LoginPage loginPage;
    HeaderSectionPage headerSectionPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win32-10-08-24 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Given("user is on popular page")
    public void userISOnPopularPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        headerSectionPage = new HeaderSectionPage(driver);
        loginPage = new LoginPage(driver);
        popularPage = new PopularPage(driver);


        loginPage.loginApplication("rahul", "rahul@2021");
        String actualUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualUrl));

        headerSectionPage.clickPopularNavbar();
        String actualPopularUrl = "https://qamoviesapp.ccbp.tech/popular";

        wait.until(ExpectedConditions.urlToBe(actualPopularUrl));

    }

    @Then("movies are displayed on popular page")
    public void checkMoviesDisplay(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-icon-item")));

        int actualMovieCount = popularPage.getAlLMoviesList();

        Assert.assertEquals(actualMovieCount,30,"Counting is not matched");
    }

    @Then("click on Spider man movie and redirect to the movie page")
    public void clickOnMovie(){
        popularPage.clickOnSpiderManMovie();

        String actualURL="https://qamoviesapp.ccbp.tech/movies/d53a2c0b-c3cc-4ed6-85a0-6ebf9b3ba79e";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualURL));

        String currentURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,currentURL,"URL's do not match");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}