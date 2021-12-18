package WillHero;

import javafx.scene.image.ImageView;

public class Weapon extends GameComponents{
    private int level;
    private int damage;

    public Weapon(float x, float y, ImageView _image) {
        super(x, y,_image);
        this.damage = 0;
        this.level = 0;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
