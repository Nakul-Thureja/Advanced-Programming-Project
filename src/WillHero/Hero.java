package WillHero;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
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
    
    public Hero(float x, float y,Helmet myHelmet,ImageView _image) {
        super(x, y,_image);
        this.myWeapon = null;
        this.myHelmet = myHelmet;
        this.onPlatform = false;
        allPlatform = new ArrayList<>();
    }
    
    public void givePlatform(Platform _P) {
    	this.allPlatform.add(_P);
    }
  
    public void setMyWeapon(Helmet myWeapon) {
        this.myWeapon = myWeapon;
    }
    public void setFall(boolean boo) {
    	this.onPlatform = boo;
    }
    public void letsJump() {
    	gravity.pause();
    	this.onPlatform = false;
    	translate = new TranslateTransition();
		translate.setNode(this.getImage());
		translate.setDuration(Duration.millis(600));
		translate.setCycleCount(1);
		translate.setByY(-60);
		translate.play();
		translate.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
			gravity.play();
			}
		});
		
    
    }
    public void beginGravity() {
    	gravity = new Timeline();
    	gravity.setCycleCount(Animation.INDEFINITE);
    	KeyFrame gravity_frame = new KeyFrame(Duration.millis(26), e->{
    		for(int i=0;i<allPlatform.size();i++) {
    			allPlatform.get(i).checkCollision(this);
    		}
    		if(this.onPlatform == false) {
    		this.getImage().setLayoutY(this.getImage().getLayoutY()+3);
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
