package WillHero;

public class fallingPlatform extends Platform{
    private int falling_Time;

    public fallingPlatform(float x, float y, int size,int fallingtime) {
        super(x, y, size);
        this.falling_Time = fallingtime;
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}