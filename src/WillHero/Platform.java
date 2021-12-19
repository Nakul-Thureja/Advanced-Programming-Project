package WillHero;

import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

public class Platform extends GameComponents{
    private int size;
    //private ArrayList<ImageView> colliders;
    
    public Platform(float x, float y,int size, ImageView _image) {
        super(x, y,_image);
        this.size = size;
    }
    
//    public void giveCollider(ArrayList<ImageView> _colliders) {
//    	this.colliders = _colliders;
//    }
    public void checkCollision(Hero hero) {
    	if (this.getImage().getBoundsInParent().intersects(hero.getImage().getBoundsInParent())){
    		hero.setFall(true);
    	}
}
    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
