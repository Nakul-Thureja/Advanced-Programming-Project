package WillHero;


public abstract class Orc extends GameComponents{
	private int health;
	private int coin_Value;
	private int push_Value;
	private int jump_Value;
	public Orc(float x,float y,int health,int coin_Value,int push_Value,int jump_Value) {
		super(x,y);
		this.health = health;
		this.coin_Value = coin_Value;
		this.push_Value = push_Value;
		this.jump_Value = jump_Value;
	}
	public int getCoinValue() {
		return this.coin_Value;
	}
}
