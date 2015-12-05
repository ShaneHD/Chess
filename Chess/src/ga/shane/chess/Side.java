package ga.shane.chess;

import java.util.ArrayList;

import ga.shane.utilities.BRandom;
import ga.shane.utilities.gui.JTimer;


/** 
 * @author https://www.github.com/ShaneHD
 */
public enum Side {
	GOLD(0), 
	SILVER(64);
	
	public static Side only = null;
	public static Side turn = new BRandom().nextBoolean() ? GOLD : SILVER;
	
	public final JTimer timer = new JTimer();
	
	public final int spritesheetY;
	public final ArrayList<Piece> taken = new ArrayList<Piece>();
	
	static {
		for(Side side : Side.values()) {
			if(side.turn != side)
				side.timer.setPaused(true);
			
			side.timer.start();
		}
	}
	
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
