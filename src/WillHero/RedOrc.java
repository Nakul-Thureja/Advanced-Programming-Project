package WillHero;

import javafx.scene.image.ImageView;

public class RedOrc extends Orc {
	private boolean isSleeping;
	
	public RedOrc(double x,double y,int health, int coin_Value, int push_Value, int jump_Value) {
		super(x,y,health, coin_Value, push_Value, jump_Value);
		this.setSleeping(true);
	}

	public boolean getSleeping() {
		return this.isSleeping;
	}

	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}

	@Override
	public int collision(ImageView collidingComp) {
		return 0;
	}
}
