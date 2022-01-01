package WillHero;

import java.io.Serializable;
import javafx.scene.image.ImageView;

public abstract class GameComponents implements Serializable{
	private boolean visibilty;
	private Position position;
	
	public abstract int collision(ImageView collidingComp);
	
	public GameComponents(double x,double y) {
		this.setPosition(new Position(x,y));
		this.visibilty = true;
	}
		
	public boolean getVisibilty() {
		return visibilty;
	}

	public void setVisibilty(boolean _visibilty) {
		this.visibilty = _visibilty;
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
	
	public boolean checkCollision(ImageView platform, ImageView image) {
    	if (platform.getBoundsInParent().intersects(image.getBoundsInParent())){
    		return true;
    	}
    	else {
    		return false;
    	}
	}
}
