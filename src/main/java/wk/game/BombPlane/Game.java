package wk.game.BombPlane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Game {
	PlaneMap planeMap = new PlaneMap();		//游戏地图
	int destoryPlaneNumber = 0;          //击毁数目
	int shootNumber = 0;                  //射击次数    排名用
	boolean isStart = true;                //射击第一次时开始计时  以后射击变false
	String palyerName = new String();            //玩家姓名

	JFrame frame = new JFrame("炸飞机");
	JPanel p = new JPanel();

	Box box = Box.createHorizontalBox();
	JLabel label1 = new JLabel("击毁数目");
	JLabel label2 = new JLabel("射击次数");
	JTextField showDestoryPlaneNumber = new JTextField(3);
	JTextField showShootNumber = new JTextField(3);
	JButton reStart = new JButton("开局");
	JButton help = new JButton("帮助");
	JButton introduction = new JButton("说明");

	JPanel p1 = new JPanel();
	ArrayList<MyJButton> mapNodes = new ArrayList<MyJButton>();
	MyJButtonListener mbl = new MyJButtonListener();
	Game() {
		p.setLayout(null);

		p.add(box);
		box.setAlignmentY(Component.LEFT_ALIGNMENT);
		box.setBounds(20, 10, 440, 30);

		showDestoryPlaneNumber.setEditable(false);
		box.add(this.label1);
		showDestoryPlaneNumber.setFont(new Font("楷体_gb2312",Font.BOLD,25));
		showDestoryPlaneNumber.setForeground(Color.blue);
		box.add(this.showDestoryPlaneNumber);
		box.add(Box.createHorizontalStrut(10));

		showShootNumber.setEditable(false);
		box.add(this.label2);
		showShootNumber.setFont(new Font("楷体_gb2312",Font.BOLD,25));
		showShootNumber.setForeground(Color.black);
		box.add(this.showShootNumber);
		box.add(Box.createHorizontalStrut(10));

		this.reStart.addActionListener(new JButtonListener());
		box.add(this.reStart);
		box.add(Box.createHorizontalStrut(10));
		this.help.addActionListener(new JButtonListener());
		box.add(this.help);
		box.add(Box.createHorizontalStrut(10));
		this.introduction.addActionListener(new JButtonListener());
		box.add(this.introduction);


		p.add(p1);
		p1.setLayout(new FlowLayout((int) Component.LEFT_ALIGNMENT,10,10));
		p1.setBounds(10, 50, 460, 460);
		for(int i=0; i!=100; i++) {
			MyJButton b = new MyJButton(i,new ImageIcon(this.getClass().getClassLoader().getResource("image/init.gif").getPath()));
			b.addMouseListener(mbl);
			mapNodes.add(b);
			p1.add(b);
			b.setPreferredSize(new Dimension(35,35));
		}


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,490,555 );
		frame.setContentPane(p);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.validate();
	}

	class MyJButtonListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			MyJButton b = (MyJButton)e.getSource();
			if(e.getModifiers() == InputEvent.BUTTON1_MASK) {   //按下左键
				Integer i = new Integer(b.number);
				if ((planeMap.onePlane.head == b.number) || (planeMap.twoPlane.head == b.number) || (planeMap.threePlane.head == b.number)) {
					if(planeMap.onePlane.head == b.number) {
						planeMap.onePlane.isAlive = false;
					} else if(planeMap.twoPlane.head == b.number) {
						planeMap.twoPlane.isAlive = false;
					} else if(planeMap.threePlane.head == b.number) {
						planeMap.threePlane.isAlive = false;
					}
					b.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("image/hithead.gif").getPath()));
					showDestoryPlaneNumber.setText((++destoryPlaneNumber)+"");
					b.removeMouseListener(mbl);
				} else if ((planeMap.onePlane.body.contains(i)) || (planeMap.twoPlane.body.contains(i)) || (planeMap.threePlane.body.contains(i))) {
					b.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("image/hitbody.gif").getPath()));
					b.removeMouseListener(mbl);
				} else {;
					b.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("image/empty.gif").getPath()));
					b.removeMouseListener(mbl);
				}
				showShootNumber.setText((++shootNumber)+"");
				if(destoryPlaneNumber == 3) {
					JOptionPane.showMessageDialog(frame, "战斗结束。\n用了" + shootNumber + "发子弹");
					for(int j=0; j!=mapNodes.size(); j++) {
						MyJButton temp = (MyJButton)mapNodes.get(j);
						if(temp.getMouseListeners() != null) {
							temp.removeMouseListener(mbl);
						}
					}
				}
			} /*else if (e.getModifiers() == InputEvent.BUTTON3_MASK) {           //按下右键
				if(b.getIcon().toString().equals("init.gif")) {
					b.setIcon(new ImageIcon("可能头.gif"));
				} else if (b.getIcon().toString().equals("可能头.gif")) {
					b.setIcon(new ImageIcon("可能身.gif"));
				} else if (b.getIcon().toString().equals("可能身.gif")) {
					b.setIcon(new ImageIcon("可能空.gif"));
				} else if (b.getIcon().toString().equals("可能空.gif")) {
					b.setIcon(new ImageIcon("init.gif"));
				}
			}*/
		}

	}

	class JButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == reStart) {
				reStartGame();
			} else if(e.getSource() == help){
				gameHelp();
			} else if(e.getSource() == introduction) {
				new Introduction();
			}
		}

		void gameHelp() {
			if((planeMap.onePlane.isAlive == false) && (planeMap.onePlane.hasShowAll == false)) {  //头已打中
				for(int i=0; i!=planeMap.onePlane.body.size(); i++) {
					mapNodes.get(planeMap.onePlane.body.get(i).intValue()).setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("image/hitbody.gif").getPath()));
				}
				planeMap.onePlane.hasShowAll = true;
			} else if((planeMap.twoPlane.isAlive == false) && (planeMap.twoPlane.hasShowAll == false)) {
				for(int i=0; i!=planeMap.twoPlane.body.size(); i++) {
					mapNodes.get(planeMap.twoPlane.body.get(i).intValue()).setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("image/hitbody.gif").getPath()));
				}
				planeMap.twoPlane.hasShowAll = true;
			} else if((planeMap.threePlane.isAlive == false) && (planeMap.threePlane.hasShowAll == false)) {
				for(int i=0; i!=planeMap.threePlane.body.size(); i++) {
					mapNodes.get(planeMap.threePlane.body.get(i).intValue()).setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("image/hitbody.gif").getPath()));
				}
				planeMap.threePlane.hasShowAll = true;
			}
		}

		void reStartGame() {
			planeMap = new PlaneMap();
			destoryPlaneNumber = 0;
			showDestoryPlaneNumber.setText("");
			shootNumber = 0;
			showShootNumber.setText("");
			for(int i=0;i!=mapNodes.size(); i++) {
				MyJButton b = (MyJButton)mapNodes.get(i);
				b.removeMouseListener(mbl);
				b.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("image/init.gif").getPath()) );
				b.addMouseListener(mbl);
			}
		}
	}


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("unused")

		Game g = new Game();

	}
}
