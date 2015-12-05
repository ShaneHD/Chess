package ga.shane.chess;

import ga.shane.chess.gui.Board;
import ga.shane.chess.gui.BoardSpace;

import java.awt.Color;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Player {	
	public Piece selectedPiece;
	private Move move;
	
	public static void highlightMove(MoveTrain train) {
		for(BoardSpace possible : train) {
			possible.setBackground(Color.red);
		}
	}
	
	public static void highlightSelectedSpace(BoardSpace space) {
		space.setBackground(Color.yellow);
	}
	
	public static void unhighlightMove() {
		Board.resetBackgroundColors();
	}
	
	protected void onMove(BoardSpace from, BoardSpace to) {}
	protected void onPickup(BoardSpace space, MoveTrain... trains) {}
	protected void onPutdown() {}
	
	public void click(BoardSpace space, int mouse) {		
		if(mouse == 3) {
			if(selectedPiece != null) {
				unhighlightMove();
				selectedPiece = null;
				move = null;
				onPutdown();
			}
			
			return;
		} 
		
		if(Side.only != null && Side.turn != Side.only)
			return;
		
		if(selectedPiece == null && space.piece != null && space.piece.side == Side.turn) {
			selectedPiece = space.piece;
			highlightSelectedSpace(space);
			
			move = new Move(selectedPiece, space.piece.createTrains());
			
			for(MoveTrain train : move.trains) {
				onPickup(space, train);
				highlightMove(train);
			}
			
		} else if(selectedPiece != null && move.contains(space)) {
			onMove(selectedPiece.getSpace(), space);
			move.to(space);
			onPutdown();
			click(null, 3);
		}
	}
}
