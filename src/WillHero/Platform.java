package WillHero;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class Platform extends GameComponents{
    private int size;
    
    public Platform(double x,double y,int size) {
        super(x, y);
        this.size = size;
    }
    
    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
