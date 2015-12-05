package com.github.shanehd.chess.pieces;

import java.util.List;

import com.github.shanehd.chess.MoveTrain;
import com.github.shanehd.chess.Piece;
import com.github.shanehd.chess.Side;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Bishop extends Piece {
	public Bishop(Side side) {
		super(side, 5);
	}
	
	public final static int[][] DEFAULT_POSITIONS = {
		{
			3, 1
		}, {
			6, 1
		}
	};
	
	@Override
	public List<MoveTrain> createTrains() {
		MoveTrain ne = new MoveTrain(), nw = new MoveTrain(), se = new MoveTrain(), sw = new MoveTrain();
		int cx = getSpace().x, cy = getSpace().y;
		
		int y = cy - 1;
		for(int x = cx + 1; x <= 8; x++) {
			ne.add(x, y);
			y--;
		}
		
		y = cy - 1;
		for(int x = cx - 1; x >= 1; x--) {
			nw.add(x, y);
			y--;
		}
		
		y = cy + 1;
		for(int x = cx + 1; x <= 8; x++) {
			se.add(x, y);
			y++;
		}
		
		y = cy + 1;
		for(int x = cx - 1; x >= 1; x--) {
			sw.add(x, y);
			y++;
		}
		
		return MoveTrain.compile(ne, nw, se, sw);
	}
}
