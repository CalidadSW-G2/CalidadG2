Feature: Juego

    @checkNumberOfIncrementedPieces
    Scenario: incrementPieces
     Given Tablero class generates all the pieces
     When Juego class creates two more pieces
     Then Tablero and Juego should have the same number of pieces

    @checkNumberOfDecrementedPieces
    Scenario: decrementPieces
     Given Tablero class generates all the pieces
     When Juego class removes a piece
     Then Tablero and Juego should have the same number of pieces

    @checkDeletedPiece
    Scenario: deleteSpecificPiece
     Given Tablero generates a new piece
     When Tablero deletes the new created piece
     Then Juego should not have that piece

    @checkNumberOfPoints
    Scenario: changePoints
     Given MainActivity class generates Juego
     When Juego changes player points
     Then Juego in MainActivity class should have 100 points

    @checkGamemode
    Scenario: setGamemode
     Given MainActivity class generates Juego
     Then MainActivity and Juego gamemode should be the same