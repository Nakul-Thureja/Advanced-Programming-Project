package WillHero;

public class GameFactory {

	public GameComponents createComponent(String need) {
		if(need.equals("platform")){
			return new Platform(0,0,0);
		}
		else if(need.equals("coin")){
			return new Coin(0,0);
		}
		else if(need.equals("redorc")) {
			return new RedOrc(0, 0, 0, 0, 0, 0);
		}
		else if(need.equals("greenorc")) {
			return new GreenOrc(0, 0, 0, 0, 0,200);
		}
		else if(need.equals("bossorc")) {
			return new BossOrc(0, 0, 0, 0, 0, 0);
		}
		else if(need.equals("weapon")) {
			return new Weapon(0, 0);
		}
		else if(need.equals("helmet")) {
			return new Helmet(0, 0, null);
		}
		else if(need.equals("companion")) {
			return new Companion(0, 0);
		}
		else if(need.equals("coinchest")) {
			return new CoinChest(0, 0, 0);
		}
		else if(need.equals("weaponchest")) {
			return new WeaponChest(0, 0, null);
		}
		else if(need.equals("collider")) {
			return new Collider(0, 0);
		}
		return null;
	}
}
