package ga.shane.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import ga.shane.chess.MoveTrain;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;
import ga.shane.chess.gui.BoardSpace;

/** 
 * @author https://www.github.com/ShaneHD
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
		BoardSpace space = getSpace();
		
		ArrayList<MoveTrain> trains = new ArrayList<MoveTrain>();
		trains.addAll(new Rook(side).setSpace(getSpace()).createTrains());
		trains.addAll(new Bishop(side).setSpace(getSpace()).createTrains());
		
		setSpace(space);
		
		return trains;
	}
}
