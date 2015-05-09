package ga.shane.chess;

import ga.shane.utilities.FileUtils;
import ga.shane.utilities.ImageUtils;
import ga.shane.utilities.Math;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/** 
 * @author http://www.shane.ga
 */
public abstract class Piece {
	private final BufferedImage image;
	private BoardSpace space; 
	private final static BufferedImage set = ImageUtils.load(FileUtils.newFile("res/pieces.png"));
	public final Side side;
	
	public Piece(Side side, int fromX) {
		this.side = side;
		image = set.getSubimage(64 * (fromX - 1), side.spritesheetY, 64, 64);
	}
	
	public Piece setSpace(BoardSpace space) {
		this.space = space;
		return this;
	}
	
	public BoardSpace getSpace() {
		return space;
	}
	
	public abstract boolean isLegal(BoardSpace space);
	
	public void draw(Graphics g) {
		if(space == null)
			return;
		
		//TODO figure out how to get width/height of a square..
		g.drawImage(image, Math.center(space.x, 22), Math.center(space.y, 22), null);
	}
}
