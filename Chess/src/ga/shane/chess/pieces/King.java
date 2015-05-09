package ga.shane.chess.pieces;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;

/** 
 * @author http://www.shane.ga
 */
public class King extends Piece {
	public King(Side side) {
		super(side, 1);
	}

	@Override
	public boolean isLegal(BoardSpace space) {
		int sx = space.x, sy = space.y;
		int cx = getSpace().x, cy = getSpace().y;
		
		return (sx == cx - 1 && sy == cy) || (sx == cx + 1 && sy == cy) || (sy == cy + 1 && sx == cx) || (sy == cy - 1 && sx == cx);
	}
	
	public final static int[][] DEFAULT_POSITIONS =  {
		{
			5, 1
		}
	};
}
