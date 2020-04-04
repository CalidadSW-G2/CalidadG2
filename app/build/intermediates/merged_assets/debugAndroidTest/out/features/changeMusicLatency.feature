Feature: ChangeMusicLatency

  @changeMusicLatency20to10
  Scenario: from20to10
    Given musicThatChangesEvery20
    When changeEvery10isSelected
    Then musicChangesEvery10

  @changeMusicLatency10to20
  Scenario: from10to20
    Given musicThatChangesEvery10
    When changeEvery20isSelected
    Then musicChangesEvery20
