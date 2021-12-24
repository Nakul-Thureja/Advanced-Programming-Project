package WillHero;

import java.io.Serializable;

public class Position implements Serializable{
	private double x,y;
	public Position(double x,double y){
		this.setX(x);
		this.setY(y);
	}
	public double getX() {
		return this.x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return this.y;
	}
	public void setY(double y) {
		this.y = y;
	} 
}
