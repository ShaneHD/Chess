package ga.shane.chess.multiplayer;

import ga.shane.chess.MoveTrain;
import ga.shane.chess.Side;
import ga.shane.chess.gui.BoardSpace;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Player extends ga.shane.chess.Player {
	@Override
	protected void onMove(BoardSpace from, BoardSpace to) {
		try {
			Net.instance.write("move", "" + from.x, "" + from.y, "" + to.x, "" + to.y);
			Net.instance.write("updatetimer", Side.turn.toString(), Side.turn.timer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onPickup(BoardSpace space, MoveTrain... trains) {
		try {
			for(MoveTrain train : trains) {
				Net.instance.write("movestate", "true", "" + space.x, "" + space.y, train.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onPutdown() {
		try {
			Net.instance.write("movestate", "false");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
