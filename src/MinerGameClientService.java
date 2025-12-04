import java.awt.Component;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JLabel;

public class MinerGameClientService implements Runnable {

	private Socket s;
	private Scanner in;
	private Miner miner;
	private JLabel lblMiner;

	
	public MinerGameClientService(Socket aSocket, Miner miner, JLabel lblMiner) {
		this.s = aSocket;
		this.miner = miner;
		this.lblMiner = lblMiner;
	}

	public void run() {
		
		try {
			in = new Scanner(s.getInputStream());
			processRequest( );
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void processRequest () throws IOException {
		
		while(true) {
			if(!in.hasNext( )){
				return;
			}
			String command = in.next();
			if (command.equals("Quit")) {
				return;
			} else {
				executeCommand(command);
			}
		}
	}
	
	public void executeCommand(String command) throws IOException{
		
		int id = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
	
		if ( command.equals("MINER")) {
			miner.setX(x);
			miner.setY(y);
			lblMiner.setLocation(miner.getX(), miner.getY());
			
		} else if (command.equals("STONE")) {
			
			
		} else if (command.equals("MINECART")) {
			
			
		}
	}
	
}
