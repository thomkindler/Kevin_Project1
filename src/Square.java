public interface Square {
    //What actions is this object responsible for?: keeps track of any player on it
    //What information does this object share?: List of Players, ladder starts,
    // ladder ends, snake starts, snake ends sitting on the square

    //deletes Player from current Square
    void leave(Player player);

    //moves the Player by numbSquare and places it on the new Square which is returned
    Square moveAndLand(int numbSquares);

    //adds Player on to current Square
    void enter(Player player);

    //checks if this is last Square returns false or true
    boolean isLastSquare();

    //checks if Square is occupied already than it returns first square otherwise it returns current Square
    Square landHereOrGoHome();
}