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
    private MineCarts[] mineCartsArray;
    private JLabel[] lblMineCarts;

	
	public MinerGameClientService(Socket aSocket, Miner miner, JLabel lblMiner, MineCarts[] mineCartsArray, JLabel[] lblMineCarts) {
		this.s = aSocket;
		this.miner = miner;
		this.lblMiner = lblMiner;
        this.mineCartsArray = mineCartsArray;
        this.lblMineCarts = lblMineCarts;
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
	
		if ( command.equals("MINER")) {

            int x = in.nextInt();
            int y = in.nextInt();
			miner.setX(x);
			miner.setY(y);
			lblMiner.setLocation(miner.getX(), miner.getY());
			
		} else if (command.equals("STONE")) {
			
			
		} else if (command.equals("MINECART")) {
			int index = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            mineCartsArray[index].setX(x);
            mineCartsArray[index].setY(y);
            lblMineCarts[index].setLocation(x, y);
		}
	}
	
}
