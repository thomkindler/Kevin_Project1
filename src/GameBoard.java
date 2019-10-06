public interface GameBoard {
    //What actions is this object responsible for?•: keeps track of the game state
    //What information does this object share? : List of Squares belonging to the Gameboard




    //create a Gameboard with nunb_rows rows and mumb_cols columns
    //add numb_players in bottom left field
    GameBoard createGameBoard(int nunb_rows,int mumb_cols, int numb_players, String[] names);

    // print all squares of the GameBoard and list players should they be on a square
    // Also list ladder start fields and end fields as well as Snake start fields and end fields
    String displayGameBoard(int stage);

    //get random number of Squares to move in next move
    int getNumbSquaresToMove();

    // do next move with player in players stack. Return "true" if last Square is reached and game is over, false otherwise
    boolean movePlayer(int numSquares);

    //finds Square numbSquare ahead, taking in to account ladder and snakes
    Square findSquare(int ID, int NumbSquares);
}
