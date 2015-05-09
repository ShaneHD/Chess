package ga.shane.chess.pieces;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;

/** 
 * @author http://www.shane.ga
 */
public class Bishop extends Piece {
	public Bishop(Side side) {
		super(side, 5);
	}

	@Override
	public boolean isLegal(BoardSpace space) {
		int sx = space.x, sy = space.y;
		int cx = getSpace().x, cy = getSpace().y;
		
		for(int i = 0; i < 8; i++) {
			if((sx == cx - i && sy == cy + i) || (sx == cx + i && sy == cy - i) || (sx == cx - i && sy == cy - i) || (sx == cx + i && sy == cy + i))
				return true;
		}
		
		return false;
	}
}
