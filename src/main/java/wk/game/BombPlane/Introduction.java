package wk.game.BombPlane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Introduction extends JDialog {
	Container container = this.getContentPane();

	JTabbedPane jTabledPane = new JTabbedPane();
	JPanel childJPanel1 = new JPanel();
	JPanel childJPanel2 = new JPanel();
	JPanel childJPanel3 = new JPanel();

	JTextArea area1 = new JTextArea(5,20);
	JTextArea area2 = new JTextArea(5,20);
	JLabel label = new JLabel(new ImageIcon("炸飞机.jpg"));

	Introduction() {
		this.setTitle("炸飞机简介");
		this.setBounds(200, 200, 300, 200);
		//this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		String s1 = new String("1：在10*10的方格中 ，分布着三架飞机，机首占1格，机翼占5格，机身占1格，机尾占3格，" +
				"左键单击选中射击部位，击中机首飞机坠毁，击中其他部位算受伤，全部击毁游戏胜利。\n" +
				"\n2：射击总次数为最终得分。\n" +
				"\n3：以此纪念初中那段上课在纸上偷偷玩炸飞机的日子。\n\n");
		String s2 = new String("小游戏炸飞机V1.0\n\n制作人：王凯\n\nQQ：1024105222" +
				"\n\n邮箱：wangkai_1437@sina.com\n\n哈尔滨理工大学\n\n2010.3.13\n\n");

		area1.setText(s1);
		area1.setSize(300, 200);
		area1.setEditable(false);
		area1.setLineWrap(true);
		area1.setFont(new Font("楷体_GB2312",Font.PLAIN,20));
		area1.setForeground(Color.blue);

		area2.setText(s2);
		area2.setSize(300, 200);
		area2.setEditable(false);
		area2.setLineWrap(true);
		area2.setFont(new Font("楷体_GB2312",Font.PLAIN,20));
		area2.setForeground(Color.blue);

		childJPanel1.add(area1);
		childJPanel2.add(label);
		childJPanel3.add(area2);

		jTabledPane.setSize(300, 300);
		jTabledPane.addTab("分割说明", null, childJPanel1);
		jTabledPane.addTab("游戏示图", null, childJPanel2);
		jTabledPane.addTab("版权声明", null, childJPanel3);

		container.add(jTabledPane);
		this.pack();
		this.setVisible(true);

	}
}
