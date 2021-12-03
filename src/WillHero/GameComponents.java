package WillHero;

public class GameComponents {
	private int visibilty;
	private Position position;
	
	public GameComponents(float x,float y) {
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
