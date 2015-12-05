package ga.shane.chess.gui;

import ga.shane.chess.Piece;
import ga.shane.chess.Side;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class TakenPieces extends JPanel {
	public final Side side;
	
	public TakenPieces(Side side) {
		this.side = side;
		
		setPreferredSize(new Dimension(650, 32));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		int x = 0;
		
		for(Piece piece : side.taken) {
			g.drawImage(piece.image, x, 0, 32, 32, getBackground(), null);
			x+= 34;
		}
	
		repaint();
	}
}
