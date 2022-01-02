package WillHero;

import java.io.Serializable;

public class GameSlots implements Serializable {
	private Gamer slot1;
	private Gamer slot2;
	private Gamer slot3;
	private Gamer slot4;
	
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
	
	public void setSlot1(Gamer game) {
		this.slot1 = game;
	}
	
	public Gamer getSlot1() {
		return this.slot1;
	}
	
	public void setSlot2(Gamer game) {
		this.slot2 = game;
	}
	
	public Gamer getSlot2() {
		return this.slot2;
	}
	
	public void setSlot3(Gamer game) {
		this.slot3 = game;
	}
	
	public Gamer getSlot3() {
		return this.slot3;
	}
	
	public void setSlot4(Gamer game) {
		this.slot4 = game;
	}
	
	public Gamer getSlot4() {
		return this.slot4;
	}

	
}
