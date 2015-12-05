package com.github.shanehd.chess.multiplayer.commands;

import com.github.shanehd.chess.MoveTrain;
import com.github.shanehd.chess.gui.BoardSpace;
import com.github.shanehd.chess.multiplayer.Player;
import com.github.shanehd.chess.multiplayer.gui.Window;
import com.github.shanehd.utilities.net.Command;
import com.github.shanehd.utilities.net.NetworkHelper;

/** 
 * @author https://www.github.com/ShaneHD
 */
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
