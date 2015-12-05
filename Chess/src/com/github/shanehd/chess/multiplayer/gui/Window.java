package com.github.shanehd.chess.multiplayer.gui;

import com.github.shanehd.chess.multiplayer.Player;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Window extends com.github.shanehd.chess.gui.Window {
	public static Board board;
	
	public Window() {
		super(board = new Board(), new Player());
	}
}
