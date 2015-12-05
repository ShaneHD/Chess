package com.github.shanehd.chess.multiplayer.commands;

import com.github.shanehd.chess.Side;
import com.github.shanehd.utilities.net.Command;
import com.github.shanehd.utilities.net.NetworkHelper;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class CmdUpdateTimer implements Command {

	@Override
	public void handle(NetworkHelper out, String command, String sub, String[] args) throws Exception {
		//TODO sync up from the beginning (start at same time)
		Side side = Side.valueOf(args[1]);
		String info = args[2];
		side.timer.fromString(info);
	}
}
