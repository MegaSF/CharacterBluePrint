/**
 *@author evanrhea
 */
public class Character {
	/**
 	*UPDATED:
  	- Added damage increade
   	- Added level up feature (still in testing)
    	- Added damage scaling based off level up (also in testing)
  	*/
	
	// INSTANCE VARS AND CONSTRUCTOR
	
	private String name;
	private String Role;
	private int hp;
	private int maxHp;
	private int damage = 5;
	private int damageTaken;
	private int level = 1;
//	private boolean mastered;
	private int maxLevel;
	private int Experience;
	private int potion;
	private int EXPGain;
	private int EXPCap;

	public Character(String name, String Role, int hp, int maxHp, int maxLevel) {
		this.name = name;
		this.Role = Role;
		this.hp = hp;
		this.maxHp = maxHp;
		this.maxLevel = maxLevel;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getRole() {
		return this.Role;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getMaxLevel() {
		return this.maxLevel;
	}
	
	public int getEXP() {
		return this.Experience;
	}
	
	public int getDamageTaken() {
		return this.damageTaken;
	}
	
	public int getPotion() {
		return this.potion;
	}
	
	public int getEXPGain() {
		return this.EXPGain;
	}
	
	public int getEXPCap() {
		return this.EXPCap;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	
	public void setEXP(int amount) {
		Experience = Math.max(0,Math.min(amount / 25, maxLevel));
	}
	
	public void setEXPCap(int amount) {
		EXPCap = Math.max(1, amount);
	}
	
	public void setLevel(int amount) {
		this.level = Math.max(1, Math.min(amount, maxLevel));
	}
	
	public void setMaxLevel(int amount) {
		this.maxLevel = Math.max(this.level + 1, amount);
	}
	
	public void setDamageTaken(int amount) {
		this.damageTaken  = Math.max(1, amount);
	}
	

	public void setPotion(int amount) {
		this.potion = Math.max(1, amount);
	}
	
	public int loseHealth() {
		int hpBefore = this.hp;
		
		hp = Math.max(0, hpBefore - damageTaken);
		
		int HpLost = Math.max(0, hpBefore - hp);
		
		return HpLost;
	}
	
	public int recoverHealth() {
		int hpBefore = this.hp;
		hp = Math.max(0, Math.min(maxHp, hpBefore + potion));
		int hpRecovered = Math.min(potion	,maxHp - hpBefore);
		return hpRecovered;
	}
	
	public void setEXPGain(int amount) {
		this.EXPGain = Math.max(0, amount);
		
	}
	
	public void EarnEXP() {
//		// increase experience accumulated
		Experience += EXPGain;
//		// level up based on expgained
		level = Math.min(maxLevel, level + (Experience / EXPCap));
		damage = Math.min(damage + (level % hp), 99999999);
	}
	
	
	
	public void Display() {
		System.out.println("Name: " + name);
		System.out.println("Role: " + Role);
		System.out.println("Level: " + level);
		System.out.println("HP/MAX: " + hp + "/" + maxHp);
		System.out.println("Damage: " + damage);
	}
	
}



/**
 * @description
 * This is a class focused on abstracting and building characters for a video game,
 * like a Role Playing Game.
 * 
 * Each character will have a few attributes, including:
 * 
 * Name => string to identify a character
 * 
 * Role => or class, the play style of said character
 * 
 * hp/maxHp => how much health a character has, any values they have cannot go below 
 * zero or above maximum (unless specified later
 * 
 * level => eventually dictates how strong a character is (hp, damage, etc), if level
 * above max, mastery is achieved, in which damage and health both max out.
 */


