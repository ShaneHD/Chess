package ga.shane.chess.pieces;

import ga.shane.chess.MoveTrain;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;

import java.util.List;

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
