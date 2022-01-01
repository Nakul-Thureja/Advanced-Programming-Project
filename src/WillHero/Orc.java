package WillHero;

import java.util.HashMap;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Orc extends GameComponents{
	private int health;
	private int coin_Value;
	private int push_Value;
	private int jump_Value;
	private boolean onPlatform;
	private transient TranslateTransition translate;
	private transient Timeline gravity;
	private transient Timeline collision;
	private transient TranslateTransition translatefwd;
	private transient ImageView Orc;
	
	public Orc(double x,double y,int health,int coin_Value,int push_Value,int jump_Value) {
		super(x,y);
		this.health = health;
		this.coin_Value = coin_Value;
		this.push_Value = push_Value;
		this.jump_Value = jump_Value;
		this.onPlatform = false;
	}
	
	public int getCoinValue() {
		return this.coin_Value;
	}
	
	public void beginGravity(HashMap<GameComponents, ImageView> map) {
		collision = new Timeline();
		collision.setCycleCount(Animation.INDEFINITE);
		KeyFrame collision_frame = new KeyFrame(Duration.millis(18), e -> {
			map.forEach((key, value) -> collideLoop(key, value));
		});
		collision.getKeyFrames().add(collision_frame);
		collision.play();

		gravity = new Timeline();
		gravity.setCycleCount(Animation.INDEFINITE);
		KeyFrame gravity_frame = new KeyFrame(Duration.millis(18), e -> {
			map.forEach((key, value) -> gravityLoop(key, value));
			if (this.onPlatform == false) {
				Orc.setLayoutY(Orc.getLayoutY() + 4);
			} else {
				letsJump(Orc, gravity);
			}
		});
		gravity.getKeyFrames().add(gravity_frame);
		gravity.play();
	}
	
	public void letsJump(ImageView image, Timeline gravity) {
		gravity.pause();
		this.onPlatform = false;
		translate = new TranslateTransition();
		translate.setNode(image);
		translate.setDuration(Duration.millis(450));
		translate.setCycleCount(1);
		translate.setByY(-this.jump_Value);
		translate.play();
		translate.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				gravity.play();
			}
		});
	}
	
	public abstract void collideLoop(GameComponents key, ImageView value);
	public void gravityLoop(GameComponents component, ImageView image) {
		if (component.getClass() == Platform.class) {
			if (this.onPlatform == false) {
				this.onPlatform = this.checkCollision(image, Orc);
			}
		}
	}
	public void setImage(ImageView imageView) {
		this.Orc = imageView;
	}
}
