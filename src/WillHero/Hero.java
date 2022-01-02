package WillHero;

import java.io.Serializable;
import java.util.HashMap;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Hero extends GameComponents implements Serializable {
	private Helmet myHelmet;
	private Helmet myWeapon;
	private static int jumping_Height = 100;
	private static int forward_Move = 85;
	private boolean onPlatform;
	private transient TranslateTransition translate;
	private transient Timeline gravity;
	private transient Timeline collision;
	private transient TranslateTransition translatefwd;
	private transient ImageView hero;
	private int currcoins;
	private boolean attacking;
	private boolean isDead;
	
	public Hero(double x, double y, Helmet myHelmet) {
		super(x, y);
		this.myWeapon = null;
		this.myHelmet = myHelmet;
		this.onPlatform = false;
		this.currcoins = 0;
		this.translate = new TranslateTransition();
		this.translatefwd = new TranslateTransition();
		this.gravity = new Timeline();
		this.attacking= false;
		this.isDead = false;
	}

	public void stopALL() {
		gravity.stop();
		translate.stop();
		translatefwd.stop();
	}

	public void setMyWeapon(Helmet myWeapon) {
		this.myWeapon = myWeapon;
	}

	public void setFall(boolean boo) {
		this.onPlatform = boo;
	}
	public boolean status() {
		return this.isDead;
	}
	public void revive() {
		this.isDead = false;
	}
	public void moveForward(ImageView image) {
		attacking = true;
		gravity.pause();
		translate.pause();
		image.setScaleX(1.05);
		image.setScaleY(0.9);
		translatefwd = new TranslateTransition();
		translatefwd.setDuration(Duration.millis(150));
		translatefwd.setCycleCount(1);
		translatefwd.setByX(forward_Move);
		translatefwd.setNode(image);
		translatefwd.play();
		translatefwd.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				attacking = false;
				gravity.play();
			}
		});
		this.setPositionX(image.getTranslateX());
		this.setPositionY(image.getY());
	}

	public void letsJump(ImageView image, Timeline gravity) {
		gravity.pause();
		this.onPlatform = false;
		translate = new TranslateTransition();
		translate.setNode(image);
		translate.setDuration(Duration.millis(450));
		translate.setCycleCount(1);
		translate.setByY(-jumping_Height);
		translate.play();
		translate.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				gravity.play();
			}
		});
	}

	public void setImage(ImageView image) {
		this.hero = image;
	}

	public void gravityLoop(GameComponents component, ImageView image) {
		hero.setScaleX(1);
		hero.setScaleY(1);
		if (component.getClass() == Platform.class) {
			if (this.onPlatform == false) {
				this.onPlatform = this.checkCollision(image, hero);
			}
		}
	}

	public void collideLoop(GameComponents component, ImageView image) {
		if (component.getClass() == Coin.class) {
			if (this.checkCollision(image, hero)) {
				if (component.getVisibilty())
					this.currcoins++;
				component.setVisibilty(false);
				image.setVisible(false);
			}
		}
		else if (component.getClass() == GreenOrc.class) {
			if(this.checkCollision(image, hero) && attacking) {
				//component.setVisibilty(false);
				gravity.play();
				translatefwd.pause();
				TranslateTransition translate2 = new TranslateTransition();
				translate2.setNode(image);
				translate2.setDuration(Duration.millis(100));
				translate2.setCycleCount(1);
				translate2.setByX(100);
				translate2.play();
			}
		}
		else if (component.getClass() == RedOrc.class) {
			if(this.checkCollision(image, hero) && attacking) {
				//component.setVisibilty(false);
				gravity.play();
				translatefwd.pause();
				TranslateTransition translate2 = new TranslateTransition();
				translate2.setNode(image);
				translate2.setDuration(Duration.millis(100));
				translate2.setCycleCount(1);
				translate2.setByX(80);
				translate2.play();
			}
		}
		else if (component.getClass() == Collider.class) {
			if(this.checkCollision(image, hero)) {
				this.isDead = true;
			}
		}
		
		else if (component.getClass() == CoinChest.class) {
			
		}
		else if (component.getClass() == WeaponChest.class) {
			
		}
	}

	public void beginGravity(HashMap<GameComponents, ImageView> map) {
		translatefwd = new TranslateTransition();
		translate = new TranslateTransition();
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
				hero.setLayoutY(hero.getLayoutY() + 4);
			} else {
				letsJump(hero, gravity);
			}
		});
		gravity.getKeyFrames().add(gravity_frame);
		gravity.play();
	}

	public void setcurrCoins(int total) {
		this.currcoins = total;
	}
	public int getcurrCoins() {
		return this.currcoins;
	}

	@Override
	public int collision(ImageView collidingComp) {
		return 0;
	}

	public double getForwardValue() {
		return forward_Move;
	}

}
