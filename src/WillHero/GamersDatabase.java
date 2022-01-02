package WillHero;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class GamersDatabase implements  Serializable{
	private ArrayList<Gamer> Gamers ;
	private GamersDatabase() {
		this.Gamers = new ArrayList<>();
	}
	public ArrayList<Gamer> getData(){
		return Gamers;
	}
	
	private static GamersDatabase database;
	private static void setInstance(GamersDatabase data) {
		database = data;
	}
	public static GamersDatabase getInstance() { 
		if (database == null){
			database = new GamersDatabase(); 
		}
		return database; 
	}
	
	public void addGamer(Gamer gamer) {
		for(int i=0;i<Gamers.size();i++) {
			if(Gamers.get(i).getPlayerName().equals(gamer.getPlayerName())) {
				Gamers.remove(i);
			}
		}
		Gamers.add(gamer);
	}
	public static void serialize() throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("gamerdatabase.txt"));
			out.writeObject(database);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	public static void deserialize() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream (new FileInputStream("gamerdatabase.txt"));
			GamersDatabase slot = (GamersDatabase) in.readObject();
			GamersDatabase.setInstance(slot);
			Gamer.setInstance(slot.getData());

			System.out.println("Hello from deserialize");
			try {
				for(int i=0;i<database.Gamers.size();i++) {
					System.out.println(database.Gamers.get(i).getPlayerName());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(EOFException e) {
			return;
		}
		finally {
			if(in!=null) {
				in.close();
			}
		}
	}
}
