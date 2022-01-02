package WillHero;

import javafx.scene.image.ImageView;

public class WeaponChest extends GameComponents implements Chest{
    private Weapon rewardWeapon;
    private boolean isRewarded;
    private transient ImageView closed;
    private transient ImageView opened;

    public WeaponChest(double x,double y,Weapon myWeapon) {
        super(x, y);
        this.rewardWeapon = myWeapon;
        this.isRewarded = false;
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
    }

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
