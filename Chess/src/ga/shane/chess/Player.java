package ga.shane.chess;

import java.awt.Color;

/** 
 * @author http://www.shane.ga
 */
public class Player {	
	public static Piece selectedPiece;
	
	public static void click(BoardSpace space) {
		if(selectedPiece == null && space.piece != null && space.piece.side == Side.turn) {
			selectedPiece = space.piece;
			space.setBackground(Color.yellow);

			Move move = new Move(selectedPiece, space.piece.createTrains());
			
			for(MoveTrain train : move.trains) {
				for(BoardSpace possible : train) {
					possible.setBackground(Color.red);
				}
			}
		} 
	}
}
