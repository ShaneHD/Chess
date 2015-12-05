package com.github.shanehd.chess.multiplayer;

import java.util.logging.Logger;

import com.github.shanehd.chess.multiplayer.commands.CmdInitSide;
import com.github.shanehd.chess.multiplayer.commands.CmdMove;
import com.github.shanehd.chess.multiplayer.commands.CmdMoveState;
import com.github.shanehd.chess.multiplayer.commands.CmdUpdateTimer;
import com.github.shanehd.utilities.net.NetworkHelper;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class PacketHandler extends com.github.shanehd.utilities.net.PacketHandler {
	{
		commands.put("move", new CmdMove());
		commands.put("movestate", new CmdMoveState());
		commands.put("initside", new CmdInitSide());
		commands.put("updatetimer", new CmdUpdateTimer());
	}
	
	public PacketHandler(NetworkHelper out, Logger log) {
		super(out, log);
	}
}
