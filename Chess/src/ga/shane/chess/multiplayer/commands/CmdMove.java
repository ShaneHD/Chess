package ga.shane.chess.multiplayer.commands;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.Move;
import ga.shane.chess.multiplayer.gui.Window;
import ga.shane.utilities.net.Command;
import ga.shane.utilities.net.NetworkHelper;

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
