package com.github.shanehd.chess.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.github.shanehd.chess.Side;
import com.github.shanehd.chess.pieces.Bishop;
import com.github.shanehd.chess.pieces.King;
import com.github.shanehd.chess.pieces.Knight;
import com.github.shanehd.chess.pieces.Pawn;
import com.github.shanehd.chess.pieces.Queen;
import com.github.shanehd.chess.pieces.Rook;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Board extends JPanel {
	public static final BoardSpace[][] spaces = new BoardSpace[9][9];
	
	public Board() {
		setLayout(new GridLayout(8, 8));
		
		int tick = 0, $wag = 0;
		
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(y % 8 == 0) {
					$wag++;
					tick = y - $wag;
				}
				
				BoardSpace space;
//				+1 so that its coords are 1 to 8
				add(space = new BoardSpace(tick++, y + 1, x + 1));
				spaces[y + 1][x + 1] = space;
			}
		}
		
		//TODO figure out a way of storing and accessing default pos without having static vars per class...
		for(Side side : Side.values()) {
			//Bishops
			for(int[] pos : Bishop.DEFAULT_POSITIONS) {
				int x = pos[0], y = side.translate(pos[1]);
				new Bishop(side).setSpace(spaces[x][y]);
			}
			
			//Kings
			for(int[] pos : King.DEFAULT_POSITIONS) {
				int x = pos[0], y = side.translate(pos[1]);
				new King(side).setSpace(spaces[x][y]);
			}
			
			//Knights
			for(int[] pos : Knight.DEFAULT_POSITIONS) {
				int x = pos[0], y = side.translate(pos[1]);
				new Knight(side).setSpace(spaces[x][y]);
			}
			
			//Pawns
			for(int[] pos : Pawn.DEFAULT_POSITIONS) {
				int x = pos[0], y = side.translate(pos[1]);
				new Pawn(side).setSpace(spaces[x][y]);
			}
			
			//Queens
			for(int[] pos : Queen.DEFAULT_POSITIONS) {
				int x = pos[0], y = side.translate(pos[1]);
				new Queen(side).setSpace(spaces[x][y]);
			}
			
			//Rooks
			for(int[] pos : Rook.DEFAULT_POSITIONS) {
				int x = pos[0], y = side.translate(pos[1]);
				new Rook(side).setSpace(spaces[x][y]);
			}
		}
	}
	
	public static void resetBackgroundColors() {
		for(int x = 1; x <= 8; x++) {
			for(int y = 1; y <= 8; y++) {
				BoardSpace space = spaces[x][y];	
				space.setBackground(space.defaultColor);
			}
		}
	}
}
