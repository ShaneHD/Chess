package ga.shane.chess.multiplayer.commands;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.Move;
import ga.shane.chess.MoveTrain;
import ga.shane.chess.multiplayer.Player;
import ga.shane.chess.multiplayer.gui.Window;
import ga.shane.utilities.net.Command;
import ga.shane.utilities.net.NetworkHelper;

public class CmdMove implements Command {

	@Override
	public void handle(NetworkHelper out, String command, String sub, String[] args) throws Exception {
		if(args[1].equals("true") || args[1].equals("false")) {
			boolean updown = Boolean.parseBoolean(args[1]);
			
			if(updown) {
				int x = Integer.parseInt(args[2]);
				int y = Integer.parseInt(args[3]);
				
				
				//FIXME still some bugs with this, sometimes a piece will change its icon... 
				BoardSpace space = Window.board.spaces[x][y];
				Player.highlightSelectedSpace(space);

				MoveTrain train = MoveTrain.fromStr(args[4]);
				Player.highlightMove(train);
			} else {
				Player.unhighlightMove();
			}	
		} else {
			int startX = Integer.parseInt(args[1]);
			int startY = Integer.parseInt(args[2]);
			
			int newX = Integer.parseInt(args[3]);
			int newY = Integer.parseInt(args[4]);
			
			BoardSpace space = Window.board.spaces[startX][startY];
			new Move(space.piece, space.piece.createTrains()).to(Window.board.spaces[newX][newY]);
		}
	}
}
