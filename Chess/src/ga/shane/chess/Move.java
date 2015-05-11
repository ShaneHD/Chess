package ga.shane.chess;

import java.util.List;

/** 
 * @author http://www.shane.ga
 */
public class Move {
	private final Piece piece;
	public final List<MoveTrain> trains;
	
	public Move(Piece piece, List<MoveTrain> trains) {
		this.trains = trains;
		this.piece = piece;
		
		for(MoveTrain train : trains) {
			//To prevent concurrent modification
			BoardSpace toCancel = null;
			
			for(BoardSpace space : train) {
				boolean containsEnemy = false;
				
				if((space.piece != null ? space.piece.side.equals(Side.turn) ? true : !(containsEnemy = true) : false)) {
					toCancel = space;
					break;
				}
				
				if(containsEnemy) {
					int index = train.indexOf(space) + 1;
					
					if(index < train.size())
						toCancel = train.get(index);
					
					break;
				}
			}
			
			if(toCancel != null)
				train.cancel(toCancel);
		}
	}
	
	//TODO move path per piece.
	//It will be like a train, 1 move -> next, etc. in order
	//Then you can cancel the rest of the train once you find a collision
	//Multiple trains for one move
	
	public void to(BoardSpace space) {
		
	}
}
