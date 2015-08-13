package ga.shane.chess.multiplayer;

import java.util.logging.Logger;

import ga.shane.chess.multiplayer.commands.CmdMove;
import ga.shane.utilities.net.NetworkHelper;

public class PacketHandler extends ga.shane.utilities.net.PacketHandler {
	{
		commands.put("move", new CmdMove());
	}
	
	public PacketHandler(NetworkHelper out, Logger log) {
		super(out, log);
	}
}
