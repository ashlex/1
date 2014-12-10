package com.example.qw;


public class w{
	String e;
	int k=1,r=15;
	int m[]=new int[r];
	public w(){
		e="Получилось число:";
		start();
	}
	public void start() {
		for(int x=0;x<r;x++){
			for(int i=1;i<(x+1);i++){
			k=k*i;
			}
			m[x]=k;
			k=1;
		}
	}

}
