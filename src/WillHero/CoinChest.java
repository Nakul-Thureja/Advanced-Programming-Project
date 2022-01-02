package WillHero;

import java.util.ArrayList;

import javafx.scene.image.ImageView;


public class CoinChest extends GameComponents implements Chest{
    private int coin_Value;
    private boolean isRewarded;
    private transient ImageView closed;
    private transient ImageView opened;
    
    public CoinChest(double x,double y,int coin_Value) {
        super(x, y);
        this.coin_Value = coin_Value;
        isRewarded = false;
    }
    public boolean isOpened() {
    	return this.isRewarded;
    }
    public void setImages(ImageView close, ImageView open) {
    	this.closed = close;
    	this.opened = open;
    }
    
    public ImageView getOpened() {
    	return this.opened;
    }
    @Override
    public void Reward() {
    	this.isRewarded = true;
        //Reward Return recheck
    }

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
