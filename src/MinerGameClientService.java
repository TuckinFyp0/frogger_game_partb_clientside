import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MinerGameClientService implements Runnable {

	private Socket s;
	private Scanner in;
	private ClientPrep client;

	
	public MinerGameClientService(Socket aSocket, ClientPrep client) {
		this.s = aSocket;
		this.client = client;
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
		//if next request is empty then return
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
			client.updateMinerPosition(x, y);
			
		} else if (command.equals("STONE")) {
			client.updateStonePosition(id, x, y);
			
		} else if (command.equals("MINECART")) {
			client.updateMineCartPosition(id, x, y);
			
		}
	}
	
}
