Feature: Verify GitHub login feature

  This test will open the browser and will try different ways to login

  Scenario Outline: Invalid credentials scenario
    Given The page with GitHub is open
    When I am logging in with login: "<login>" and password: "<password>"
    Then I am receiving error message

    Examples:
      | login      | password      |
      | test       |               |
      |            | testpassword  |
      | wronglogin | wrongpassword |
