public class LastSquareImpl implements LastSquare {

    private int ID;
    private Player myPlayer;
    private GameBoard myGameBoard=null;


    LastSquareImpl(int ID, GameBoard gameBoard) {
        this.ID=ID;
        this.myGameBoard=gameBoard;
    }

    @Override
    public void leave(Player player) {
        this.myPlayer=null;
    }

    @Override
    public Square moveAndLand(int numbSquares) {
        Square newSquare = myGameBoard.findSquare(this.ID, numbSquares);
        newSquare = newSquare.landHereOrGoHome();
        return newSquare;

    }

    @Override
    public void enter(Player player) {
        this.myPlayer=player;
    }

    @Override
    public boolean isLastSquare() {
        return true;
    }

    @Override
    public Square landHereOrGoHome() {
        if (this.myPlayer== null) {
            return (this);
        }
        else {
            return(this);
        }
    }

    @Override
    public String statusSquare() {
        String out= String.format("[%d", this.ID);
        if (this.myPlayer!=null) {
            out=out.concat(String.format("<%s>", this.myPlayer.getName()));
        }
        out=out.concat("]");
        return out;
    }

}
