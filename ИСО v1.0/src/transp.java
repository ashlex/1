import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class transp {
	JFrame jf;
	JPanel pan1,pan2,pan3;
	JScrollPane pan;
	JLabel l1[];
	JTextField tf1[];
	JButton b1,b2;
	
	int z, N, x=5, y=5,x1,y1;

	control control=new control();
	
	transp(String s){
		jf=new JFrame(s);
		jf.setSize(300, 300);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
		l1=new JLabel[2];
		l1[0]=new JLabel("Количество передающих:");
		l1[0].setLocation(5, 5);
		l1[0].setSize(200, 20);
		l1[0].setVerticalAlignment(SwingConstants.CENTER);
		l1[1]=new JLabel("Количество принимающих:");
		l1[1].setLocation(5, 30);
		l1[1].setSize(200, 20);
		l1[1].setVerticalAlignment(SwingConstants.CENTER);
		
		tf1=new JTextField[2];
		tf1[0]=new JTextField();
		tf1[0].setLocation(200, 5);
		tf1[0].setSize(30, 20);
		tf1[1]=new JTextField();
		tf1[1].setLocation(200, 30);
		tf1[1].setSize(30, 20);
		
		b1=new JButton("Принять");
		b1.setLocation(130, 65);
		b1.setSize(100, 25);
		b1.addActionListener(control);
		
		
		pan1=new JPanel();
		pan1.setPreferredSize(new Dimension(250, 130));
		pan1.setLayout(null);
		pan1.setOpaque(true);
		pan1.add(l1[0]);
		pan1.add(l1[1]);
		pan1.add(tf1[0]);
		pan1.add(tf1[1]);
		pan1.add(b1);
		
		
		
		pan=new JScrollPane();
		pan.setViewportView(pan1);
		jf.add(pan);
	}
	class control implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				if(e.getSource()==b1){
					z=Integer.parseInt(tf1[0].getText()+"");
					N=Integer.parseInt(tf1[1].getText()+"");
					Constr_Table_input();
					pan.setViewportView(pan2);
				}
			}catch(Exception ex){JOptionPane.showMessageDialog(null, "Введите число");}
		}
		private void Constr_Table_input(){
			JLabel l2[]=new JLabel[z];
			JLabel l3[]=new JLabel[N];
			JTextField tf2[][]=new JTextField[z+1][N+1];
			pan2=new JPanel();
			pan2.setLayout(null);
			for(int i=0;i<N;i++){
				x=x+40;
				l3[i]=new JLabel("<html>B<sub>"+(i+1)+"</sub>", SwingConstants.CENTER);
				l3[i].setLocation(x, y);
				l3[i].setSize(40, 20);
				pan2.add(l3[i]);
			}
			x=5;
			for(int i=0;i<z;i++){
				y=y+20;
				l2[i]=new JLabel("<html>A<sub>"+(i+1)+"</sub>");
				l2[i].setLocation(x, y);
				l2[i].setSize(40, 20);
				l2[i].setVerticalAlignment(SwingConstants.CENTER);
				pan2.add(l2[i]);
			}
			y=5;
			for(int i=0;i<z+1;i++){
				y=y+20;
				for(int j=0;j<N+1;j++){
					x=x+40;
					tf2[i][j]=new JTextField();
					tf2[i][j].setLocation(x, y);
					tf2[i][j].setSize(40 ,20);
					if(i!=z || j!=N){
						pan2.add(tf2[i][j]);
					}
				}
				x1=x;
				y1=y;
				x=5;
			}
			pan2.setPreferredSize(new Dimension(x1+60,y1+100));
			pan2.setOpaque(true);
			b2=new JButton("Принять");
			b2.setLocation(x1-60, y1+35);
			b2.setSize(100, 25);
			b2.addActionListener(control);
			pan2.add(b2);
		}
		
	}

}
