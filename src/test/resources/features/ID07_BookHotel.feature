
Feature: Search Book Hotel

  Scenario: Search hotel
    Given User login "agil@mailnesia.com" "d1234567" and go to dashboard
    When User searh the hotel book
    Then User verify date Book Hotel

  Scenario: verify Location
    Given User login "agil@mailnesia.com" "d1234567" and go to dashboard
    When User searh the hotel book
    Then User verify Location of Hotel

    Scenario: input date keyword
      Given User login "agil@mailnesia.com" "d1234567" and go to dashboard
      When User input check in "15-04-2022" and checkout date "21-04-2022"
      Then user click button search now