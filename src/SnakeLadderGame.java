import java.util.Scanner;

public class SnakeLadderGame {

    static GameBoard gameBoard;
    static Die die;

    static int numbPlayers=0;


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

        gameBoard = new GameBoardImpl().createGameBoard(4, 6, numbPlayers, names);
        die = new DieImpl();

        String output="";
        output = String.format("Initial State: ");
        System.out.println(output);
        int numbSquares;
        while (!gameBoard.movePlayer(numbSquares=die.throw_dice())) {
            output = String.format("%s rolls %d:", "yy",numbSquares);
            System.out.println(output);
        }

        output = String.format("Final State: ");
        System.out.println(output);

        output = String.format("%s wins!","xxx");
        System.out.println(output);

        System.out.println("Good bye, hope to see you soon again!");

    }

}
