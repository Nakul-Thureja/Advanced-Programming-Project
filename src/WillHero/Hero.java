package WillHero;

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

public class Hero extends GameComponents{
    private Helmet myHelmet;
    private Helmet myWeapon;
    private static int jumping_Height = 60;
    private static int forward_Move = 60;
    private boolean onPlatform;
    private ArrayList<Platform> allPlatform;
    private Timeline gravity;
    private TranslateTransition translate;
    private ScaleTransition scale;
    private int death;
    private ImageView deathh;
    
    public Hero(float x, float y,Helmet myHelmet,ImageView _image) {
        super(x, y,_image);
        this.death = 0 ;
        this.myWeapon = null;
        this.myHelmet = myHelmet;
        this.onPlatform = false;
        allPlatform = new ArrayList<>();
        this.translate = new TranslateTransition();
        this.scale = new ScaleTransition();
    }
    
    public int getDeath() {
    	return this.death;
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
    
    public void moveForward() {
    	//gravity.pause();
    	translate.pause();
    	this.getImage().setScaleX(1.05);
    	this.getImage().setScaleY(0.9);
    	//scale.pause();
//    	scale = new ScaleTransition();
//    	scale.setNode(this.getImage());
//		scale.setDuration(Duration.millis(210));
//		scale.setCycleCount(1);
//		scale.setInterpolator(Interpolator.LINEAR);
//		scale.setByX(0.3);
//		scale.setByY(-0.3);
		//scale.setAutoReverse(true);
    	translate = new TranslateTransition();
		translate.setNode(this.getImage());
		translate.setDuration(Duration.millis(210));
		translate.setCycleCount(1);
		translate.setByX(150);
		translate.play();
		//scale.play();
		translate.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				gravity.play();
			}
		});
    }
    public void letsJump() {
    	gravity.pause();
    	this.onPlatform = false;
//    	this.getImage().setScaleX(1.05);
//    	this.getImage().setScaleY(0.9);
    	translate = new TranslateTransition();
		translate.setNode(this.getImage());
		translate.setDuration(Duration.millis(450));
		translate.setCycleCount(1);
		translate.setByY(-100);
		translate.play();
		translate.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
			gravity.play();
			}
		});
		
    
    }
    public void giveDeath(ImageView death) {
    	deathh = death;
    }
    public void beginGravity() {
    	gravity = new Timeline();
    	gravity.setCycleCount(Animation.INDEFINITE);
    	int fallVal = 3;
    	KeyFrame gravity_frame = new KeyFrame(Duration.millis(18), e->{
    		for(int i=0;i<allPlatform.size();i++) {
    			this.getImage().setScaleX(1);
    			this.getImage().setScaleY(1);
    			allPlatform.get(i).checkCollision(this);
    			if(this.getImage().getBoundsInParent().intersects(deathh.getBoundsInParent())) {
    				this.death = 1;
    			}
    		}
    		if(this.onPlatform == false) {
    		this.getImage().setLayoutY(this.getImage().getLayoutY()+4);
    		}
    		else {
    			letsJump();
    		}
    	});
    gravity.getKeyFrames().add(gravity_frame);
    gravity.play();
    }
    
    
    
   

    @Override
    public int collision(GameComponents collidingComp) {
        return 0;
    }
}
