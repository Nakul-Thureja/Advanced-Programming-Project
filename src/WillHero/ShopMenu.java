package WillHero;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ShopMenu {
	@FXML
	private ImageView hero1;
	@FXML
	private ImageView hero2;
	@FXML
	private ImageView hero3;
	@FXML
	private ImageView hero4;
	@FXML
	private ImageView booster;
	
	private Game currGame;
	
	public void buyHero1(MouseEvent e) {
		int val = currGame.canBuy(1,10);
		if( val == 0) {
			currGame.addHelmet(1);
		}
			
	}
    
	public void buyHero2(MouseEvent e) {
		int val = currGame.canBuy(2,10);
		if( val == 0) {
			currGame.addHelmet(2);
		}
	}
    
	public void buyHero3(MouseEvent e) {
		int val = currGame.canBuy(3,20);
		if( val == 0) {
			currGame.addHelmet(3);
		}
	}
    
	public void buyHero4(MouseEvent e) {
		int val = currGame.canBuy(4,20);
		if( val == 0) {
			currGame.addHelmet(4);
		}	
	}
	
	public void buyBooster(MouseEvent e) {
		
	}
}
