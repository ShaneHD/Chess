package ga.shane.chess.pieces;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;

/** 
 * @author http://www.shane.ga
 */
public class Pawn extends Piece {
	public Pawn(Side side) {
		super(side, 6);
	}

	@Override
	public boolean isLegal(BoardSpace space) {
		int sx = space.x, sy = space.y;
		int cx = getSpace().x, cy = getSpace().y;
		
		return sy == cy - side.parse(1) && sx == cx;
	}
}
