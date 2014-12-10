package com.example.calc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	static TextView l1,l2;
	static byte id1,w=1,w1,s;
	static byte rov1=4;
	static byte[] bb=new byte[rov1];
	static long p,ii,k,z;
	static String a="0",b,c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//f1(null);
		l1=(TextView) findViewById(R.id.textView1);
		l2=(TextView) findViewById(R.id.textView2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void f1(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"1");
	}
	public void f2(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"2");
	}
	public void f3(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"3");
	}
	public void f4(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"4");
	}
	public void f5(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"5");
	}
	public void f6(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"6");
	}
	public void f7(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"7");
	}
	public void f8(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"8");
	}
	public void f9(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"9");
	}
	public void f0(View v){
		long i=Long.parseLong(l1.getText()+"");
		if(i==0){
			l1.setText("");
		}
		l1.setText(l1.getText()+"0");
	}
	
	public void fx(View v){
		id1=0;
		F_Control_Button();
		F_Control_Array();
	}
	public void fd(View v){
		id1=1;
		F_Control_Button();
		F_Control_Array();
	}
	public void fp(View v){
		id1=2;
		F_Control_Button();
		F_Control_Array();
	}
	public void fm(View v){
		id1=3;
		F_Control_Button();
		F_Control_Array();
	}
	public void fc(View v){
		id1=4;
		l1.setText("0");
		ii=0;
		k=0;
		z=0;
		a="0";
		b="";
		w=1;
		s=0;
		p=0;
		
	}
	
	public void fr(View v){
		long l=ii;
		s=0;//обнуляем счётчик операций кроме =
		if(w==w1){//не даёт перезаписаться k при повторном нажатии =
		k=Long.parseLong(l1.getText()+"");
		w++;//считаем кол-во нажатий подряд на = при которых записывается k
		}
		w1++;//считаем кол-во нажатий подряд на =
		
		if("+".equals(a)){
			z=ii+k;
			l1.setText(z+"");
			ii=Long.parseLong(l1.getText()+"");
			b=l+a+k+"="+z;
			l2.setText(b);
		}
		if("-".equals(a)){
			z=ii-k;
			l1.setText(z+"");
			ii=Long.parseLong(l1.getText()+"");
			b=l+a+k+"="+z;
			l2.setText(b);
		}
		if("*".equals(a)){
			z=ii*k;
			l1.setText(z+"");
			ii=Long.parseLong(l1.getText()+"");
			b=l+a+k+"="+z;
			l2.setText(b);
		}
		if("/".equals(a)){
			z=ii/k;
			l1.setText(z+"");
			ii=Long.parseLong(l1.getText()+"");
			b=l+a+k+"="+z;
			l2.setText(b);
		}
		w=1;
	}
	
	private void F_Print_Result() {
		b=""+ii+a;
		l2.setText(b+"");
		s=1;
		w1=1;
		//m=b;
	}
	private void F_Control_Button() {
		if(id1==0){c="*";}
		if(id1==1){c="/";}
		if(id1==2){c="+";}
		if(id1==3){c="-";}
		metka:{
		p=0;
		if(l1.getText()!="0"){
			if(s!=0){
				p=Long.parseLong(l1.getText()+"");//записываем если не первый раз
			}
			if(s==0){
				ii=Long.parseLong(l1.getText()+"");//записываем если первый раз
			}
			if("0".equals(a)){
				a=c;
			}
			if("-".equals(a)){
				l1.setText("0");
				ii=ii-p;
				a=c;
				F_Print_Result();
				break metka;
			}
			if("+".equals(a)){
				l1.setText("0");
				ii=ii+p;
				a=c;
				F_Print_Result();
				break metka;
				
			}
			if("*".equals(a)){
				l1.setText("0");
				if(p!=0){
					ii=ii*p;
				}
				a=c;
				F_Print_Result();
				break metka;
				
			}
			if("/".equals(a)){
				l1.setText("0");
				if(p!=0){
					ii=ii/p;
				}
				//if(p==0 && bb[id]==1){
					//JOptionPane.showMessageDialog(null, "На 0 делить нельзя!");
				//}
				a=c;
				F_Print_Result();
				break metka;
				
			}
		}
		else{
			if("+".equals(a)){
				a=c;
				F_Print_Result();
				break metka;
			}
			if("-".equals(a)){
				a=c;
				F_Print_Result();
				break metka;
			}
			if("*".equals(a)){
				a=c;
				F_Print_Result();
				break metka;
			}
			if("/".equals(a)){
				a=c;
				F_Print_Result();
				break metka;
			}
			if("0".equals(a)){
				a=c;
				F_Print_Result();
				break metka;
			}
		}
		}
	}
	private void F_Control_Array() {
		System.out.println(id1);
		for(int q=0;q<rov1;q++){
			if(q==id1){
				bb[q]=1;
			}
			if(q!=id1){
				bb[q]=0;
			}
		}
	}
}
