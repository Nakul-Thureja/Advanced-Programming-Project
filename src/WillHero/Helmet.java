package WillHero;

import java.util.ArrayList;

public class Helmet extends GameComponents{
    private ArrayList<Weapon> myWeapons;

    public Helmet(float x, float y, ArrayList<Weapon> WeaponList) {
        super(x, y);
        this.myWeapons = new ArrayList<>(WeaponList);
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
