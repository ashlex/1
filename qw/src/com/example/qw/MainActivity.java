package com.example.qw;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity{
	w w=new w();
	private TextView t1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void f1(View v){
		try{
		TextView t=(TextView) findViewById(R.id.textView1);
		t.setText("привет");
		//TextView t1=(TextView) findViewById(R.id.textView2);
		//t1.setText(w.e);
		t1=(TextView) findViewById(R.id.textView2);
		EditText f=(EditText) findViewById(R.id.editText1);
		int g=Integer.parseInt(f.getText()+"");
		t1.setText(w.e+" ["+w.m[(g-1)]+"]");
		}catch(Exception u){t1.setText("¬ведите число от 1 до "+w.r);}
	}
	

}
