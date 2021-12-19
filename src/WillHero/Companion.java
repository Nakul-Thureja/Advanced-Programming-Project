package WillHero;


public class Companion extends GameComponents{

	public Companion(float x, float y) {
        super(x, y);
	}

	@Override
	public int collision(GameComponents collidingComp) {
		
		return 0;
	}

}
