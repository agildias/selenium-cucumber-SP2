Feature: Proceed check out

  Scenario: order general rooms
    Given User check in "17-03-2022" and checkout date "18-03-2022"
    When User order General Rooms Hotel
    Then verify Time Duration Order

  Scenario: checkout order general rooms
    Given User check in "17-03-2022" and checkout date "18-03-2022"
    When User order General Rooms Hotel
    Then User proced to Checkut order

  Scenario: verify price room order
    Given User check in "17-03-2022" and checkout date "18-03-2022"
    When User order General Rooms Hotel
    Then User verify price