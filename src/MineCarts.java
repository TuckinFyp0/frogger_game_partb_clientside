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
