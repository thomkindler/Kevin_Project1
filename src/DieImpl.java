public class DieImpl implements Die {

    @Override
    public int throw_dice() {
        int i = (int) (Math.random() * 6 + 1);
        return i;
    }
}
