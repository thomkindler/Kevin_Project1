public class LadderImpl implements Ladder {
    int startID=0, endID=0;
    private GameBoard myGameBoard=null;
    private Player myPlayer=null;


    LadderImpl(int startID, int endID, GameBoard gameBoard) {
        this.startID=startID;
        this.endID=endID;
        this.myGameBoard=gameBoard;
    }


    @Override
    public void leave(Player player) {
        this.myPlayer=null;
    }


    @Override
    public Square moveAndLand(int numbSquares) {
        Square newSquare = myGameBoard.findSquare(this.startID, numbSquares);
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
            return(this);
        }
    }

    @Override
    public String statusSquare() {
        String out= String.format("[%d->%d]", this.startID, this.endID);
        return out;
    }

    @Override
    public int getJumpDestID() {
        return this.endID;
    }
}
