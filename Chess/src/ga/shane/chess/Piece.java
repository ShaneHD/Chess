package ga.shane.chess;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import ga.shane.chess.gui.BoardSpace;
import ga.shane.utilities.EMath;
import ga.shane.utilities.FileUtils;
import ga.shane.utilities.ImageUtils;

/** 
 * @author https://www.github.com/ShaneHD
 */
public abstract class Piece {
	public final BufferedImage image;
	private BoardSpace space; 
	private final static BufferedImage set = ImageUtils.load(FileUtils.newFile("res/pieces.png"));
	public final Side side;
	
	public Piece(Side side, int fromX) {
		this.side = side;
		
		image = set.getSubimage(64 * (fromX - 1), side.spritesheetY, 64, 64);
	}
	
	public Piece setSpace(BoardSpace space) {
		this.space = space;
		
		if(space != null)
			space.piece = this;
		
		return this;
	}
	
	public BoardSpace getSpace() {
		return space;
	}
	
	public abstract List<MoveTrain> createTrains();
	
	public void draw(Graphics g) {
		if(space == null)
			return;
		
		//TODO figure out how to get width/height of a square..
		g.drawImage(image, EMath.center(space.x, 22), EMath.center(space.y, 22), null);
	}
}
