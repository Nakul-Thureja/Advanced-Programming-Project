package WillHero;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class Helmet extends GameComponents{
    private ArrayList<Weapon> myWeapons;

    public Helmet(float x, float y, ArrayList<Weapon> WeaponList, ImageView _image) {
        super(x, y,_image);
        this.myWeapons = new ArrayList<>(WeaponList);
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
