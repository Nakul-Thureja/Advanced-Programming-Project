package WillHero;

import javafx.scene.image.ImageView;

public class GreenOrc extends Orc{

    public GreenOrc(double x,double y,int health, int coin_Value, int push_Value, int jump_Value) {
        super(x,y,health, coin_Value, push_Value, jump_Value);
    }

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
