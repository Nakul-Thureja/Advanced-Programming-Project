package WillHero;

import javafx.scene.image.ImageView;

public class Companion extends GameComponents{

	public Companion(double x,double y) {
        super(x, y);
	}

	@Override
	public int collision(ImageView collidingComp) {
		
		return 0;
	}

}
