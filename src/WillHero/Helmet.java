package WillHero;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class Helmet extends GameComponents{
    private ArrayList<Weapon> myWeapons;

    public Helmet(double x,double y, ArrayList<Weapon> WeaponList) {
        super(x, y);
        this.myWeapons = new ArrayList<>(WeaponList);
    }

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
