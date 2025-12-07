import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;

public class movingStones extends SpriteMiner {

	private Boolean moving;
	private Thread t;
	private JLabel stoneLabel;
	private JButton startButton;
	
	private Miner miner;
	private JLabel minerLabel;
	private int speed;
	private int direction;
	
	public movingStones() {
		super();
		this.moving = false;
		this.stoneLabel = null;
		this.startButton = null;
		
		this.miner = null;
		this.minerLabel = null;
		this.speed = 300;
		this.direction = 1;
		
	}
	
	public movingStones(int x, int y, int width, int height, String image, Boolean moving) {
		super(x, y, width, height, image);
		
		this.moving = moving;
		this.stoneLabel = null;
		this.startButton = null;
		this.miner= null;
		this.minerLabel= null;
		this.speed = 300;
		this.direction = 1;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
	public Boolean getMoving() {
		return moving;
	}

	public void setMoving(Boolean moving) {
		this.moving = moving;
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}

	public JLabel getStoneLabel() {
		return stoneLabel;
	}

	public void setStoneLabel(JLabel stoneLabel) {
		this.stoneLabel = stoneLabel;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}

	public Miner getMiner() {
		return miner;
	}

	public void setMiner(Miner miner) {
		this.miner = miner;
	}

	public JLabel getMinerLabel() {
		return minerLabel;
	}

	public void setMinerLabel(JLabel minerLabel) {
		this.minerLabel = minerLabel;
	}
}
