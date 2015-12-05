package com.github.shanehd.chess.pieces;

import java.util.List;

import com.github.shanehd.chess.MoveTrain;
import com.github.shanehd.chess.Piece;
import com.github.shanehd.chess.Side;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class King extends Piece {
	public King(Side side) {
		super(side, 1);
	}

	public final static int[][] DEFAULT_POSITIONS =  {
		{
			5, 1
		}
	};
	
	@Override
	public List<MoveTrain> createTrains() {
		int x = getSpace().x, y = getSpace().y;
		
		int[][] moves = {
			{
				x - 1, y
			}, {
				x + 1, y
			}, {
				x, y - 1
			}, {
				x, y + 1
			}, {
				x + 1, y - side.parse(1)
			}, {
				x - 1, y - side.parse(1)
			}, {
				x + 1, y + side.parse(1)
			}, {
				x - 1, y + side.parse(1)
			}
		};
				
		return MoveTrain.compile(moves);
	}
}
