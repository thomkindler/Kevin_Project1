public interface Player {
    //What actions is this object responsible for?:
    //              - keeps track of where it is
    //              - moves over squares of the board
    //What information does this object share?: Square ID it sits on

    //move current Player forward numbSquares
    void moveFwd(int numbSquares);

    //returns the current Square the Player sits on
    Square square();

    //returns the name of the Player
    String getName();
}
