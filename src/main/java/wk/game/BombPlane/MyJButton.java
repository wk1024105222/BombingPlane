package wk.game.BombPlane;

import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class MyJButton extends JButton{
	int number;
	
	MyJButton(int i,ImageIcon im) {	
		super(im);
		number = i;
	}

}
