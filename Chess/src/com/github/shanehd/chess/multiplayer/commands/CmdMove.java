package com.github.shanehd.chess.multiplayer.commands;

import com.github.shanehd.chess.Move;
import com.github.shanehd.chess.gui.BoardSpace;
import com.github.shanehd.chess.multiplayer.gui.Window;
import com.github.shanehd.utilities.net.Command;
import com.github.shanehd.utilities.net.NetworkHelper;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class CmdMove implements Command {

	@Override
	public void handle(NetworkHelper out, String command, String sub, String[] args) throws Exception {
		int startX = Integer.parseInt(args[1]);
		int startY = Integer.parseInt(args[2]);
		
		int newX = Integer.parseInt(args[3]);
		int newY = Integer.parseInt(args[4]);
		
		BoardSpace space = Window.board.spaces[startX][startY];
		new Move(space.piece, space.piece.createTrains()).to(Window.board.spaces[newX][newY]);
	}
}
