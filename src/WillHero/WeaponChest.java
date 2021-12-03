package WillHero;

public class WeaponChest extends GameComponents implements Chest{
    private Weapon rewardWeapon;

    public WeaponChest(float x, float y,Weapon myWeapon) {
        super(x, y);
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