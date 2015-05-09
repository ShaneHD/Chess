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
	
	public Piece(Side side, int fromX) {
		image = set.getSubimage(64 * (fromX - 1), side.spritesheetY, 64, 64);
	}
	
	public void setSpace(BoardSpace space) {
		this.space = space;
	}
	
	public BoardSpace getSpace() {
		return space;
	}
	
	public void draw(Graphics g) {
		if(space == null)
			return;
		
		g.drawImage(image, Math.center(space.x, BoardSpace.SIZE), Math.center(space.y, BoardSpace.SIZE), null);
	}
}
