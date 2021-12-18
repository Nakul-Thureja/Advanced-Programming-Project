package WillHero;

import javafx.scene.image.ImageView;

public class fallingPlatform extends Platform{
    private int falling_Time;

    public fallingPlatform(float x, float y, int size,int fallingtime, ImageView _image) {
        super(x, y, size,_image);
        this.falling_Time = fallingtime;
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
