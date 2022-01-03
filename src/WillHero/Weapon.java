package WillHero;

import java.util.HashMap;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Weapon extends GameComponents{
    private int level;
    private int damage;
    private transient ImageView myImage;
    private transient Timeline collision;
    private boolean attacking;

    public Weapon(double x,double y) {
        super(x, y);
        this.damage = 0;
        this.level = 0;
        attacking = false;
        this.setVisibilty(false);
    }
    
    public void setWeaponforWeapon(ImageView weapon) {
    	this.myImage = weapon;
    	
    }
     
public void beginGravity(HashMap<GameComponents, ImageView> map) {
		myImage.translateXProperty().addListener((obs, old, newValue) -> {
				int offset = newValue.intValue();
				// mycollider.setTranslateX(offset);
				this.setPositionX(offset);
			});
	
	Thread thread = new Thread(() -> {
			
			collision = new Timeline();
			collision.setCycleCount(Animation.INDEFINITE);
			KeyFrame collision_frame = new KeyFrame(Duration.millis(72), e -> {
				map.forEach((key, value) -> collideLoop(key, value));
			});
			collision.getKeyFrames().add(collision_frame);
			collision.play();
		});
		thread.start();
	}
    
    public boolean getAttacking() {
    	return this.attacking;
    }
    
    public void collideLoop(GameComponents component, ImageView image) {
		
		if (component.getClass() == GreenOrc.class) {
			if (this.checkCollision(image, myImage) && this.getVisibilty()) {
				attacking= true;
				component.setVisibilty(false);
				image.setVisible(false);
				((GreenOrc)component).getCollider().setVisible(false);

			}
		} else if (component.getClass() == RedOrc.class && this.getVisibilty()) {
			if (this.checkCollision(image, myImage)) {
				attacking = true;
				component.setVisibilty(false);
				image.setVisible(false);
				((RedOrc)component).getCollider().setVisible(false);
			}
	}
		else if (component.getClass() == BossOrc.class && this.getVisibilty()) {
			if (this.checkCollision(image, myImage)) {
				attacking = true;
				component.setVisibilty(false);
				image.setVisible(false);
				((BossOrc)component).getCollider().setVisible(false);
			}
    }
    }
    
    public void setLevel(int level) {
 
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    @Override
    public int collision(ImageView collidingComp) {
        return 0;
    }
}
