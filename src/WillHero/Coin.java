package WillHero;

import javafx.scene.image.ImageView;

public class Coin extends GameComponents {

    public Coin(double x,double y) {
        super(x, y);
    }

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
