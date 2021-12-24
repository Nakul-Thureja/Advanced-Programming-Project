package WillHero;

import java.io.Serializable;

import javafx.scene.image.ImageView;

public abstract class GameComponents implements Serializable{
	private int visibilty;
	private Position position;
	
	public abstract int collision(ImageView collidingComp);
	
	public GameComponents(double x,double y) {
		this.setPosition(new Position(x,y));
		this.visibilty = 1;
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

	public void setPositionX(double x) {
		position.setX(x);
	}
	
	public double getPositionX() {
		return position.getX();
	}

	public void setPositionY(double y) {
		position.setY(y);
	}

	public double getPositionY() {
		return position.getY();
	}
}
