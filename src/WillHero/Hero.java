package WillHero;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

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
	private static int forward_Move = 93;
	private boolean onPlatform;
	private boolean hasSword;
	private boolean hasHammer;
	private transient TranslateTransition translate;
	private transient TranslateTransition w1translate;
	private transient TranslateTransition colltranslate;
	private transient TranslateTransition w2translate;

	private transient Timeline gravity;
	private transient Timeline collision;
	private transient TranslateTransition translatefwd;
	private transient TranslateTransition w1translatefwd;
	private transient TranslateTransition colltranslatefwd;
	private transient TranslateTransition w2translatefwd;
	private Weapon Sword;
	private Weapon Hammer;
	private transient ImageView hero;
	private transient ImageView weaponsword;
	private transient ImageView weaponhammer;
	private int currcoins;
	private boolean attacking;
	private boolean isDead;
	private transient ImageView selfcollider;

	

	public Hero(double x, double y, Helmet myHelmet) {
		super(x, y);
		this.myWeapon = null;
		this.Sword = null;
		this.Hammer = null;
		this.myHelmet = myHelmet;
		this.onPlatform = false;
		this.currcoins = 0;
		this.translate = new TranslateTransition();
		this.translatefwd = new TranslateTransition();
		this.w1translate = new TranslateTransition();
		this.w1translatefwd = new TranslateTransition();
		this.w2translate = new TranslateTransition();
		this.w2translatefwd = new TranslateTransition();
		this.colltranslate = new TranslateTransition();
		this.colltranslatefwd = new TranslateTransition();
		this.hasSword = false;
		this.hasHammer = false;
		this.gravity = new Timeline();
		this.attacking = false;
		this.isDead = false;
		
	}

	public void stopALL() {
		gravity.stop();
		translate.stop();
		translatefwd.stop();
		w1translate.stop();
		w2translatefwd.stop();
		colltranslate.stop();
		colltranslatefwd.stop();
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
		w1translate.pause();
		w2translate.pause();
		colltranslate.pause();

		image.setScaleX(1.05);
		image.setScaleY(0.9);
		translatefwd = new TranslateTransition();
		translatefwd.setDuration(Duration.millis(150));
		translatefwd.setCycleCount(1);
		translatefwd.setByX(forward_Move);
		translatefwd.setNode(image);
		colltranslatefwd = new TranslateTransition();
		colltranslatefwd.setDuration(Duration.millis(150));
		colltranslatefwd.setCycleCount(1);
		colltranslatefwd.setByX(forward_Move);
		colltranslatefwd.setNode(selfcollider);
		w1translatefwd = new TranslateTransition();
		w1translatefwd.setDuration(Duration.millis(150));
		w1translatefwd.setCycleCount(1);
		w1translatefwd.setByX(forward_Move);
		w1translatefwd.setNode(weaponsword);
		w2translatefwd = new TranslateTransition();
		w2translatefwd.setDuration(Duration.millis(150));
		w2translatefwd.setCycleCount(1);
		w2translatefwd.setByX(forward_Move);
		w2translatefwd.setNode(weaponhammer);
		translatefwd.play();
		w2translatefwd.play();
		w1translatefwd.play();
		colltranslatefwd.play();

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
		colltranslate = new TranslateTransition();
		colltranslate.setNode(selfcollider);
		colltranslate.setDuration(Duration.millis(450));
		colltranslate.setCycleCount(1);
		colltranslate.setByY(-jumping_Height);
		w1translate = new TranslateTransition();
		w1translate.setNode(weaponsword);
		w1translate.setDuration(Duration.millis(450));
		w1translate.setCycleCount(1);
		w1translate.setByY(-jumping_Height);
		
		w2translate = new TranslateTransition();
		w2translate.setNode(weaponhammer);
		w2translate.setDuration(Duration.millis(450));
		w2translate.setCycleCount(1);
		w2translate.setByY(-jumping_Height);
		
		colltranslate.play();
		translate.play();
		w1translate.play();
		w2translate.play();

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
	
	public void setCollider(ImageView image) {
		this.selfcollider = image;
	}
	public void heroAnimate() {
		gravity.play();
		translatefwd.pause();
		w1translatefwd.pause();
		w2translatefwd.pause();
		colltranslate.pause();
		colltranslatefwd.pause();
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
	public void giveWeapons(Weapon weapon1, Weapon weapon2) {
		this.Sword = weapon1;
		this.Hammer = weapon2;
	}
	public void giveWeaponImages(ImageView weapon1, ImageView weapon2) {
		weaponhammer = weapon2;
		weaponsword = weapon1;
	}
	public void collideLoop(GameComponents component, ImageView image) {
		if (component.getClass() == Coin.class) {
			if (this.checkCollision(image, hero)) {
				if (component.getVisibilty())
					this.currcoins++;
				component.setVisibilty(false);
				image.setVisible(false);
			}
		} else if (component.getClass() == GreenOrc.class) {
			if (this.checkCollision(image, hero)){//&& (Sword.getAttacking() || Hammer.getAttacking())) {
				// component.setVisibilty(false);
				
				if(this.onPlatform == false && !(Sword.getVisibilty() || Hammer.getVisibilty())) {
				this.onPlatform = true;
				}
				
					gravity.play();
					translatefwd.pause();
					w1translatefwd.pause();
					w2translatefwd.pause();
					colltranslate.pause();
					colltranslatefwd.pause();

					TranslateTransition translate2 = new TranslateTransition();
					translate2.setNode(image);
					translate2.setDuration(Duration.millis(100));
					translate2.setCycleCount(1);
					translate2.setByX(100);
					TranslateTransition translate3 = new TranslateTransition();
					translate3.setNode(((GreenOrc) component).getCollider());
					translate3.setDuration(Duration.millis(100));
					translate3.setCycleCount(1);
					translate3.setByX(100);
					translate2.play();
					translate3.play();

				
			}
		} else if (component.getClass() == RedOrc.class ) {
			if (this.checkCollision(image, hero) ){//&& (Sword.getAttacking() || Hammer.getAttacking())) {
				// component.setVisibilty(false);
				
				if(this.onPlatform == false && !(Sword.getVisibilty() || Hammer.getVisibilty())) {
					this.onPlatform = true;
					}
				//this.onPlatform = true;
				
					gravity.play();
					translatefwd.pause();
					w1translatefwd.pause();
					w2translatefwd.pause();
					colltranslate.pause();
					colltranslatefwd.pause();

					TranslateTransition translate2 = new TranslateTransition();
					translate2.setNode(image);
					translate2.setDuration(Duration.millis(100));
					translate2.setCycleCount(1);
					translate2.setByX(80);
					TranslateTransition translate3 = new TranslateTransition();
					translate3.setNode(((RedOrc) component).getCollider());
					translate3.setDuration(Duration.millis(100));
					translate3.setCycleCount(1);
					translate3.setByX(80);
					translate2.play();
					translate3.play();
				
			}
		} else if (component.getClass() == BossOrc.class) {
			if (this.checkCollision(image, hero) ){//&& (Sword.getAttacking() || Hammer.getAttacking())) {
				// component.setVisibilty(false);
				if(this.onPlatform == false && !(Sword.getVisibilty() || Hammer.getVisibilty())) {
					this.onPlatform = true;
					}
				
					gravity.play();
					translatefwd.pause();
					w1translatefwd.pause();
					w2translatefwd.pause();
					colltranslate.pause();
					colltranslatefwd.pause();

					TranslateTransition translate2 = new TranslateTransition();
					translate2.setNode(image);
					translate2.setDuration(Duration.millis(100));
					translate2.setCycleCount(1);
					translate2.setByX(80);
					TranslateTransition translate3 = new TranslateTransition();
					translate3.setNode(((BossOrc) component).getCollider());
					translate3.setDuration(Duration.millis(100));
					translate3.setCycleCount(1);
					translate3.setByX(80);
					translate2.play();
					translate3.play();
				
			}
		} else if (component.getClass() == Collider.class ) {
			
			if (this.checkCollision(image, selfcollider) && image.getTranslateY()<= hero.getTranslateY() && !(Sword.getAttacking() || Hammer.getAttacking())) {
				
				this.isDead = true;
			}
		}

		else if (component.getClass() == CoinChest.class) {
			if (this.checkCollision(image, hero) && !((CoinChest) component).isOpened()) {
				((CoinChest) component).Reward();
				image.setVisible(false);
				component.setVisibilty(false);
				((CoinChest) component).getOpened().setVisible(true);
				this.currcoins += 20;
			}
		} else if (component.getClass() == WeaponChest.class) {
			if (this.checkCollision(image, hero) && !((WeaponChest) component).isOpened()) {
				((WeaponChest) component).Reward();
				image.setVisible(false);
				component.setVisibilty(false);
				Random var = new Random();
				int choice = var.nextInt(10)%2;
				//System.out.println(choice);
				if(choice == 0) {
					Sword.setLevel(Sword.getLevel()+1);
					Sword.setVisibilty(true);
					weaponsword.setVisible(true);
					Hammer.setVisibilty(false);
					weaponhammer.setVisible(false);
				}
				else if(choice == 1) {
					Hammer.setLevel(Hammer.getLevel()+1);
					Hammer.setVisibilty(true);
					Sword.setVisibilty(false);
					weaponhammer.setVisible(true);
					weaponsword.setVisible(false);
				}
				else {
					Sword.setLevel(Sword.getLevel()+1);
					Sword.setVisibilty(true);
					weaponsword.setVisible(true);
					Hammer.setVisibilty(false);
					weaponhammer.setVisible(false);
				}
				((WeaponChest) component).getOpened().setVisible(true);

			}
		}
		
		else if(component.getClass() == fallingPlatform.class) {
			
			if(this.checkCollision(image, hero)) {
//				if(this.onPlatform == false) {
			
				this.onPlatform = true;
//				}
				((fallingPlatform)component).setImage(image);
				((fallingPlatform)component).beginGravity();
			}
		}
	}

	public void beginGravity(HashMap<GameComponents, ImageView> map) {
		//Thread thread = new Thread(() -> {
			
			translatefwd = new TranslateTransition();
			w1translatefwd = new TranslateTransition();
			w2translatefwd = new TranslateTransition();
			colltranslatefwd = new TranslateTransition();
			translate = new TranslateTransition();
			w1translate = new TranslateTransition();
			w2translate = new TranslateTransition();
			colltranslate = new TranslateTransition();
			collision = new Timeline();
			collision.setCycleCount(Animation.INDEFINITE);
			KeyFrame collision_frame = new KeyFrame(Duration.millis(100), e -> {
				map.forEach((key, value) -> collideLoop(key, value));
			});
			collision.getKeyFrames().add(collision_frame);
			collision.play();

			gravity = new Timeline();
			gravity.setCycleCount(Animation.INDEFINITE);
			KeyFrame gravity_frame = new KeyFrame(Duration.millis(18), e -> {
				map.forEach((key, value) -> gravityLoop(key, value));
				if(Sword.getAttacking() || Hammer.getAttacking()) {
					heroAnimate();
				}
				if (this.onPlatform == false) {
					hero.setLayoutY(hero.getLayoutY() + 4);
					weaponsword.setLayoutY(hero.getLayoutY() + 4);
					weaponhammer.setLayoutY(hero.getLayoutY() + 4);
					selfcollider.setLayoutY(hero.getLayoutY() + 4);

				} else {
					letsJump(hero, gravity);
				}
			});
			gravity.getKeyFrames().add(gravity_frame);
			gravity.play();
	//	});
		//thread.start();
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
