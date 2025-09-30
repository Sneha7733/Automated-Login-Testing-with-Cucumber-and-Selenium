package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;

    @Given("the user navigates to the login page")
    public void navigateToLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("the user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("the user should be redirected to the Secure Area page")
    public void verifySecureAreaPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        String heading = driver.findElement(By.tagName("h2")).getText();
        Assert.assertTrue("User not redirected!", heading.contains("Secure Area"));
        driver.quit();
    }

    @Then("an error message {string} should be displayed")
    public void verifyErrorMessage(String expectedMessage) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        String actualMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue("Error message mismatch!", actualMessage.contains(expectedMessage));
        driver.quit();
    }

    @Then("an error message {string} should be displayed for both fields")
    public void verifyRequiredFields(String expectedMessage) {
        // NOTE: The site shows "Your username is invalid!" when fields are empty
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        String actualMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue("Expected validation message not found!", actualMessage.contains(expectedMessage));
        driver.quit();
    }

    @Then("the result should be {string}")
    public void verifyResult(String expected) {
        if (expected.equals("Secure Area")) {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
            String heading = driver.findElement(By.tagName("h2")).getText();
            Assert.assertTrue("Expected Secure Area!", heading.contains("Secure Area"));
        } else {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
            String actualMessage = driver.findElement(By.id("flash")).getText();
            Assert.assertTrue("Error mismatch!", actualMessage.contains(expected));
        }
        driver.quit();
    }
}
