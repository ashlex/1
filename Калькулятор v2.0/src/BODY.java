import javax.swing.*;
import java.awt.event.*;
/*
 * Обозначения
 * s-счётчик операций кроме =
 * w-счётчик операций = когда записывается k
 * w1-счётчик операций = когда не записывается k
 * bb[rov]==управляющий массив
 * bm==bb[0]
 * bp==bb[1]
 * bx==bb[2]
 * bd==bb[3]
 * bs==bb[4]
 * f1==запись двух последних действий и вывод их на монитор
 * f2==управляющий массив bb[rov]
 */
@SuppressWarnings("serial")
public class BODY extends JFrame{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bx,bd,bp,bm,be,br,bs;
	JLabel l1,l2;
	JTextField t1;
	double i,k,x,y,z,p,w,w1,s,i1;
	static byte id;
	static byte rov=5;
	static byte[] bb=new byte[rov];
	String a,b,m,c;
		
	eHandler handler=new eHandler(); //Создаём переменную включающую в себя класс
		
	public BODY(String s){
		super(s);
		//for(id=0;id<rov;id++){
		//	bb[id]=0;
		//}
		y=0;
		m="";
		w=1;
		w1=1;
		a="0";
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
		b0=new JButton("0");
		bx=new JButton("*");
		bd=new JButton("/");
		bm=new JButton("-");
		bp=new JButton("+");
		br=new JButton("C");
		be=new JButton("=");
		bs=new JButton("^");
		l1=new JLabel("");
		l2=new JLabel("");
		t1=new JTextField("0",15);
		add(t1);
		add(l2);
		add(br);
		add(be);
		add(b7);
		add(b8);
		add(b9);
		add(bx);
		add(b4);
		add(b5);
		add(b6);
		add(bd);
		add(b1);
		add(b2);
		add(b3);
		add(bp);
		add(b0);
		add(bs);
		add(bm);
		add(l1);
		
		//Расположение и размеры кнопок
		
		t1.setLocation(0, 0);
		t1.setSize(200, 19);
		l2.setLocation(0, 19);
		l2.setSize(200, 19);
		br.setLocation(0, 40);
		br.setSize(100,30);
		be.setLocation(100, 40);
		be.setSize(100,30);
		b7.setLocation(0, 70);
		b7.setSize(50,30);
		b8.setLocation(50, 70);
		b8.setSize(50,30);
		b9.setLocation(100, 70);
		b9.setSize(50,30);
		bx.setLocation(150, 70);
		bx.setSize(50,30);
		b4.setLocation(0, 100);
		b4.setSize(50,30);
		b5.setLocation(50, 100);
		b5.setSize(50,30);
		b6.setLocation(100, 100);
		b6.setSize(50,30);
		bd.setLocation(150, 100);
		bd.setSize(50,30);
		b1.setLocation(0, 130);
		b1.setSize(50,30);
		b2.setLocation(50, 130);
		b2.setSize(50,30);
		b3.setLocation(100, 130);
		b3.setSize(50,30);
		bp.setLocation(150, 130);
		bp.setSize(50,30);
		b0.setLocation(0, 160);
		b0.setSize(100,30);
		bm.setLocation(150, 160);
		bm.setSize(50,30);
		bs.setLocation(100, 160);
		bs.setSize(50,30);
		
		//включаем кнопки
		
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		b3.addActionListener(handler);
		b4.addActionListener(handler);
		b5.addActionListener(handler);
		b6.addActionListener(handler);
		b7.addActionListener(handler);
		b8.addActionListener(handler);
		b9.addActionListener(handler);
		b0.addActionListener(handler);
		bx.addActionListener(handler);
		bp.addActionListener(handler);
		bm.addActionListener(handler);
		bd.addActionListener(handler);
		br.addActionListener(handler);
		be.addActionListener(handler);
		bs.addActionListener(handler);
	}
	public class eHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				
				//кнопки набора чисел
				
				if(e.getSource()==b1){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						t1.setText("");
					}
					t1.setText(t1.getText()+"1");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				if(e.getSource()==b2){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						t1.setText("");
					}
					t1.setText(t1.getText()+"2");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				if(e.getSource()==b3){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						t1.setText("");
					}
					t1.setText(t1.getText()+"3");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				if(e.getSource()==b4){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						t1.setText("");
					}
					t1.setText(t1.getText()+"4");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				if(e.getSource()==b5){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						t1.setText("");
					}
					t1.setText(t1.getText()+"5");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				if(e.getSource()==b6){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						t1.setText("");
					}
					t1.setText(t1.getText()+"6");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				if(e.getSource()==b7){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						t1.setText("");
					}
					t1.setText(t1.getText()+"7");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				if(e.getSource()==b8){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						t1.setText("");
					}
					t1.setText(t1.getText()+"8");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				if(e.getSource()==b9){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						t1.setText("");
					}
					t1.setText(t1.getText()+"9");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				m2:if(e.getSource()==b0){
					double i1=Double.parseDouble(t1.getText());
					if(i1==0){
						break m2;
					}
					t1.setText(t1.getText()+"0");
					p=Double.parseDouble(t1.getText());
					b=m+p;
					l2.setText("<html><font size=3>"+b+"</font></html>");
				}
				
				//кнопки функций
				
				if(e.getSource()==br){//кнопка сброса
					t1.setText("0");
					i=0;
					k=0;
					z=0;
					a="0";
					b="";
					m="";
					w=1;
					s=0;
					p=0;
					
				}
				
