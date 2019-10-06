public interface LastSquare extends Square{

    @Override
    default boolean isLastSquare() {
        return false;
    }

}
