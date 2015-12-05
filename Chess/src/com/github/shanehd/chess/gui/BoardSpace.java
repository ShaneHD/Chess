package com.github.shanehd.chess.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.github.shanehd.chess.Piece;
import com.github.shanehd.chess.Player;
import com.github.shanehd.chess.Side;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class BoardSpace extends JPanel implements MouseListener {
	//public final static int SIZE = 64;
	public final int x, y;
	public Piece piece;
	private final static boolean SHOW_COORDINATES = true;
	public final Color defaultColor;
	public static Player player;
	
	public BoardSpace(int color, int x, int y) {
		this.x = x;
		this.y = y;

		addMouseListener(this);
		setBackground(defaultColor = color % 2 == 0 ? Color.black : Color.white);
	}

	public boolean containsEnemy() {
		return piece == null ? false : piece.side.equals(Side.turn.opposite());
	}
	
	public BoardSpace left() {
		return x == 1 ? null : Board.spaces[x - 1][y];
	}

	public BoardSpace right() {
		return x == 8 ? null : Board.spaces[x + 1][y];
	}
	
	public BoardSpace up() {
		return y == 1 ? null : Board.spaces[x][y - 1];
	}
	
	public BoardSpace down() {
		return y == 8 ? null : Board.spaces[x][y + 1];
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if(piece != null)
			piece.draw(g);
		
		if(SHOW_COORDINATES) {
			Color old = g.getColor();
			g.setColor(Color.pink);
			g.drawString(x + ", " + y, x, y + 12);
			g.setColor(old);
		}
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this) {
			player.click(this, e.getButton());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
