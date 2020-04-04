Feature: RandomColors

  @randomColorSquare
  Scenario: squareChangesRandomly
    Given squareIsRed
    When RandomButtonIsSelected
    Then SquareCanBeAnythingButRed