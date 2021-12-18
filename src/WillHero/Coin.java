package WillHero;

import javafx.scene.image.ImageView;

public class Coin extends GameComponents {

    public Coin(float x, float y, ImageView _image) {
        super(x, y,_image);
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
