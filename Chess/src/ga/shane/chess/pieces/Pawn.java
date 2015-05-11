package ga.shane.chess.pieces;

import ga.shane.chess.Board;
import ga.shane.chess.BoardSpace;
import ga.shane.chess.MoveTrain;
import ga.shane.chess.Piece;
import ga.shane.chess.Side;

import java.util.List;

/** 
 * @author http://www.shane.ga
 */
public class Pawn extends Piece {
	public Pawn(Side side) {
		super(side, 6);
	}

	private int allowedSteps() {
		return getSpace().y == side.line2Y() ? 2 : 1;
	}
	
	public final static int[][] DEFAULT_POSITIONS =  {
		{
			1, 2
		},/* {
			2, 2
		}, {
			3, 2
		}, {
			4, 2
		}, {
			5, 2
		}, {
			6, 2
		}, {
			7, 2
		}, {
			8, 2
		}*/
	};

	@Override
	public List<MoveTrain> createTrains() {
		int x = getSpace().x, y = getSpace().y;
		
		int[][] moves = new int[][] {
			{
				x, y - side.parse(1)	
			}, {
				x, y - side.parse(2)
			}, {
				x + 1, y - side.parse(1)
			}, {
				x - 1, y - side.parse(1)
			}
		};
		
		if(allowedSteps() == 1)
			moves[1] = MoveTrain.INVALID;
		
		for(int i = 2; i <= 3; i++) {
			int sx = moves[i][0], sy = moves[i][1];
			BoardSpace space = Board.spaces[sx][sy];
			
			if(!space.containsEnemy())
				moves[i] = MoveTrain.INVALID;
		}
		
		return MoveTrain.compile(moves);
	}
}
