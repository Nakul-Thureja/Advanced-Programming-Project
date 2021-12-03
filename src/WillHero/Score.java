package WillHero;

public class Score extends GameComponents{
    private int score;
    private static int HighScore = 0;

    public Score(float x, float y,int score) {
        super(x, y);
        this.score = score;
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
