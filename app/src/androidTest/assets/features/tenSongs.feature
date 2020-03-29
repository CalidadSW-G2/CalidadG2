Feature: TenSongs

    @minimumTenSongs
  Scenario: CheckCurrentSongs
    Given VersionFinalDelJuego
    When ComprueboCuantasCanciones
    Then HayAlMenosDiez