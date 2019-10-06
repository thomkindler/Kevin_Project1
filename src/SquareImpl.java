public class SquareImpl implements Square {
    //What actions is this object responsible for?: keeps track of any player on it
    //What information does this object share?: ID of Players sitting on field, ladder starts,
    // ladder ends, snake starts, snake ends sitting on the square

    private int ID;
    private Player myPlayer=null;
    private GameBoard myGameBoard=null;

    SquareImpl(int ID,GameBoard gameBoard) {
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
        return false;
    }

    @Override
    public Square landHereOrGoHome() {
        if (this.myPlayer== null) {
            return (this);
        }
        else {
            return(this.myGameBoard.findSquare(1,0));
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
