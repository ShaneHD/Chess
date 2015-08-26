package ga.shane.chess.multiplayer;

import java.util.logging.Logger;

import ga.shane.chess.multiplayer.commands.CmdInitSide;
import ga.shane.chess.multiplayer.commands.CmdMove;
import ga.shane.chess.multiplayer.commands.CmdMoveState;
import ga.shane.utilities.net.NetworkHelper;

public class PacketHandler extends ga.shane.utilities.net.PacketHandler {
	{
		commands.put("move", new CmdMove());
		commands.put("movestate", new CmdMoveState());
		commands.put("initside", new CmdInitSide());
	}
	
	public PacketHandler(NetworkHelper out, Logger log) {
		super(out, log);
	}
}
