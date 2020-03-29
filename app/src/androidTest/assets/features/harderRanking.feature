Feature: HarderRanking

  @firstGets10MorePoints
  Scenario: NewScoreWorseThanAll
    Given DefaultRanking
    When NewScoreWorseThanAllIsGotten
    Then FirstScoreIncrementsTen