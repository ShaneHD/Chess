package ga.shane.chess.multiplayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import ga.shane.chess.Side;
import ga.shane.chess.multiplayer.gui.Window;
import ga.shane.utilities.PCUtils;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class MultiplayerGameClient {
	public static void main(String[] args) {
		final String ip = "localhost";
		final int port = 13337;
		final String password = "cheSS893782Z36";
		final Side side = Side.SILVER;
		
		Socket server;
		try {
			server = new Socket(ip, port);
			DataInputStream in = new DataInputStream(server.getInputStream());
			DataOutputStream out = new DataOutputStream(server.getOutputStream());
			
			Side.only = side;
			Net net = new Net(in, out);
			net.write(password);
			
			new Window();
		} catch(Exception e) {	
			PCUtils.globalMessagebox("Can't connect to server, closing", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
