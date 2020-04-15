Feature: RandomColors

  @randomColorSquare
  Scenario: squareChangesRandomly
    Given squareIsRed
    When RandomButtonIsSelected
    Then SquareCanBeAnythingButRed

  @randomColorL
  Scenario: lChangesRandomly
    Given lIsBlue
    When RandomButtonIsSelected
    Then lCanBeAnythingButBlue

  @randomColorZ
  Scenario: zChangesRandomly
      Given zIsGreen
      When RandomButtonIsSelected
      Then zCanBeAnythingButGreen

  @randomColorI
  Scenario: iChangesRandomly
    Given iIsYellow
    When RandomButtonIsSelected
    Then iCanBeAnythingButYellow

  @randomColorT
  Scenario: tChangesRandomly
     Given tIsPink
     When RandomButtonIsSelected
     Then tCanBeAnythingButPink

  @randomColorS
  Scenario: sChangesRandomly
    Given sIsOrange
    When RandomButtonIsSelected
    Then sCanBeAnythingButOrange
