package WillHero;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Orc extends GameComponents {
	private int health;
	private int coin_Value;
	private int push_Value;
	private int jump_Value;
	private double colliderX;
	private boolean onPlatform;
	private transient TranslateTransition translate;
	private transient TranslateTransition translate2;

	private transient Timeline gravity;
	private transient Timeline collision;
	// private transient TranslateTransition translatefwd;
	private transient ImageView Orc;
	private transient ImageView mycollider;

	public Orc(double x, double y, int health, int coin_Value, int push_Value, int jump_Value) {
		super(x, y);
		this.health = health;
		this.coin_Value = coin_Value;
		this.push_Value = push_Value;
		this.jump_Value = jump_Value;
		this.onPlatform = false;
		this.colliderX = 0;
	
	}

	public void stopALL() {
		if(gravity!=null)
			gravity.stop();
		if(translate!=null)
			translate.stop();
		if(translate2!=null)
			translate2.stop();
		// translatefwd.stop();
	}

	public int getCoinValue() {
		return this.coin_Value;
	}

	public double getColliderX() {
		return this.colliderX;
	}

	public void beginGravity(HashMap<GameComponents, ImageView> map) {
		//Thread thread = new Thread(() -> {
			mycollider.translateXProperty().addListener((obs, old, newValue) -> {

				int offset = newValue.intValue();
				// mycollider.setTranslateX(offset);
				this.colliderX = offset;
			});
			Orc.translateXProperty().addListener((obs, old, newValue) -> {
				int offset = newValue.intValue();
				// mycollider.setTranslateX(offset);
				// this.colliderX = offset;
				this.setPositionX(offset);
			});
			Orc.translateYProperty().addListener((obs, old, newValue) -> {
				int offset = newValue.intValue();
				this.setPositionY(offset);
			});
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
					mycollider.setLayoutY(mycollider.getLayoutY() + 4);
				} else {
					letsJump(Orc, gravity, mycollider);
				}
			});
			gravity.getKeyFrames().add(gravity_frame);
			gravity.play();
		//});
	//	thread.start();
	}

	public void letsJump(ImageView image, Timeline gravity, ImageView collide) {
		gravity.pause();
		this.onPlatform = false;
		translate = new TranslateTransition();
		translate.setNode(image);
		translate.setDuration(Duration.millis(500));
		translate.setCycleCount(1);
		translate.setByY(-this.jump_Value);
		translate.play();
		translate2 = new TranslateTransition();
		translate2.setNode(collide);
		translate2.setDuration(Duration.millis(500));
		translate2.setCycleCount(1);
		translate2.setByY(-this.jump_Value);
		translate2.play();
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

	public void setCollider(ImageView coll) {
		this.mycollider = coll;
	}

	public ImageView getCollider() {
		return this.mycollider;
	}

}
