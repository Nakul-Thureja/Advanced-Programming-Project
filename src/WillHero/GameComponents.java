package WillHero;

import javafx.scene.image.ImageView;

public abstract class GameComponents {
	private int visibilty;
	private Position position;
	private ImageView myImage;
	
	public abstract int collision(GameComponents collidingComp);
	
	public GameComponents(float x,float y,ImageView _image) {
		this.setPosition(new Position(x,y));
		this.visibilty = 1;
		this.myImage = _image;
	}
		
	public ImageView getImage() {
		return this.myImage;
	}
	public int getVisibilty() {
		return visibilty;
	}

	public void setVisibilty(int visibilty) {
		this.visibilty = visibilty;
	}


	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setPositionX(float x) {
		position.setX(x);
	}
	
	public float getPositionX() {
		return position.getX();
	}

	public void setPositionY(float y) {
		position.setY(y);
	}

	public float getPositionY() {
		return position.getY();
	}
}
