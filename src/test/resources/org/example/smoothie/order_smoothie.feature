Feature: Ordering smoothie from internet shop

  THis is a test cucumber

  Scenario Outline: Ordering two different cocktails
    Given I have <initial_sum> dollar, Prices are:
      | Apple Smoothie | 75
      | Green Tea      | 20
    When I am ordering one "<drink_name>"
    Then I am receiving <final_sum> dollars

    Examples:
      | initial_sum | drink_name     | final_sum
      | 100         | Apple Smoothie | 25
      | 250         | Apple Smoothie | 175
      | 300         | Green Tea      | 280
