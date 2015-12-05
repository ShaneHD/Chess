package ga.shane.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ga.shane.chess.gui.Board;
import ga.shane.chess.gui.BoardSpace;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class MoveTrain extends ArrayList<BoardSpace> {
	public final static int[] INVALID = new int[]{-1, -1};
	
	public MoveTrain() {}
	
	public MoveTrain(BoardSpace... spaces) {
		for(BoardSpace space : spaces)
			add(space);
	}
	
	public void cancel(BoardSpace space) {
		int index = indexOf(space);

		boolean found = false;	
		ArrayList<BoardSpace> toRemove = new ArrayList<BoardSpace>();
		
		for(BoardSpace s : this) {
			if(s == space)
				found = true;
			
			if(found)
				toRemove.add(s);
		}
		
		for(BoardSpace remove : toRemove)
			remove(remove);
		
		/*for(int i = index; i < size(); i++) {
			BoardSpace s = get(i);
			System.out.println("Removing " + i + ". [" + s.x + ", " + s.y + "]");
			remove(i);
		}*/
	}
	
	public boolean add(int x, int y) {
		if(x < 1 || x > 8 || y < 1 || y > 8)
			return false;
		
		return super.add(Board.spaces[x][y]);
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for(BoardSpace space : this)
			str+= "," + space.x + "," + space.y;
	
		return str.replaceFirst(",", "");
	}
	
	/**
	 * Converts {@link String} in {@link #toString()} format to a {@link MoveTrain} instance
	 */
	public static MoveTrain fromString(String str) {
		MoveTrain train = new MoveTrain();
		String[] split = str.split(",");
		
		int x = 0, y = 0;
		
		for(int i = 0; i < split.length; i++) {
			if(i % 2 == 0)
				x = Integer.parseInt(split[i]);
			else {
				y = Integer.parseInt(split[i]);
				train.add(Board.spaces[x][y]);
			}
		}
		
		return train;
	}
	
	public static List<MoveTrain> compile(int[][] moves) {
		ArrayList<MoveTrain> trains = new ArrayList<MoveTrain>();
		
		for(int[] pos : moves) {
			MoveTrain train = new MoveTrain();
			train.add(pos[0], pos[1]);
			trains.add(train);
		}
		
		return trains;
	}
	
	public static List<MoveTrain> compile(MoveTrain... trains) {
		return Arrays.asList(trains);
	}
}
