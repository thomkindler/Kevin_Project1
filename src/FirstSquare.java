public interface FirstSquare extends Square{
    @Override
    default void leave(Player player) {

    }

    @Override
    default Square moveAndLand(int numbSquares) {
        return null;
    }

    @Override
    default void enter(Player player) {

    }

    @Override
    default boolean isLastSquare() {
        return false;
    }

    @Override
    default Square landHereOrGoHome() {
        return null;
    }
}
