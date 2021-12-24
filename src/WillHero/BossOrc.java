package WillHero;

import javafx.scene.image.ImageView;

public class BossOrc extends Orc{
    //init weapon
    public BossOrc(float x,float y,int health, int coin_Value, int push_Value, int jump_Value) {
        super(x,y,health, coin_Value, push_Value, jump_Value);
    }

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
