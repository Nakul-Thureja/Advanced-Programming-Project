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

public class Hero extends GameComponents implements Serializable{
	private Helmet myHelmet;
    private Helmet myWeapon;
    private static int jumping_Height = 100;
    private static int forward_Move = 80;
    private boolean onPlatform;
    private transient TranslateTransition translate;
    private transient Timeline gravity;
    private transient Timeline collision;
    private transient TranslateTransition translatefwd;
    private transient ImageView hero;
    private int currcoins;
    public Hero(double x,double y,Helmet myHelmet) {
        super(x, y);
        this.myWeapon = null;
        this.myHelmet = myHelmet;
        this.onPlatform = false;
        this.currcoins = 0;
        translate = new TranslateTransition();
        translatefwd = new TranslateTransition();
        gravity = new Timeline();
       
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
    
    public void moveForward(ImageView image) {
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
    
    public void gravityLoop(GameComponents component,ImageView image) {
			hero.setScaleX(1);
			hero.setScaleY(1);
			if (component.getClass() == Platform.class){
				if(this.onPlatform == false) {
					this.onPlatform = this.checkCollision(image,hero);
				}
			}
	}
    
    public void collideLoop(GameComponents component,ImageView image) {
    	if(component.getClass() == Coin.class) {
			if(this.checkCollision(image,hero)) {
				if(component.getVisibilty())
					this.currcoins++;	
				component.setVisibilty(false);
				image.setVisible(false);
			}		
		}
	}
 
    public void beginGravity(HashMap<GameComponents, ImageView> map) {
		collision = new Timeline();
		collision.setCycleCount(Animation.INDEFINITE);
		KeyFrame collision_frame = new KeyFrame(Duration.millis(18), e->{
    		map.forEach((key, value)-> collideLoop(key,value));
    	});
		collision.getKeyFrames().add(collision_frame);
		collision.play();
		
    	gravity = new Timeline();
    	gravity.setCycleCount(Animation.INDEFINITE);
    	KeyFrame gravity_frame = new KeyFrame(Duration.millis(18), e->{
    		map.forEach((key, value)-> gravityLoop(key,value));
    		if(this.onPlatform == false) {
    			hero.setLayoutY(hero.getLayoutY()+4);
    		}
    		else {
    			letsJump(hero,gravity);
    		}
    	});
	    gravity.getKeyFrames().add(gravity_frame);
	    gravity.play();
    }
  
    public int getcurrCoins() {
    	return this.currcoins;
    }

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }

}