				if(e.getSource()==bm){//кнопка -
					id=3;
					F_Control_Button();				
					F_Control_Array();
				}
				
				if(e.getSource()==bp){//кнопка +
					id=2;
					F_Control_Button();				
					F_Control_Array();
				}
				
				if(e.getSource()==bx){//кнопка *
					id=0;
					F_Control_Button();				
					F_Control_Array();
				}
				if(e.getSource()==bd){//кнопка /
					id=1;
					F_Control_Button();				
					F_Control_Array();
				}
				if(e.getSource()==bs){//кнопка 
					id=4;
					F_Control_Button();
					F_Control_Array();
				}
				double l=i;
				if(e.getSource()==be){//кнопка =
					s=0;//обнуляем счётчик операций кроме =
					if(w==w1){//не даёт перезаписаться k при повторном нажатии =
					k=Double.parseDouble(t1.getText());
					w++;//считаем кол-во нажатий подряд на = при которых записывается k
					}
					w1++;//считаем кол-во нажатий подряд на =
					
					if("+".equals(a)){
						z=i+k;
						t1.setText(z+"");
						i=Double.parseDouble(t1.getText());
						b=l+a+k+"="+z;
						l2.setText("<html><font size=3>"+b+"</font></html>");
					}
					if("-".equals(a)){
						z=i-k;
						t1.setText(z+"");
						i=Double.parseDouble(t1.getText());
						b=l+a+k+"="+z;
						l2.setText("<html><font size=3>"+b+"</font></html>");
					}
					if("*".equals(a)){
						z=i*k;
						t1.setText(z+"");
						i=Double.parseDouble(t1.getText());
						b=l+a+k+"="+z;
						l2.setText("<html><font size=3>"+b+"</font></html>");
					}
					if("/".equals(a)){
						z=i/k;
						t1.setText(z+"");
						i=Double.parseDouble(t1.getText());
						b=l+a+k+"="+z;
						l2.setText("<html><font size=3>"+b+"</font></html>");
					}
					if("^".equals(a)){
						z=st(i,k);
						t1.setText(z+"");
						i=Double.parseDouble(t1.getText());
						b=l+a+k+"="+z;
						l2.setText("<html><font size=3>"+b+"</font></html>");
					}
					w=1;
				}
			}catch(Exception xe){ JOptionPane.showMessageDialog(null, "Введите число!");}
			System.out.println("a="+a);
			System.out.println("i="+i);
			System.out.println("k="+k);
			System.out.println("z="+z);
			System.out.println("b="+b);
			System.out.println("w="+w);
			System.out.println("s="+s);
			System.out.println("p="+p);
			System.out.println("t2="+Double.parseDouble(t1.getText()));
			System.out.println("-----------------");
		}
		private void F_Control_Button() {
				if(id==0){c="*";}
				if(id==1){c="/";}
				if(id==2){c="+";}
				if(id==3){c="-";}
				if(id==4){c="^";}
				metka:{
				p=0;
				if(l1.getText()!="0"){
					if(s!=0){
						p=Double.parseDouble(t1.getText()+"");//записываем если не первый раз
					}
					if(s==0){
						i=Double.parseDouble(t1.getText()+"");//записываем если первый раз
					}
					if("0".equals(a)){
						a=c;
					}
					if("-".equals(a)){
						t1.setText("0");
						i=i-p;
						a=c;
						f1();
						break metka;
					}
					if("+".equals(a)){
						t1.setText("0");
						i=i+p;
						a=c;
						f1();
						break metka;
						
					}
					if("*".equals(a)){
						t1.setText("0");
						if(p!=0){
							i=i*p;
						}
						a=c;
						f1();
						break metka;
						
					}
					if("/".equals(a)){
						t1.setText("0");
						if(p!=0){
							i=i/p;
						}
						if(p==0 && bb[id]==1){
							JOptionPane.showMessageDialog(null, "На 0 делить нельзя!");
						}
						a=c;
						f1();
						break metka;
						
					}
					if("^".equals(a)){
						t1.setText("0");
						//i=st(i,p);
						a=c;
						f1();
						break metka;					
					}
				}
				else{
					if("+".equals(a)){
						a=c;
						f1();
						break metka;
					}
					if("-".equals(a)){
						a=c;
						f1();
						break metka;
					}
					if("*".equals(a)){
						a=c;
						f1();
						break metka;
					}
					if("/".equals(a)){
						a=c;
						f1();
						break metka;
					}
					if("0".equals(a)){
						a=c;
						f1();
						break metka;
					}
					if("^".equals(a)){
						a=c;
						f1();
						break metka;
					}
				}
			}
		}
		private void F_Control_Array() {
			System.out.println(id);
			for(int q=0;q<rov;q++){
				if(q==id){
					bb[q]=1;
				}
				if(q!=id){
					bb[q]=0;
				}
				System.out.print(bb[q]);
			}
			System.out.println();
		}
		private void f1() {
			b=""+i+a;
			l2.setText("<html><font size=3>"+b+"</font></html>");
			m=b;
			s=1;
			w1=1;
		}
		public double st(double u, double v){ //Функция возведения в степень
			z=i;		
			if(s!=0){		// \
				k=p;		//  >поправка, нужна при не однократном нажатии ^
			}				// /
			if(k!=0){
			for(x=1;x<k;x++){
				z=z*i;
				}
			}
			else{
				z=1;
			}
			return(z);
		}
	}
}	