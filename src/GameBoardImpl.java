import java.util.LinkedList;
import java.util.Queue;

public class GameBoardImpl implements GameBoard {
    private Square[] mySquares;

    private int squareCount;
    private Queue<Player> players=null;

    GameBoardImpl() {
        this.squareCount=0;
        this.players = new LinkedList<>();
    }


    //create a Gameboard with nunb_rows rows and mumb_cols columns
    //add numb_players in bottom left field
    public GameBoard createGameBoard(int nunb_rows,int mumb_cols, int numb_players,String[] playerNames ) {
        this.squareCount = nunb_rows * mumb_cols;

        //counter is used to add fields
        int counter = 0;

        //initializes the board as an array of fields of size "fieldcount"
        this.mySquares = new Square[squareCount];

        //initialises a queue of players and add numb_players to stack
        Player player = null;
        for (int i=0; i<numb_players; i++)
            player = new PlayerImpl();
            this.players.add(player);

        return this;
    }

    //returns a specific field from the "fields" array
    public Square getfield(int number){
        return this.mySquares[number];
    }


    // print all fields of the GameBoard and list players should they be on a field
    // Also list ladder start fields and end fields as well as Snake start fields and end fields
    public void displayGameBoard() {

    }

    @Override
    public int getNumbSquaresToMove() {
        return 0;
    }

    @Override
    public boolean movePlayer(int numSquares) {
        return false;
    }


    @Override
    public Square findSquare(int NumbSquares) {
        return null;
    }

}
