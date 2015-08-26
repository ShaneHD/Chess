package ga.shane.chess.multiplayer;

import ga.shane.chess.BoardSpace;
import ga.shane.chess.MoveTrain;

public class Player extends ga.shane.chess.Player {
	@Override
	protected void onMove(BoardSpace from, BoardSpace to) {
		try {
			Net.instance.write("move", "" + from.x, "" + from.y, "" + to.x, "" + to.y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onPickup(BoardSpace space, MoveTrain... trains) {
		try {
			for(MoveTrain train : trains) {
				Net.instance.write("movestate", "true", "" + space.x, "" + space.y, train.toStr());
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
