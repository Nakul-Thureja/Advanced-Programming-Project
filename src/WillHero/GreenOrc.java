package WillHero;

import javafx.scene.image.ImageView;

public class GreenOrc extends Orc{

    public GreenOrc(float x,float y,int health, int coin_Value, int push_Value, int jump_Value, ImageView _image) {
        super(x,y,health, coin_Value, push_Value, jump_Value,_image);
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
