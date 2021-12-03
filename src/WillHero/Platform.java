package WillHero;

public class Platform extends GameComponents{
    private int size;
    public Platform(float x, float y,int size) {
        super(x, y);
        this.size = size;
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
