package ga.shane.chess.gui;

import ga.shane.chess.Player;
import ga.shane.chess.Side;
import ga.shane.chess.multiplayer.gui.Board;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Window extends JFrame {
	protected Board board;
	private static String title;
	private static Window instance;
	
	public Window() {
		this(new Board(), new Player());
	}
	
	public Window(Board board, Player player) {	
		super(title = "Chess" + (Side.only != null ? " [" + Side.only + "]" : ""));
		
		instance = this;
		updateTitle(Side.turn);
		
		BoardSpace.player = player;
		
		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());
		north.add(Side.GOLD.timer, BorderLayout.WEST);
		north.add(new TakenPieces(Side.GOLD));
		add(north, BorderLayout.NORTH);
		
		add(this.board = board, BorderLayout.CENTER);
		
		JPanel south = new JPanel();
		south.setLayout(new BorderLayout());
		south.add(Side.SILVER.timer, BorderLayout.WEST);
		south.add(new TakenPieces(Side.SILVER));
		add(south, BorderLayout.SOUTH);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(650, 650);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void updateTitle(Side side) {
		instance.setTitle(title + " - " + side + "'s turn");
	}
}
