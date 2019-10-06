import java.util.LinkedList;
import java.util.Queue;

public class PlayersImpl implements Players {

    private Queue<Player> myPlayers=null;


    PlayersImpl() {
        this.myPlayers = new LinkedList<>();
    }

    @Override
    public Player remove() {
        return(myPlayers.remove());
    }

    @Override
    public void add(Player player) {
        this.myPlayers.add(player);
    }

}
