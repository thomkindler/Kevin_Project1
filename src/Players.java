public interface Players {
    /*
    What actions is this object responsible for?:
                  - keeps track of Players with in a stack
    What information does this object share?: stack of Players playing the game
    */

    // returns top-Player (next Player in line to play) and deletes Player on stack
    Player remove();

    //adds Player done with current round of playing to bottom of stack
    void add(Player player);
}



