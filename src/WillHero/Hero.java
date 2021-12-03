package WillHero;

public class Hero extends GameComponents{
    private Helmet myHelmet;
    private Helmet myWeapon;
    private static int jumping_Height = 60;
    private static int forward_Move = 60;

    public Hero(float x, float y,Helmet myHelmet) {
        super(x, y);
        this.myWeapon = null;
        this.myHelmet = myHelmet;
    }

    public void setMyWeapon(Helmet myWeapon) {
        this.myWeapon = myWeapon;
    }

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
