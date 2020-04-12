Feature: Juego

    @checkNumberOfPieces
    Scenario: incrementPieces
     Given Tablero class generates all the pieces
     When Juego class creates two more pieces
     Then Tablero and Juego should have the same number of pieces

    @checkNumberOfPoints
    Scenario: changePoints
     Given: MainActivity class generates Juego with 0 points
     When Juego changes player points
     Then Juego in MainActivity class should have 100 points