Feature: Menu Bar Page

  Scenario: MenuBar Home
    Given User click Menu bar
    When User Click Home button
    Then User navigate to homepage

  Scenario: MenuBar Interior
    Given User click Menu bar
    When User Click Interior button
    Then User navigate to Interiorpage

  Scenario: MenuBar Amenities
    Given User click Menu bar
    When User Click Amenities button
    Then User navigate to Amenitiespage