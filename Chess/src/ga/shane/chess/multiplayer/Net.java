package ga.shane.chess.multiplayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ga.shane.utilities.PCUtils;
import ga.shane.utilities.net.Command;
import ga.shane.utilities.net.NetworkHelper;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Net extends NetworkHelper.DataStreamNetworkHelper implements Runnable {
	public static Net instance;
	private final PacketHandler handler;
	
	public Net(DataInputStream input, DataOutputStream output) {
		super(input, output);
		handler = new PacketHandler(this, Logger.getLogger("Chess"));
		instance = this;
		new Thread(this).start();
	}

	private synchronized void close() {
		 try {
			input.close();
			output.close();
			System.exit(0);
		 } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String in = input.readUTF();
				
				if(in.contains(Command.SEPARATOR))
					handler.handle(in.split(Command.SEPARATOR)[0], in.split(Command.SEPARATOR));
				else
					handler.handle(in);
			} catch(Exception e) {
				e.printStackTrace();
				PCUtils.globalMessagebox("Error, multiplayer game must exit. Info: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
		close();
	}
}
