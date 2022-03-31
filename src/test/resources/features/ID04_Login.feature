
Feature: Login

  Scenario: Normal Login
    Given User navigate to login home page
    When User input "agil@mailnesia.com" as username and "d1234567" as password
    Then User see dashboard

  Scenario Outline: User invalid to Login
    Given User navigate to login home page
    When User input "<username>" as username and "<password>" as password
    Then User get "<errorMessage>"
    Examples:
      | username           | password | errorMessage               |
      | agil@mailnesia.com |          | Password is required.      |
      |                    | d1234567 | An email address required. |
      |                    |          | An email address required. |
