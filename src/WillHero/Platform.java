package WillHero;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class Platform extends GameComponents{
    private int size;
    //private ArrayList<ImageView> colliders;
    
    public Platform(float x, float y,int size) {
        super(x, y);
        this.size = size;
    }
    
//    public void giveCollider(ArrayList<ImageView> _colliders) {
//    	this.colliders = _colliders;
//    }
    public boolean checkCollision(ImageView platform, ImageView image) {
    	if (platform.getBoundsInParent().intersects(image.getBoundsInParent())){
    		return true;
    	}
    	else {
    		return false;
    	}
}
    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
