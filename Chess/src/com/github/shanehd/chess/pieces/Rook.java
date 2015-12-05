package com.github.shanehd.chess.pieces;

import java.util.List;

import com.github.shanehd.chess.MoveTrain;
import com.github.shanehd.chess.Piece;
import com.github.shanehd.chess.Side;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Rook extends Piece {	
	public Rook(Side side) {
		super(side, 3);
	}

	public final static int[][] DEFAULT_POSITIONS = {
		{
			1, 1
		}, {
			8, 1
		}
	};

	@Override
	public List<MoveTrain> createTrains() {
		MoveTrain right = new MoveTrain(), left = new MoveTrain(), up = new MoveTrain(), down = new MoveTrain();
		int cx = getSpace().x, cy = getSpace().y;
		
		for(int x = cx + 1; x <= 8; x++) {
			right.add(x, cy);
		}
		
		for(int x = cx - 1; x >= 1; x--) {
			left.add(x, cy);
		}
		
		for(int y = cy - 1; y >= 1; y--) {
			up.add(cx, y);
		}
		
		for(int y = cy + 1; y <= 8; y++) {
			down.add(cx, y);
		}

		return MoveTrain.compile(right, left, up, down);
	}
}
