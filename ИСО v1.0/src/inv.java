import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class inv extends JFrame{
	JFrame jf;
	JPanel pan1,pan2,pan3;
	JScrollPane pan;
	JLabel[] l1= new JLabel[3];
	JLabel[] l2,l3;
	JLabel[][] res;
	JTextField[] tf1=new JTextField[3];
	JTextField[][] mm;
	JButton b1,b2,b3;

	long c=0;
	int N=0,z=0,y5;
	int x=5,y=5,x1,y1,q=0;
	int y3[][];
	double[][] m,y4,result;
	double m1,m2,h[];
	byte k=1;
	
	control control=new control();
	inv(String s){
		jf=new JFrame(s);
		jf.setSize(400, 500);
		jf.setLocationRelativeTo(null);
		ImageIcon im=new ImageIcon("icon1.png");
		jf.setIconImage(im.getImage());
		
		l1[0]= new JLabel("Количество ресурсов");
		l1[1]= new JLabel("Количество программ");
		l1[2]= new JLabel("Количество z");
		
		tf1[0]= new JTextField();
		tf1[1]= new JTextField();
		tf1[2]= new JTextField();
		
		b1=new JButton("Принять");
		b1.addActionListener(control);

		b2=new JButton("Принять");
		b2.addActionListener(control);

		pan1=new JPanel();
		pan1.setPreferredSize(new Dimension(220, 120));
		pan1.setLayout(null);
		pan1.setOpaque(true);
		
		pan2=new JPanel();
		pan2.setLayout(null);
		pan2.setOpaque(true);

		pan3=new JPanel();
		pan3.setLayout(null);
		pan3.setOpaque(true);
		
		pan=new JScrollPane();
		pan.setViewportView(pan1);
		
		pan1.add(l1[0]);
		pan1.add(tf1[0]);
		pan1.add(l1[1]);
		pan1.add(tf1[1]);
		pan1.add(l1[2]);
		pan1.add(tf1[2]);
		pan1.add(b1);

		l1[0].setLocation(5, 5);
		l1[0].setSize(150, 20);
		tf1[0].setLocation(170, 5);
		tf1[0].setSize(40, 20);

		l1[1].setLocation(5, 30);
		l1[1].setSize(150, 20);
		tf1[1].setLocation(170, 30);
		tf1[1].setSize(40, 20);

		l1[2].setLocation(5, 55);
		l1[2].setSize(150, 20);
		tf1[2].setLocation(170, 55);
		tf1[2].setSize(40, 20);
		
		b1.setLocation(110, 85);
		b1.setSize(100, 25);
		
		jf.add(pan);
		jf.setVisible(true);
	}
	class control implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
			if(e.getSource()==b1){
				c=Long.parseLong(tf1[0].getText());
				N=Integer.parseInt(tf1[1].getText());
				z=Integer.parseInt(tf1[2].getText());
				Constr_Table_input();
				pan.setViewportView(pan2);
			}
			if(e.getSource()==b2){
				inp();
				mat();
				end();
				pan.setViewportView(pan3);
				q=1;
			}
			if(e.getSource()==b3){
				JFrame jfHOME=new JFrame();
				jfHOME.setSize(300, 500);
				jfHOME.setLayout(new FlowLayout());
				jfHOME.setLocationRelativeTo(null);
				jfHOME.add(pan1);
				if(q!=0){
					jfHOME.add(pan2);
					b2.setEnabled(false);
					b2.setVisible(false);
					jfHOME.add(pan3);
					b2.setEnabled(false);
					b2.setVisible(false);
				}
				jfHOME.setVisible(true);
				tf1[0].setEnabled(false);
				tf1[1].setEnabled(false);
				tf1[2].setEnabled(false);
				b1.setEnabled(false);
				b1.setVisible(false);
			}
			}catch(Exception xe){JOptionPane.showMessageDialog(null, "Введите число!");}
		}
		public void mat() {//считаем и заполняем промежуточные матрицы
			int xk[][]=new int[N+1][z];
			int p=z;
			double fk[][][]=new double[N+1][z][p];
			h=new double[z];
			y3=new int[N+1][p];//Индекс максимального значения
			y4=new double[N+1][p];//Максимальное значение
			k=0;
			
			for(int i=0;i<p;i++){
				for(int j=0;j<p;j++){
					fk[k][i][j]=0;
					xk[k][i]=0;
					h[j]=fk[k][i][j];
				}
				extrem();
				y3[k][i]=y5;
				y4[k][i]=m2;
			}
				
			for(int l=1;l<N+1;l++){
					/*
					 * В ЭТОМ ЦИКЛЕ ШАГИ ОТ 1 ДО N ПОДСЧЁТА ОПТИМАЛЬНОЙ 
					 * ИНВЕСТИЦИИ РЕСУРСОВ В ПОСЛЕДНЮЮ ПРОГРАММУ
					 */
				for(int i=0;i<p;i++){
					for(int j=0;j<i+1;j++){
						xk[l][j]=j;
					}
					for(int j=0;j<p;j++){
						if(j<i+1){
						fk[l][i][j]=((m[xk[l][j]][l-1])+(fk[l-1][i-xk[l][j]][y3[l-1][i-j]]));
						}
						if(j>i+1){
							fk[l][i][j]=0;
						}
						h[j]=fk[l][i][j];
					}
					extrem();
					y3[l][i]=y5;
					y4[l][i]=m2;
				}
			}
		}
		public void extrem(){//поиск максимума из множества элементов
			m1=h[0];
			m2=h[0];
			for(int i=0;i<h.length;i++){
				if(h[i]<m1){
					m1=h[i];				
			    }
				if(h[i]>m2){
					m2=h[i];
				}
			}
			q1:
			for(int i=0;i<h.length;i++){
				if(m2==h[i]){
					y5=i;
					break q1;
				}
			}
			return;
		}
		public void Constr_Table_input(){
			l2=new JLabel[N+1];
			l3=new JLabel[z];
			mm=new JTextField[z][N];
			for(int i=-1;i<z;i++){
				if(i!=-1){
					l3[i]=new JLabel(i+"");
					pan2.add(l3[i]);
					l3[i].setLocation(5, y);
					l3[i].setSize(30, 20);
				}
				for(int j=0;j<N+1;j++){
					if(i==-1){
						if(j==0){
							l2[j]=new JLabel("");
							pan2.add(l2[j]);
							l2[j].setLocation(x, y);
							l2[j].setSize(28, 20);
						}
						if(j!=0){
							l2[j]=new JLabel("<html>r<sub>"+(j)+"</sub>(x)");
						pan2.add(l2[j]);
						l2[j].setLocation((x-5), y);
						l2[j].setSize(30, 20);
						}
					}
					if(i!=-1 & j!=N){
						mm[i][j]=new JTextField();
						pan2.add(mm[i][j]);
						mm[i][j].setLocation(x, y);
						mm[i][j].setSize(30, 20);
					}
					x=x+35;
					x1=x;
				}
				x=35;
				y=y+25;
				y1=y;
			}
			y=5;
			pan2.setPreferredSize(new Dimension(x1, (y1+60)));
			b2.setLocation((x1-140), y1+10);
			b2.setSize(100, 25);
			pan2.add(b2);
			b3=new JButton("HOME");
			b3.setLocation((x1-140), y1+40);
			b3.setSize(100, 25);
			b3.addActionListener(control);
			pan2.add(b3);
		}
		public void inp(){//ввод таблици начальных значений
			m=new double[z][N];
			result=new double[2][N];
			for(int i=0;i<z;i++){
				for(int j=0;j<N;j++){
					m[i][j]=Double.parseDouble(mm[i][j].getText());
					mm[i][j].setText(m[i][j]+"");
					mm[i][j].setEnabled(false);
				}
			}
		}
		private void end() {//вывод результатов
			
			int n;
			
			res=new JLabel[4][N+1];
			res[0][0]=new JLabel("");
			res[0][0].setLocation(5, 5);
			res[0][0].setSize(250, 20);
			pan3.add(res[0][0]);
			
			res[1][0]=new JLabel("<html>Инвестировать у.е. в программу r<sub>i</sub>");
			res[1][0].setLocation(5, 25);
			res[1][0].setSize(250, 20);
			pan3.add(res[1][0]);
			
			res[2][0]=new JLabel("<html>Инвестировать средств в программу r<sub>i</sub>");
			res[2][0].setLocation(5, 50);
			res[2][0].setSize(250, 20);
			pan3.add(res[2][0]);
			
			res[3][0]=new JLabel("<html>Прибыль от программы r<sub>i</sub>");
			res[3][0].setLocation(5, 75);
			res[3][0].setSize(250, 20);
			pan3.add(res[3][0]);
			
			x=250;
			y=5;
			
			for(int i=1;i<res[0].length;i++){
				res[0][i]=new JLabel("<html>r<sub>"+i+"</sub>");
				res[0][i].setLocation(x, y);
				res[0][i].setSize(50, 20);
				pan3.add(res[0][i]);
				x=x+50;
			}
			
			x=250;
			y=22;
			
			for(int j=0;j<z;j++){
				h[j]=y4[N][j];
			}
			extrem();
			n=y5;

			result[0][N-1]=y3[N][n];
			result[1][N-1]=m[y3[N][n]][N-1];
			res[1][N]=new JLabel(m[y3[N][n]][N-1]+"");
			n=n-y3[N][n];
			for(int i=2;i<N+1;i++){
				result[0][N-i]=(y3[N-i+1][n]);
				result[1][N-i]=m[y3[N-i+1][n]][N-i];
				res[1][N-i+1]=new JLabel(m[y3[N-i+1][n]][N-i]+"");
				n=(n-y3[N-i+1][n]);
			}
			for(int i=0;i<N;i++){
				res[2][i+1]=new JLabel((c*result[0][i])/(z-1)+"");
				res[3][i+1]=new JLabel((c/(z-1))*result[1][i]+"");
			}
			for(int i=1;i<4;i++){
				for(int j=1;j<N+1;j++){
					pan3.add(res[i][j]);
					res[i][j].setLocation(x, y);
					res[i][j].setSize(50, 20);
					x=x+50;
					x1=x;
				}
				x=250;
				y=y+25;
				y1=y;
			}
			pan3.setPreferredSize(new Dimension((x1+40), (y1+60)));
			b3.setLocation((x1-140), y1+40);
			b3.setSize(100, 25);
			b3.addActionListener(control);
			pan3.add(b3);
			q=2;
		}
	}
}
