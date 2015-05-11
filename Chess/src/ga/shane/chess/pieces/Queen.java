package ga.shane.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.MoveTrain;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;

/** 
 * @author http://www.shane.ga
 */
public class Queen extends Piece {
	public Queen(Side side) {
		super(side, 2);
	}
	
	public final static int[][] DEFAULT_POSITIONS = {
		{
			4, 1
		}
	};

	@Override
	public List<MoveTrain> createTrains() {
		ArrayList<MoveTrain> trains = new ArrayList<MoveTrain>();
		trains.addAll(new Rook(side).setSpace(getSpace()).createTrains());
		trains.addAll(new Bishop(side).setSpace(getSpace()).createTrains());
	
		return trains;
	}
}
