package ga.shane.chess.multiplayer.commands;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.MoveTrain;
import ga.shane.chess.multiplayer.Player;
import ga.shane.chess.multiplayer.gui.Window;
import ga.shane.utilities.net.Command;
import ga.shane.utilities.net.NetworkHelper;

public class CmdMoveState implements Command {

	@Override
	public void handle(NetworkHelper out, String command, String sub, String[] args) throws Exception {
		boolean state = Boolean.parseBoolean(args[1]);
		
		if(state) {
			int x = Integer.parseInt(args[2]);
			int y = Integer.parseInt(args[3]);
						
			BoardSpace space = Window.board.spaces[x][y];
			Player.highlightSelectedSpace(space);

			
			if(args.length < 5)
				return;
			
			MoveTrain train = MoveTrain.fromString(args[4]);
			Player.highlightMove(train);
		} else {
			Player.unhighlightMove();
		}
	}
}
