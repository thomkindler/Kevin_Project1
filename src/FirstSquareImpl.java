import java.util.*;

public class FirstSquareImpl implements FirstSquare {

    private Map<String, Player> myPlayers = new HashMap<String, Player>();

    private int ID;
    private GameBoard myGameBoard=null;

    FirstSquareImpl(int ID, GameBoard gameBoard) {
        this.ID=ID;
        this.myGameBoard=gameBoard;
    }

    @Override
    public String statusSquare() {
        int i = 0;
        String out= String.format("[%d", this.ID);

        for (Map.Entry<String, Player> entry : myPlayers.entrySet()) {
            out=out.concat(String.format("<%s>", entry.getValue().getName()));
        }
        out=out.concat("]");
        return out;
    }

    @Override
    public void enter(Player player) {
        this.myPlayers.put(player.getName(),player ) ;
    }

    @Override
    public void leave(Player player) {
        if (this.myPlayers.containsKey(player.getName())) {
            this.myPlayers.remove(player.getName());
        }
    }

    @Override
    public Square moveAndLand(int numbSquares) {
        Square newSquare = myGameBoard.findSquare(this.ID, numbSquares);
        newSquare = newSquare.landHereOrGoHome();
        return newSquare;
    }


    @Override
    public boolean isLastSquare() {
        return false;
    }

    @Override
    public Square landHereOrGoHome() {
            return(this);
    }
}
