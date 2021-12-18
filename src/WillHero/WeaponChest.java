package WillHero;

import javafx.scene.image.ImageView;

public class WeaponChest extends GameComponents implements Chest{
    private Weapon rewardWeapon;

    public WeaponChest(float x, float y,Weapon myWeapon, ImageView _image) {
        super(x, y,_image);
        this.rewardWeapon = myWeapon;
    }

    @Override
    public Object Reward() {
        return rewardWeapon;
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
