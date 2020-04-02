package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import java.util.Map;

public class OrderSmoothieStepDefinitions {

  private int initialSum;

  private Integer finalSum;

  private Map<String, Integer> prices;

  @Given("I have {int} dollar, Prices are:")
  public void i_have_dollar_Prices_are(Integer initialSum, Map<String, Integer> prices) {

    this.initialSum = initialSum;
    this.prices = prices;
  }

  @When("I am ordering one {string}")
  public void i_am_ordering_one(String name) {
    Integer price = prices.get(name);
    finalSum = initialSum - price;

  }

  @Then("I am receiving {int} dollars")
  public void i_am_receiving_final_sum_dollars(Integer finalSum) {
    assertEquals(finalSum, this.finalSum);
  }
}
