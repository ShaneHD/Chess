package ga.shane.chess.multiplayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import ga.shane.chess.Side;
import ga.shane.chess.multiplayer.gui.Window;

public class MultiplayerGameServer {
	public static void main(String[] args) {
		System.out.println("hi");
		final int port = 13337;
		final String password = "cheSS893782Z36";
		final Side side = Side.GOLD;
		
		try {
			ServerSocket server = new ServerSocket(port);
			Net net = null;
			
			do {
				 Socket con = server.accept();
				 
				 DataInputStream in = new DataInputStream(con.getInputStream());
				 DataOutputStream out = new DataOutputStream(con.getOutputStream());
				 
				 String request = in.readUTF();
				 
				 if(!request.equals(password)) {
					 System.err.println("Unauthorised connection, password requested was \"" + request + "\"");
					 con.close();
					 continue;
				 }
				 
				 Side.only = side;
				 net = new Net(in, out);
			} while(net == null);
			
			System.out.println("GOT, OPEN WOINDOW");
			new Window();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
