package WillHero;

import java.util.ArrayList;

public class CoinChest extends GameComponents implements Chest{
    private int coin_Value;
    public CoinChest(float x, float y,int coin_Value) {
        super(x, y);
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
