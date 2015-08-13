package ga.shane.chess.multiplayer.gui;

import ga.shane.chess.multiplayer.Player;

public class Window extends ga.shane.chess.gui.Window {
	public static Board board;
	
	public Window() {
		super(board = new Board(), new Player());
	}
}
