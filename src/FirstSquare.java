public interface FirstSquare extends Square{

    void leave(Player player);

    Square moveAndLand(int numbSquares);

    void enter(Player player);

    boolean isLastSquare();

    Square landHereOrGoHome();

}
