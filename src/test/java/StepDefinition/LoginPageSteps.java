package StepDefinition;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win32-10-08-24 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {

        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }

    @Then("website logo and login button is displayed  and check the heading text ,username and password")
    public void loginPageUi(){
        Assert.assertTrue(loginPage.getWebsiteLogo().isDisplayed(),"App logo is not displayed");

        Assert.assertEquals(loginPage.getLabelText(0),"USERNAME","Username label text does not match");

        Assert.assertEquals(loginPage.getLabelText(1),"PASSWORD","Password label text does not match");

        String actualSignInHeading=loginPage.getSignInHeading();

        Assert.assertEquals(actualSignInHeading,"Login","Login text does not matched");

        Assert.assertTrue(loginPage.getloginbuttondisplayed().isDisplayed(),"Login Button is not displayed");


    }

    @When("I click on login button then an error message will be shown")
    public void submissionEmptyInputs(){
        loginPage.clickLoginButton();
        String actualErorMsg=loginPage.getErrorMesage();
        Assert.assertEquals(actualErorMsg,"*Username or password is invalid","Error text with empty input fields does not match");

    }

    @And("enter the password only then an error message will be shown")
    public void loginWithEmptyUsername(){
        loginPage.loginApplication("","rahul@2021");
        String actualErrorMsg=loginPage.getErrorMesage();
        Assert.assertEquals(actualErrorMsg,"*Username or password is invalid","Error text with empty input field do not match");
    }


    @And("enter the username only then an error message will be shown")
    public void loginWithEmptyPassword(){
        loginPage.loginApplication("rahul","");
        String actualErrorMsg=loginPage.getErrorMesage();
        Assert.assertEquals(actualErrorMsg,"*Username or password is invalid","Error text with empty input field do not match");
    }

    @And("enter the wrong username and password then an error message will be shown")
    public void loginWithInvalidCred(){
        loginPage.loginApplication("rahul","rahul");
        String actualErrorMsg=loginPage.getErrorMesage();
        Assert.assertEquals(actualErrorMsg,"*username and password didn't match","Error text with invalid password do not match");
    }


    @Then("I enter the correct username and password and I will navigate to the home page")
    public void loginWithValidCred(){

        loginPage.loginApplication("rahul","rahul@2021");
        String actulUrl="https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(actulUrl));

        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(actulUrl,currentUrl,"URLs do not match");

    }


    @After
    public void close_the_browser() {
        driver.quit();
    }
}
