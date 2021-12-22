package WillHero;

import javafx.scene.image.ImageView;

public class Coin extends GameComponents {

    public Coin(float x, float y) {
        super(x, y);
    }

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
