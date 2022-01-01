package WillHero;

import javafx.scene.image.ImageView;

public class Collider extends GameComponents{

	public Collider(double x, double y) {
		super(x, y);
	}

	@Override
	public int collision(ImageView collidingComp) {
		return 0;
	}
	
	
}
