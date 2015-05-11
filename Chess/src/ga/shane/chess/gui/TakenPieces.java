package ga.shane.chess.gui;

import ga.shane.chess.Side;

import javax.swing.JPanel;

/** 
 * @author http://www.shane.ga
 */
public class TakenPieces extends JPanel {
	public final Side side;
	
	public TakenPieces(Side side) {
		this.side = side;
		
		add(side.taken);
	}
}
