package ga.shane.chess.pieces;

import ga.shane.chess.MoveTrain;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;

import java.util.List;

/** 
 * @author http://www.shane.ga
 */
public class Bishop extends Piece {
	public Bishop(Side side) {
		super(side, 5);
	}
	
	public final static int[][] DEFAULT_POSITIONS = {
		{
			3, 1
		}, {
			6, 1
		}
	};
	
	@Override
	public List<MoveTrain> createTrains() {
		MoveTrain ne = new MoveTrain(), nw = new MoveTrain(), se = new MoveTrain(), sw = new MoveTrain();
		int cx = getSpace().x, cy = getSpace().y;
		
		int y = cy - 1;
		for(int x = cx + 1; x <= 8; x++) {
			ne.add(x, y);
			y--;
		}
		
		y = cy - 1;
		for(int x = cx - 1; x >= 1; x--) {
			nw.add(x, y);
			y--;
		}
		
		y = cy + 1;
		for(int x = cx + 1; x <= 8; x++) {
			se.add(x, y);
			y++;
		}
		
		y = cy + 1;
		for(int x = cx - 1; x >= 1; x--) {
			sw.add(x, y);
			y++;
		}
		
		return MoveTrain.compile(ne, nw, se, sw);
	}
}
