package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginGithubStepDefinitions {

  ChromeDriver driver;

  @Before
  public void init(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @Given("The page with GitHub is open")
  public void thePageWithGitHubIsOpen() {
    driver.get("https://github.com/login");
  }

  @When("I am logging in with login: {string} and password: {string}")
  public void iAmLoggingInWithLoginLoginAndPasswordPassword(String login, String password) {
    driver.findElement(By.id("login_field")).sendKeys(login);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.name("commit")).submit();
  }

  @Then("I am receiving error message")
  public void iAmReceivingErrorMessage() {
    Assert.assertEquals(driver.findElement(By.id("js-flash-container")).getText(),"Incorrect username or password.");
  }

  @After
  public void cleanUp(){
    driver.close();
  }
}
