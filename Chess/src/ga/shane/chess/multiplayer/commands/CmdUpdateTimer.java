package ga.shane.chess.multiplayer.commands;

import ga.shane.chess.Side;
import ga.shane.utilities.net.Command;
import ga.shane.utilities.net.NetworkHelper;

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
