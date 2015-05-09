package ga.shane.chess;

import ga.shane.utilities.BRandom;

/** 
 * @author http://www.shane.ga
 */
public enum Side {
	GOLD(0), 
	SILVER(64);
	
	public static Side turn = new BRandom().nextBoolean() ? GOLD : SILVER;
	public final int spritesheetY;
	
	Side(int spritesheetY) {
		this.spritesheetY = spritesheetY;
	}
	
	public int parse(int i) {
		return this == GOLD ? -i : i;
	}
	
	public int translate(int pos) {
		return this == GOLD ? pos : 9 - pos;
	}
}
