package WillHero;

public class GreenOrc extends Orc{

    public GreenOrc(float x,float y,int health, int coin_Value, int push_Value, int jump_Value) {
        super(x,y,health, coin_Value, push_Value, jump_Value);
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
