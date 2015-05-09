package ga.shane.chess.pieces;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;

/** 
 * @author http://www.shane.ga
 */
public class Knight extends Piece {
	public Knight(Side side) {
		super(side, 4);
	}

	@Override
	public boolean isLegal(BoardSpace space) {
		int sx = space.x, sy = space.y;
		int cx = getSpace().x, cy = getSpace().y;
		
		return ((sy == cy + 2 || sy == cy - 2) && (sx == cx - 1 || sx == cx + 1)) || ((sx == cx - 2 || sx == cx + 2) && (sy == cy + 1 || sy == cy - 1));
	}
	
	public final static int[][] DEFAULT_POSITIONS = {
		{
			2, 1
		}, {
			7, 1
		}
	};
}
