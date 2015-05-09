package ga.shane.chess.pieces;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;

/** 
 * @author http://www.shane.ga
 */
public class Queen extends Piece {
	public Queen(Side side) {
		super(side, 2);
	}

	@Override
	public boolean isLegal(BoardSpace space) {		
		return new Rook(side).setSpace(getSpace()).isLegal(space) || new Bishop(side).setSpace(getSpace()).isLegal(space);
	}
	
	public final static int[][] DEFAULT_POSITIONS = {
		{
			4, 1
		}
	};
}
