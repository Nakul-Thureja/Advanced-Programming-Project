package WillHero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class fallingPlatform extends Platform{
    private int falling_Time;
	private transient Timeline gravity;
	private transient ImageView myImage;
    public fallingPlatform(double x,double y, int size,int fallingtime) {
        super(x, y, size);
        this.falling_Time = fallingtime;
        gravity = new Timeline();
    }
    
    public void stopALL() {
    	if(gravity!=null) {
    		gravity.stop();
    	}
    }
    
    public void setImage(ImageView image) {
    	this.myImage = image;
    }
    public void beginGravity() {
    	gravity = new Timeline();
		gravity.setCycleCount(Animation.INDEFINITE);
		KeyFrame gravity_frame = new KeyFrame(Duration.millis(17), e -> {
				myImage.setLayoutY(myImage.getLayoutY() + 5);			
		});
		gravity.getKeyFrames().add(gravity_frame);
		gravity.play();
	//});
//	thread.start();
}

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
