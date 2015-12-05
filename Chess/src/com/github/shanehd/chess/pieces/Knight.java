package com.github.shanehd.chess.pieces;

import java.util.List;

import com.github.shanehd.chess.MoveTrain;
import com.github.shanehd.chess.Piece;
import com.github.shanehd.chess.Side;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Knight extends Piece {
	public Knight(Side side) {
		super(side, 4);
	}
	
	public final static int[][] DEFAULT_POSITIONS = {
		{
			2, 1
		}, {
			7, 1
		}
	};

	@Override
	public List<MoveTrain> createTrains() {
		int x = getSpace().x, y = getSpace().y;
		
		int[][] moves = {
			{
				x - 1, y - 2
			}, {
				x + 1, y - 2
			}, {
				x - 2, y - 1
			}, {
				x + 2, y - 1
			}, {
				x - 1, y + 2
			}, {
				x + 1, y +2
			}, {
				x - 2, y + 1
			}, {
				x + 2, y +1
			}
		};
		
		return MoveTrain.compile(moves);
	}
}
