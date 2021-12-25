package WillHero;

import java.io.Serializable;

public class GameSlots implements Serializable {
	private Game slot1;
	private Game slot2;
	private Game slot3;
	private Game slot4;
	
	private static GameSlots SLOT = null;
	
	public static GameSlots getInstance() { 
		if (SLOT == null){
			SLOT = new GameSlots(); 
		}
		return SLOT; 
	}
	
	public static void setInstance(GameSlots Slot) {
		SLOT = Slot;		
	}
	
	private GameSlots(){
		this.slot1 = null;
		this.slot2 = null;
		this.slot3 = null;
		this.slot4 = null;		
	}
	
	public void setSlot1(Game game) {
		this.slot1 = game;
	}
	
	public Game getSlot1() {
		return this.slot1;
	}
	
	public void setSlot2(Game game) {
		this.slot2 = game;
	}
	
	public Game getSlot2() {
		return this.slot2;
	}
	
	public void setSlot3(Game game) {
		this.slot3 = game;
	}
	
	public Game getSlot3() {
		return this.slot3;
	}
	
	public void setSlot4(Game game) {
		this.slot4 = game;
	}
	
	public Game getSlot4() {
		return this.slot4;
	}

	
}
