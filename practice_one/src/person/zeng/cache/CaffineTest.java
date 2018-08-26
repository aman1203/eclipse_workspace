package person.zeng.cache;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CaffineTest{
	public static void main(String[] args) {
		JFrame jframe = new JFrame("zengjie");
		Container c = new Container();
		jframe.add(c);
		c.setLayout(new GridLayout(10, 10));
		ActionListener action = (e) -> {
			if (e.getSource() instanceof JButton) {
				JButton jb = (JButton) e.getSource();
				
			}
		};
		for (int i = 0; i < 100; i++) {
			JButton jb1 = new JButton();
			jb1.setBackground(new Color(238,238,238));
			jb1.setEnabled(false);
			jb1.addActionListener(action);
			c.add(jb1);
		}

		jframe.setLocation(500, 200);
		jframe.setDefaultCloseOperation(3);
		jframe.setVisible(true);

		while (true) {
			Component[] componet = c.getComponents();
			changeColor(componet);
		}
	}
	
	static void changeColor(Component[] componet) {
		Random r = new Random();
		int index = r.nextInt(componet.length);
		Arrays.asList(componet)
		.stream()
		.filter((item)->item.getBackground().getRed()==230)
		.forEach((x)->x.setBackground(new Color(238,238,238)));
		
		try {
			componet[index].setBackground(new Color(230,0,0));
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
