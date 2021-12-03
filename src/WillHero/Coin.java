package WillHero;

public class Coin extends GameComponents {

    public Coin(float x, float y) {
        super(x, y);
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
