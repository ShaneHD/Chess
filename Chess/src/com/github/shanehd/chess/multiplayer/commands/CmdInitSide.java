package com.github.shanehd.chess.multiplayer.commands;

import com.github.shanehd.chess.Side;
import com.github.shanehd.utilities.net.Command;
import com.github.shanehd.utilities.net.NetworkHelper;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class CmdInitSide implements Command {

	@Override
	public void handle(NetworkHelper out, String command, String sub, String[] args) throws Exception {
		Side side = Side.valueOf(args[1]);
		Side.turn = side;
	}
}
