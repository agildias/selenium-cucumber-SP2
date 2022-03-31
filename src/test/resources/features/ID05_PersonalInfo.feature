
Feature: My Personal Info

  Scenario: Input personal info account with no Old password
    Given User Login "agil@mailnesia.com" "d1234567" and direct to MyAccount Page
    When User click personal information and input data "agil" "dias" "agil@mailnesia.com" ""
    Then User Get warn Notification "The password you entered is incorrect."

  Scenario: Input personal info account with no Email
    Given User Login "agil@mailnesia.com" "d1234567" and direct to MyAccount Page
    When User click personal information and input data "agil" "dias" "" "d1234567"
    Then User Get warn Notification "This email address is not valid"

  Scenario: Input personal info account with no lastname
    Given User Login "agil@mailnesia.com" "d1234567" and direct to MyAccount Page
    When User click personal information and input data "agil" "" "agil@mailnesia.com" "d1234567"
    Then User Get warn Notification "lastname is required."

  Scenario: Input personal info account with no firstname
    Given User Login "agil@mailnesia.com" "d1234567" and direct to MyAccount Page
    When User click personal information and input data "" "dias" "agil@mailnesia.com" "d1234567"
    Then User Get warn Notification "firstname is required."

  Scenario: Input personal info account
    Given User Login "agil@mailnesia.com" "d1234567" and direct to MyAccount Page
    When User click personal information and input data "agil" "dias" "agil@mailnesia.com" "d1234567"
    Then User Get succes Notification "Your personal information has been successfully updated."