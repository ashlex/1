//import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



class Main implements ActionListener{
	JTextField t1;
	JLabel l1=new JLabel();
	JButton b1,b2;
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Main("Chat_1");
			}
		});
	}
	Main(String s){
		JFrame jf=new JFrame(s);
		jf.setLayout(new FlowLayout());
		jf.setSize(200, 400);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t1=new JTextField(10);
		t1.setActionCommand("Go");
		t1.addActionListener(this);
		t1.setSize(100, 30);
		b1=new JButton("Go");
		b2=new JButton("New_Window");
		b1.addActionListener(this);
		b2.addActionListener(this);
		Dimension g=new Dimension(100, 200);
		l1=new JLabel("Привет", SwingConstants.CENTER);
		l1.setVerticalAlignment(SwingConstants.BOTTOM);
		l1.setPreferredSize(g);
		l1.setBorder(BorderFactory.createEtchedBorder());
		//for(int i=1;i<5;i++){
		//l1[i]=new JLabel("t", SwingConstants.CENTER);
		//l1[i].setPreferredSize(g);
		//l1[i].setBorder(BorderFactory.createEtchedBorder());
		//}
		jf.add(t1);
		jf.add(b1);
		jf.add(l1);
		jf.add(b2);
		//for(int i=0;i<5;i++){
		//jf.add(l1[i]);
		//}
	}
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Go")){
			l1.setText("<html>"+l1.getText()+"<br><br>"+t1.getText());
			t1.setText("");
			//l1[0].setEnabled();
		}
		if(e.getSource()==b2){
			new Main("Chat_2");
		}
	}	
}