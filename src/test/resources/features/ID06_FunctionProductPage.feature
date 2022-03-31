
Feature: Function

  Scenario: Check Rating Function
    Given User login "agil@mailnesia.com" "d1234567" and book
    And  User book and go to product page
    When User Check Function rating
    Then User see product category

  Scenario: Check Amenities Function
    Given User login "agil@mailnesia.com" "d1234567" and book
    And  User book and go to product page
    When User Check Amenities Function
    Then User see notification message "No room available for this hotel!"

  Scenario: Check Slider Price
    Given User login "agil@mailnesia.com" "d1234567" and book
    And  User book and go to product page
    When User Slide the price
    Then User see product display