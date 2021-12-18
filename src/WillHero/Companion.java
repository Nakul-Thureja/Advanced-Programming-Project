package WillHero;

import javafx.scene.image.ImageView;

public class Companion extends GameComponents{

	public Companion(float x, float y, ImageView _image) {
		super(x, y, _image);
	}

	@Override
	public int collision(GameComponents collidingComp) {
		
		return 0;
	}

}
