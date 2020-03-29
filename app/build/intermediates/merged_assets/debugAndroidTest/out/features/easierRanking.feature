Feature: EasierRanking

  @firstLoses10Points
  Scenario: NewScoreWorseThanAllLeaderChange
    Given NewDefaultRanking
    When NewScorWorseThanAllIsGotten
    Then FirstScoreLosesTen