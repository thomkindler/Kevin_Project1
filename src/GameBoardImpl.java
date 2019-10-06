

public class GameBoardImpl implements GameBoard {
    private int squareCount;
    private Square[] mySquares;
    private Players myPlayers;
    private Player currentPlayer;
    private int numSquares;
    private Square lastSquare;

    GameBoardImpl() {
        this.squareCount=0;
        this.myPlayers=new PlayersImpl();
    }


    //create a Gameboard with nunb_rows rows and mumb_cols columns
    //add numb_players in bottom left field
    public GameBoard createGameBoard(int nunb_rows,int mumb_cols, int numb_players,String[] playerNames ) {
        this.squareCount = nunb_rows * mumb_cols;

        //counter is used to add fields
        int counter = 0;

        //initializes the board as an array of fields of size "fieldcount"
        this.mySquares = new Square[squareCount];
        mySquares[0]=new FirstSquareImpl(1, this);
        Square square;
        for (int i=1; i<(squareCount-1); i++) {
            square = new SquareImpl(i+1, this);
            mySquares[i]=square;
        }
        mySquares[(squareCount-1)]=new LastSquareImpl(squareCount, this);
        this.lastSquare=mySquares[(squareCount-1)];
        mySquares[1]=new LadderImpl(2,6, this);
        mySquares[6]=new LadderImpl(7,9, this);
        mySquares[10]=new SnakeImpl(11,5, this);


        //initialises a queue of players and add numb_players to stack
        Player player;
        for (int i=0; i<numb_players; i++) {
            player = new PlayerImpl(playerNames[i], this.mySquares[0]);
            this.myPlayers.add(player);

            //add Player to first Square
            this.mySquares[0].enter(player);

        }
        return this;
    }

    //returns a specific field from the "fields" array
    public Square getfield(int number){
        return this.mySquares[number];
    }


    // print all fields of the GameBoard and list players should they be on a field
    // Also list ladder start fields and end fields as well as Snake start fields and end fields
    @Override
    public String displayGameBoard(int stage) {
        String out="";
        switch(stage) {
            case 0:
                out = "Initial State: ";
                for (int i = 0; i < this.squareCount; i++) {
                    out = out.concat(this.mySquares[i].statusSquare());
                }
                break;
            case 1:
                out = String.format("%s rolls %d:", this.currentPlayer.getName(), this.numSquares);
                for (int i = 0; i < this.squareCount; i++) {
                    out = out.concat(this.mySquares[i].statusSquare());
                }
            break;
            case 2:
                out = "Final State: ";
                for (int i = 0; i < this.squareCount; i++) {
                    out = out.concat(this.mySquares[i].statusSquare());
                }
            break;
            case 3:
                out = String.format("%s wins!",this.currentPlayer.getName());
            break;
        }
        return(out);
    }

    @Override
    public int getNumbSquaresToMove() {
        return 0;
    }

    @Override
    public boolean movePlayer(int numSquares) {


        this.numSquares=numSquares;
        this.currentPlayer=this.myPlayers.remove();
        this.currentPlayer.moveFwd(this.numSquares);
        this.myPlayers.add(this.currentPlayer);
        Square curentSquare=this.currentPlayer.square();
        return curentSquare.isLastSquare();
    }


    @Override
    public Square findSquare(int ID, int NumbSquares) {
        int newID=ID+NumbSquares-1;
        if (newID>=this.squareCount) newID=this.squareCount-1;
        Square newSquare= this.mySquares[newID];
        if (newSquare instanceof Ladder) {
            newSquare= this.mySquares[((Ladder) newSquare).getJumpDestID()-1];
        }
        else {
            if (newSquare instanceof Snake) {
                newSquare= this.mySquares[((Snake) newSquare).getJumpDestID()-1];
            }
        }
        return newSquare;
    }

}
