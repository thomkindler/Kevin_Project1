public class SquareImpl implements Square {
    //What actions is this object responsible for?: keeps track of any player on it
    //What information does this object share?: ID of Players sitting on field, ladder starts,
    // ladder ends, snake starts, snake ends sitting on the square

    @Override
    public void leave(Player player) {

    }

    @Override
    public Square moveAndLand(int numbSquares) {
        return null;
    }

    @Override
    public void enter(Player player) {

    }

    @Override
    public boolean isLastSquare() {
        return false;
    }

    @Override
    public Square landHereOrGoHome() {
        return null;
    }
}
