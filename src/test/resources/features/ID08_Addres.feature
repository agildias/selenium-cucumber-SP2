
Feature: Addres Account

  Scenario: input data Addres with no first addres
    Given User login and go to My Account address
    When User input all fill"agil" "dias" "Pt.JAYA" "" "JawaTimur" "12345" "Surabaya" "0355123" "085777" "teoriadd" "Sidoarjo"
    Then user get error notification

  Scenario: input data Addres with no postalcode
    Given User login and go to My Account address
    When User input all fill"agil" "dias" "Pt.JAYA" "Jl.Kemarau" "JawaTimur" "" "Surabaya" "0355123" "085777" "teoriadd" "Sidoarjo"
    Then user get error notification

  Scenario: input data Addres with no city
    Given User login and go to My Account address
    When User input all fill"agil" "dias" "Pt.JAYA" "Surabaya" "JawaTimur" "12345" "" "0355123" "085777" "teoriadd" "Sidoarjo"
    Then user get error notification

  Scenario: input data Addres with no home phone
    Given User login and go to My Account address
    When User input all fill"agil" "dias" "Pt.JAYA" "Surabaya" "JawaTimur" "12345" "Surabaya" "asd" "085777" "teoriadd" "Sidoarjo"
    Then user get error notification

  Scenario: input all fill data
    Given User login and go to My Account address
    When User input all fill"agil" "dias" "Pt.JAYA" "Surabaya" "JawaTimur" "12345" "Surabaya" "12345" "123" "teoriadd" " Sidoarjo"
    Then mobile assertEqual

    Scenario: delete data Addres
      Given User login and go to My Account address
      When User click my addres
      Then User delete data addres
