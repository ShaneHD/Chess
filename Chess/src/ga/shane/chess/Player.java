package ga.shane.chess;

import ga.shane.chess.gui.Board;

import java.awt.Color;

/** 
 * @author http://www.shane.ga
 */
public class Player {	
	public static Piece selectedPiece;
	private static Move move;
	
	public static void click(BoardSpace space, int mouse) {
		if(mouse == 3) {
			if(selectedPiece != null) {
				Board.resetBackgroundColors();
				selectedPiece = null;
				move = null;
			}
			
			return;
		} 
		
		if(selectedPiece == null && space.piece != null && space.piece.side == Side.turn) {
			selectedPiece = space.piece;
			space.setBackground(Color.yellow);

			move = new Move(selectedPiece, space.piece.createTrains());
			
			for(MoveTrain train : move.trains) {
				for(BoardSpace possible : train) {
					possible.setBackground(Color.red);
				}
			}
		} else if(selectedPiece != null && move.contains(space)) {
			move.to(space);
			click(null, 3);
		}
	}
}
