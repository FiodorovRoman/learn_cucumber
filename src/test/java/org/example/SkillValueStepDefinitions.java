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

public class SkillValueStepDefinitions {

  ChromeDriver driver;

  @Before
  public void init() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @Given("The page with SkillValue is open")
  public void thePageWithSkillValueIsOpen() {
    driver.get("https://skillvalue.com/en/quizzes");
  }

  @When("I am inserting {string}")
  public void iAmInserting(String keyword) throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"page-content\"]/section/div/div[2]/div/div/form/div/input")).sendKeys(keyword);
    driver.findElement(By.className("search-submit")).submit();
  }

  @Then("I am getting results")
  public void iAmGettingResults() {
    Assert.assertFalse(driver.findElements(By.className("article-quizz")).isEmpty());
  }

  @Then("I am getting no results")
  public void iAmGettingNoResults() {
    Assert.assertTrue(driver.findElements(By.className("article-quizz")).isEmpty());
  }

  @After
  public void cleanUp() {
    driver.close();
  }
}
