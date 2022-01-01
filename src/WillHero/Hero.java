package WillHero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Hero extends GameComponents implements Serializable{
    private Helmet myHelmet;
    private Helmet myWeapon;
    private static int jumping_Height = 60;
    private static int forward_Move = 60;
    private boolean onPlatform;
  //  private ArrayList<Platform> allPlatform;
    private transient TranslateTransition translate;
    private transient Timeline gravity;
    private transient TranslateTransition translatefwd;
    private transient ImageView hero;
    private int currcoins;
    public Hero(double x,double y,Helmet myHelmet) {
        super(x, y);
        this.myWeapon = null;
        this.myHelmet = myHelmet;
        this.onPlatform = false;
        this.currcoins = 0;
       // allPlatform = new ArrayList<>();
        translate = new TranslateTransition();
        translatefwd = new TranslateTransition();
        gravity = new Timeline();
       
    }
    public void stopALL() {
    	gravity.stop();
    	translate.stop();
    	translatefwd.stop();
    }
    
   
//    public void givePlatform(ArrayList<Platform> _P) {
//    	this.allPlatform = _P;
//    }
  
    public void setMyWeapon(Helmet myWeapon) {
        this.myWeapon = myWeapon;
    }
    public void setFall(boolean boo) {
    	this.onPlatform = boo;
    }
    
    public void moveForward(ImageView image) {
    	gravity.pause();
    	translate.pause();
    	//if(translatefwd.)
    	image.setScaleX(1.05);
    	image.setScaleY(0.9);
    	//scale.pause();
//    	scale = new ScaleTransition();
//    	scale.setNode(this.getImage());
//		scale.setDuration(Duration.millis(210));
//		scale.setCycleCount(1);
//		scale.setInterpolator(Interpolator.LINEAR);
//		scale.setByX(0.3);
//		scale.setByY(-0.3);
		//scale.setAutoReverse(true);
  // System.out.println(image.getTranslateX());
    	translatefwd = new TranslateTransition();
 		translatefwd.setDuration(Duration.millis(150));
 		translatefwd.setCycleCount(1);
 		translatefwd.setByX(92);
    	translatefwd.setNode(image);

		//translate.setByX(150);
		translatefwd.play();
		translatefwd.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				
				gravity.play();
				}
		});
		this.setPositionX(image.getTranslateX());
		//System.out.println(this.getPositionX());
		this.setPositionY(image.getY());
    }
//				myHero.setPositionX(image.getLayoutX());
//				myHero.setPositionY(image.getLayoutY());	
//			}
//		});
		
		
		//scale.play();
//		translate.setOnFinished(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				gravity.play();
//			}
//		});
    
    public void letsJump(ImageView image, Timeline gravity) {
    	gravity.pause();
    	this.onPlatform = false;
//    	this.getImage().setScaleX(1.05);
//    	this.getImage().setScaleY(0.9);
    	translate = new TranslateTransition();
		translate.setNode(image);
		translate.setDuration(Duration.millis(450));
		translate.setCycleCount(1);
		translate.setByY(-100);
		translate.play();
		translate.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//System.out.println(image.getLayoutX()+" "+ image.getLayoutY());
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
			Platform dummy = new Platform(0, 0,0);
			Coin dummycoin = new Coin(0, 0);
			if (component.getClass() == dummy.getClass()){
				if(this.onPlatform == false) {
				this.onPlatform = dummy.checkCollision(image,hero);
			}}
				else if(component.getClass() == dummycoin.getClass()) {
					if(dummycoin.checkCollision(image,hero)) {
						if(component.getVisibilty())
							this.currcoins++;	
						component.setVisibilty(false);
						image.setVisible(false);
					}
					
				}
			}
    
 
    public void beginGravity(HashMap<GameComponents, ImageView> map) {
		//System.out.println("Askhat");
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
