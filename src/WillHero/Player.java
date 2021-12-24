package WillHero;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    public Player(String playerName) {
        this.name = playerName;
    }
    public String getName() {
    	return this.name;
    }
}
