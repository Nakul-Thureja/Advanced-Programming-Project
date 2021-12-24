package WillHero;

import java.io.Serializable;

public class Score implements Serializable{
    private int score;
    private static int HighScore = 0;

    public Score(float x, float y,int score) {
        this.score = score;
    }
    
    public void scoreplus1() {
    	this.score++;
    }
    
    public int getScore() {
    	return this.score;
    }

        
    @Override
    public String toString() {
    	return Integer.toString(score);
    }
}
