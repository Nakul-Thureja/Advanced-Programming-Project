package WillHero;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Score{
    private int score;
    private static int HighScore = 0;
    private Text myText;

    public Score(float x, float y,int score, Text _text) {
    	this.myText = _text;
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
