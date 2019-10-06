public class PlayerImpl implements Player {
    private String name;
    private Square mySquare;

    public PlayerImpl(String name, Square mySquare) {
        this.name=name;
        this.mySquare=mySquare;
    }

    @Override
    public void moveFwd(int numbSquares) {
        mySquare.leave(this);
        this.mySquare=mySquare.moveAndLand(numbSquares);
        this.mySquare.enter(this);
    }

    @Override
    public Square square() {
        return this.mySquare;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
