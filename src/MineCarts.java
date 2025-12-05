import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MineCarts extends SpriteMiner {

	private JLabel mineCartLabel;
	
	public MineCarts() {
		super();
		this.mineCartLabel = null;

	}
	
	public MineCarts(int x, int y, int width, int height, String image) {
		super(x, y, width, height, image);

		this.mineCartLabel = null;
	
	}

	public JLabel getMineCartLabel() {
		return mineCartLabel;
	}

	public void setMineCartLabel(JLabel mineCartLabel) {
		this.mineCartLabel = mineCartLabel;
	}


    public void updatePositionFromServer(int x, int y) {
        setX(x);
        setY(y);
        if (mineCartLabel != null) {
            mineCartLabel.setLocation(x, y);
        }
    }
}
//	@Override
//	public void run() {
//				
//		while(moving) {
//		
//			int x = this.x;
//			
//			x += MinerGameProperties.CHARACTER_STEP * direction;
//			
//			this.setX(x);
//			
//			if (direction > 0) { 
//				if (x >= MinerGameProperties.SCREEN_WIDTH) {
//					this.setX(-1 * this.width);
//				}
//			} else { 
//				if (x + this.width <= 0) {
//					this.setX(MinerGameProperties.SCREEN_WIDTH);
//				}
//			}
//			
//			mineCartLabel.setLocation(this.x, this.y);
//			
//			this.detectCollision();
//			
//			try {
//				Thread.sleep(speed);
//			} catch (InterruptedException e) {
//				Thread.currentThread().interrupt();
//				break;
//			}
//		}
//		
//	}
//	
//	// Start thread function - Starts the mine cart movement thread
//	public void startThread() {
//		if ( !this.moving ) {
//			this.moving = true;
//			t = new Thread(this, "MineCart movement thread");
//			t.start();
//		}
//	}
//	
//	// Stop thread Function - Stops the mine cart movement thread
//	public void stopThread() {
//		if ( t != null ) {
//			this.moving = false;
//			t.interrupt();
//		}
//	}
//	
//	// Detects collision Function - Detects collision with miner and starts gameOver() function if checks are met. Padding used to 
//	// fix the offset due to image scaling issues.
//	private void detectCollision() {
//		
//		if (mineCartLabel == null || minerLabel == null || miner == null) {
//			return;
//		}
//		
//		int cartHorizontalPadding = 8;
//        int cartTopPadding = 55;
//        int cartBottomPadding = 10;
//
//        int minerHorizontalPadding = 40;
//        int minerTopPadding = 45;
//        int minerBottomPadding = 35;
//
//	    Rectangle mineCartRect = new Rectangle(
//	        mineCartLabel.getX() + cartHorizontalPadding,
//	        mineCartLabel.getY() + cartTopPadding,
//	        mineCartLabel.getWidth() - (cartHorizontalPadding * 2),
//	        mineCartLabel.getHeight() - cartTopPadding - cartBottomPadding
//	    );
//
//	    Rectangle minerRect = new Rectangle(
//	        miner.getX() + minerHorizontalPadding,
//	        miner.getY() + minerTopPadding,
//	        miner.getWidth() - (minerHorizontalPadding * 2),
//	        miner.getHeight() - minerTopPadding - minerBottomPadding
//	    );
//		
//		if (mineCartRect.intersects(minerRect)) {
//			this.moving = false;
//			game.gameOver();
//		}
//		
//	}
//}
