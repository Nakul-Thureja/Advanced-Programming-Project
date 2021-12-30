package WillHero;

import java.io.Serializable;
import java.util.ArrayList;

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
    private ArrayList<Platform> allPlatform;
    private int dead;
    private transient TranslateTransition translate;
    private transient Timeline gravity;
    
    public Hero(double x,double y,Helmet myHelmet) {
        super(x, y);
        this.dead = 0 ;
        this.myWeapon = null;
        this.myHelmet = myHelmet;
        this.onPlatform = false;
        allPlatform = new ArrayList<>();
        translate = new TranslateTransition();
    }
    
    public int getDeath() {
    	return this.dead;
    }
    public void givePlatform(ArrayList<Platform> _P) {
    	this.allPlatform = _P;
    }
  
    public void setMyWeapon(Helmet myWeapon) {
        this.myWeapon = myWeapon;
    }
    public void setFall(boolean boo) {
    	this.onPlatform = boo;
    }
    
    public void moveForward(ImageView image) {
        //gravity.pause();
    	//translate.pause();
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
    	//System.out.println(image.getX());
    	translate = new TranslateTransition();
		translate.setNode(image);
		translate.setDuration(Duration.millis(210));
		translate.setCycleCount(1);
		translate.setByX(150);
		//translate.setByX(150);
		translate.play();
		translate.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				
				gravity.play();
				}
		});
		this.setPositionX(this.getPositionX()+150);
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
 
    public void beginGravity(ArrayList<ImageView> collider,ImageView image, ImageView death) {
    	gravity = new Timeline();
    	gravity.setCycleCount(Animation.INDEFINITE);
    	KeyFrame gravity_frame = new KeyFrame(Duration.millis(18), e->{
    		for(int i=0;i<allPlatform.size();i++) {
    			image.setScaleX(1);
    			image.setScaleY(1);
    			if(this.onPlatform == false) {
    			this.onPlatform = allPlatform.get(i).checkCollision(collider.get(i),image);
    			}
    			if(image.getBoundsInParent().intersects(death.getBoundsInParent())) {
    				this.dead = 1;
    			}
    		}
    		if(this.onPlatform == false) {
    		image.setLayoutY(image.getLayoutY()+4);
    		}
    		else {
    			letsJump(image,gravity);
    		}
    	});
	    gravity.getKeyFrames().add(gravity_frame);
	    gravity.play();
    }
  
    
    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }

	
}
