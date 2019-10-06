import java.util.Scanner;

public class SnakeLadderGame {

    static private GameBoard gameBoard;
    static private Die die;

    private static int numbPlayers=0;


    public static void main(String[] args) {
        // write your code here

        boolean finished = false;
        boolean won = false;


        Scanner in;
        System.out.println("Please select number of users:");
        in = new Scanner(System.in);
        numbPlayers = in.nextInt();

        String[] names = new String[numbPlayers];

        for (int i = 0; i < numbPlayers; i++) {
            String output = String.format("Please select name of user %d:", i);
            System.out.println(output);
            names[i] = in.next();
        }

        gameBoard = new GameBoardImpl().createGameBoard(3, 4, numbPlayers, names);
        die = new DieImpl();

        String output="";
        output=gameBoard.displayGameBoard(0);
        System.out.println(output);
        int numbSquares;
        while (!gameBoard.movePlayer(numbSquares=die.throw_dice())) {
            output=gameBoard.displayGameBoard(1);
            System.out.println(output);
        }

        output=gameBoard.displayGameBoard(2);
        System.out.println(output);

        output = gameBoard.displayGameBoard(3);
        System.out.println(output);

        System.out.println("Good bye, hope to see you soon again!");

    }

}
