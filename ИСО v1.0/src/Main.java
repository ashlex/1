
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Main implements ActionListener {
	JFrame jf;
	JButton b1,b2;
	JLabel l1,l2;
	inv inv;
	transp transp;
	public Main(){
		jf=new JFrame("Задачи ИСО");
		ImageIcon im=new ImageIcon("icon.png");
		jf.setIconImage(im.getImage());
		jf.setSize(800, 600);
		jf.setResizable(false);
		jf.setLayout(new GridLayout(5, 1, 5, 5));
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1=new JButton("<html><center>Инвестиционная<br>задача</center>");
		b2=new JButton("<html><center>Транспортная<br>задача</center>");
		b1.setActionCommand("inv");
		b1.addActionListener(this);
		b2.setActionCommand("transp");
		b2.addActionListener(this);
		jf.add(b1);
		jf.add(b2);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("inv")){
			inv=new inv("Инвестиционная задача");
		}
		if(e.getActionCommand().equals("transp")){
			transp=new transp("Транспортная задача");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Main();
			}
		});
	}

}
