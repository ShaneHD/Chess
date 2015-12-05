package com.github.shanehd.chess.multiplayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.github.shanehd.chess.Side;
import com.github.shanehd.chess.multiplayer.gui.Window;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class MultiplayerGameServer {
	public static void main(String[] args) {
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
				 net.write("initside", Side.turn.toString());
			} while(net == null);
			
			new Window();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
