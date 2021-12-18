package WillHero;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class CoinChest extends GameComponents implements Chest{
    private int coin_Value;
    public CoinChest(float x, float y,int coin_Value, ImageView _image) {
        super(x, y,_image);
        this.coin_Value = coin_Value;
    }

    @Override
    public Object Reward() {
        //Reward Return recheck
        return new Coin[coin_Value];
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
