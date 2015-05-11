package ga.shane.chess;

import java.util.ArrayList;


/** 
 * @author http://www.shane.ga
 */
public enum Side {
	GOLD(0), 
	SILVER(64);
	
	public static Side turn = SILVER;//new BRandom().nextBoolean() ? GOLD : SILVER;
	public final int spritesheetY;
	public final ArrayList<Piece> taken = new ArrayList<Piece>();
	
	Side(int spritesheetY) {
		this.spritesheetY = spritesheetY;
	}
	
	public int parse(int i) {
		return this == GOLD ? -i : i;
	}
	
	public int translate(int pos) {
		return this == GOLD ? pos : 9 - pos;
	}
	
	public int line1Y() {
		return this == GOLD ? 1 : 8;
	}
	
	public int line2Y() {
		return this == GOLD ? 2 : 7;
	}
	
	public Side opposite() {
		return this == GOLD ? SILVER : GOLD;
	}
}
