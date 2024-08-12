package StepDefinition;

import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.*;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import Pages.LoginPage;
import Pages.HomePage;

public class HomePageSteps {
    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win32-10-08-24 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Given("user is on home page")
    public void onHOmePage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);


        loginPage.loginApplication("rahul","rahul@2021");
        String actualUrl="https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualUrl));
    }


    @Then("check the heading texts of each section and play button display and contact sections")
    public void checkingHeadingTexts() {

        Assert.assertTrue(homePage.getHomeMovieHeading().isDisplayed(),"Movie Heading  is not displayed");

        Assert.assertTrue(homePage.getHomeMovieDesc().isDisplayed(),"Movie Description is not displayed");

        Assert.assertTrue(homePage.getOnPlayButton().isDisplayed(),"Play Button is not displayed");

        Assert.assertTrue(homePage.getHomeMovieHeadingTrending().isDisplayed(),"Trending Now  is not displayed");

        Assert.assertTrue(homePage.getHomeMovieHeadingOriginals().isDisplayed(),"Originals is not displayed");

        String actualContactSection=homePage.getContactSection();
        Assert.assertEquals(actualContactSection,"Contact Us","Contact Us section is not displayed");

    }



    @And("check and display all the Trending Now  movies List")
    public void trendingNowMovieList(){
        homePage.getTrendingNowMoviesList();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slick-list")));

        int actualCount = homePage.getTrendingNowMoviesList();

        Assert.assertEquals(actualCount,10,"Counting is not matched");
    }


    @And("check and display all the Original  movies List")
    public void OriginalMovieList(){
        homePage.getOriginalsMoviesList();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slick-list")));

        int actualCount = homePage.getOriginalsMoviesList();

        Assert.assertEquals(actualCount,10,"Counting is not matched");

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}