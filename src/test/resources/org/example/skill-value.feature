Feature: Verify Skill value search quizzes

  This test will search some quizzes by topic

  Scenario Outline: Find quizzes by technology
    Given The page with SkillValue is open
    When I am inserting "<keyword>"
    Then I am getting results

    Examples:
      | keyword    |
      | Java       |
      | Python     |
      | Ruby       |
      | JavaScript |

  Scenario: Results not found
    Given The page with SkillValue is open
    When I am inserting "SomethingThatCannotBeFoundOnSkillValue"
    Then I am getting no results
