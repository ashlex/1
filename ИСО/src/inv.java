import java.io.File;
import java.util.Scanner;


public class inv {	
	int select,select1;
	long c=0;
	int N=0,k=1,z=0,y,y1[][];
	double fz[][],m[][],h[],y2[][],result[][];
	double m1,m2;
	static Scanner scn=new Scanner(System.in);//������ ��� ������� �����
	static Scanner scn1;//������ ��� �����
	static boolean s=true;
	public inv(){
		menu();
		inp1();                     //���� ��������� ������� ��� ������������ ������� m
		m=new double[z][N];		//������������ �������
		result=new double[2][N];
		if(select==1){
			openFile();
			readFile();
		}
		if(select==2){
			inp();//���� ������� ��������� ��������
		}
		outp();						//����� �������  m ��� ��������
		System.out.println("---------------------");
		mat();
		end();
	}
	private void menu() {
		do{
		try{
		do{
			s=true;
			System.out.println("�������� 1 ���� ���� �� �����");
			System.out.println("�������� 2 ���� ���� �������");
			System.out.print("��� �����: ");
			select=Integer.parseInt(scn.next());
			System.out.println("i="+select+"\n");
			s=false;
		}while(select<1|select>2);
		}catch(Exception e){
			System.out.println("������� ������ �����!");
		}
		}while(s);
	}
	private void readFile() {
		while(scn1.hasNext()){
			for(int row=0;row<m.length;row++){
				for(int col=0;col<m[row].length;col++){
					m[row][col]=scn1.nextDouble();
				}
			}
		}
		//scn1.close();
	}
	private static void openFile() {
		try{
			String a="res//2.txt";
			scn1=new Scanner(new File(a));
		}catch(Exception e){System.out.print("���� �� ������");}
	}
	private void extrem(){//����� ��������� �� ��������� ���������
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
				y=i;
				break q1;
			}
		}
		return;
	}
	private void outp() {//����� �������  m ��� ��������
		for(int i=0;i<z;i++){
			for(int j=0;j<N;j++){
				System.out.print(m[i][j]+"  ");
			}
			System.out.println();
		}
	}
	private void inp1(){//���� ��������� ������� ��� ������������ ������� m
		try{
		System.out.print("������� ���������� ��������:");
		c=Long.parseLong(scn.next());
		System.out.print("������� ���������� ��������:");
		N=Integer.parseInt(scn.next());
		System.out.print("������� ���������� z:");
		z=Integer.parseInt(scn.next());
		}catch(Exception e){
			System.out.println("������� ������ �����!");
			s=true;
		}
	}
	private void inp(){//���� ������� ��������� ��������
		for(int i=0;i<N;i++){
			for(int j=0;j<z;j++){
				System.out.print("������� r"+(i+1)+"("+j+"):");
				m[j][i]=Double.parseDouble(scn.next());
			}
		}
	}
	private void mat() {//������� � ��������� ������������� �������
		if(!s){
			int xk[][]=new int[N+1][z];
			int p=z;
			double fk[][][]=new double[N+1][z][p];
			h=new double[z];
			y1=new int[N+1][p];//������ ������������� ��������
			y2=new double[N+1][p];//������������ ��������
			k=0;
			
			for(int i=0;i<p;i++){
				for(int j=0;j<p;j++){
					fk[k][i][j]=0;
					xk[k][i]=0;
					h[j]=fk[k][i][j];
				}
				extrem();
				y1[k][i]=y;
				y2[k][i]=m2;
				//System.out.println();
				//System.out.println("---------------------");
				//System.out.println("max="+m2);
				//System.out.println("y1="+y1[k][i]);
			}
			//for(int i=0;i<p;i++){
			//	System.out.println("xk["+k+"]["+i+"]"+xk[k][i]+"  ");
			//}
			//System.out.println();
			System.out.println("---------------------");
			for(int i=0;i<p;i++){
				for(int j=0;j<p;j++){
					System.out.print("fk["+k+"]["+i+"]["+j+"]="+fk[k][i][j]+"  ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("---------------------");
			for(int i=0;i<z;i++){
				System.out.print("h["+i+"]="+y2[k][i]+" ");
			}
			System.out.println();
			System.out.println("---------------------");
			for(int i=0;i<z;i++){
				System.out.print("y1["+i+"]="+y1[k][i]+" ");
			}
			System.out.println();
			
			for(int l=1;l<N+1;l++){
				/*
				 * � ���� ����� ���� �� 1 �� N ����ר�� ����������� 
				 * ���������� �������� � ��������� ���������
				 */
				System.out.println("��� "+l);
				for(int i=0;i<p;i++){
					for(int j=0;j<i+1;j++){
						xk[l][j]=j;
						//System.out.println("xk["+l+"]["+j+"]"+xk[l][j]+"  ");
					}
					for(int j=0;j<p;j++){
						if(j<i+1){
						fk[l][i][j]=((m[xk[l][j]][l-1])+(fk[l-1][i-xk[l][j]][y1[l-1][i-j]]));
						}
						if(j>i+1){
							fk[l][i][j]=0;
						}
						h[j]=fk[l][i][j];
						//System.out.println("������� [l]="+l);
						//System.out.println("������� [i]="+i);
						//System.out.println("������� [j]="+j);
						//System.out.println("������� xk[l][j]="+xk[l][j]);
						//System.out.println("������� m[xk[l][j]][l-1]="+m[xk[l][j]][l-1]);
						//System.out.println("������� fk[l-1][i-xk[l][j]][y1[l-1][i]]="+fk[l-1][i-xk[l][j]][y1[l-1][i]]);
						//if(j<i+1){
						//	System.out.println("������� y1[l-1][i]="+y1[l-1][i-j]);
						//}
						//if(j>i+1){
							//System.out.println("������� y1[l-1][i]="+y1[l-1][i-j]);
						//}
						//System.out.println("������� fk["+l+"]["+i+"]["+j+"]="+fk[l][i][j]);
						//System.out.println("---------------------");
					}
					extrem();
					y1[l][i]=y;
					y2[l][i]=m2;
					//System.out.println("max="+m2);
					//System.out.println("y1="+y1[l-1][i]);
					//System.out.println("---------------------");
				}
				System.out.println();
				System.out.println("---------------------");
				for(int i=0;i<p;i++){
					System.out.print("fk["+l+"]["+i+"][j]={");
					for(int j=0;j<p;j++){
						System.out.print(fk[l][i][j]+" , ");
					}
					System.out.println("}");
				}
				System.out.println();
				System.out.println("---------------------");
				for(int i=0;i<z;i++){
					System.out.print("h["+i+"]="+y2[l][i]+" ");
				}
				System.out.println();
				System.out.println("---------------------");
				for(int i=0;i<z;i++){
					System.out.print("y1["+i+"]="+y1[l][i]+" ");
				}
				System.out.println();
				System.out.println("---------------------");
			}
			
			for(int k=0;k<y1.length;k++){
				for(int t=0;t<y1[k].length;t++){
					System.out.print(y1[k][t]+" ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("---------------------");
			for(int k=0;k<y2.length;k++){
				for(int t=0;t<y2[k].length;t++){
					System.out.print(y2[k][t]+" ");
				}
				System.out.println();
			}
		}
	}
	private void end() {//����� �����������
		int n;
		for(int j=0;j<z;j++){
			h[j]=y2[N][j];
		}
		extrem();
		n=y;

		//System.out.println("n="+n);
		result[0][N-1]=y1[N][n];
		//System.out.println("result[0]["+(N)+"]="+result[0][(N-1)]);
		result[1][N-1]=m[y1[N][n]][N-1];
		//System.out.println("result[1]["+(N)+"]="+result[1][(N-1)]);
		n=n-y1[N][n];
		//System.out.println("n="+n);
		for(int i=2;i<N+1;i++){
			result[0][N-i]=(y1[N-i+1][n]);
			result[1][N-i]=m[y1[N-i+1][n]][N-i];
			n=(n-y1[N-i+1][n]);
			//System.out.println("���� "+(i-1));
			//System.out.println("result[0]["+(N-i)+"]="+result[0][N-i]);
			//System.out.println("result[1]["+(N-i)+"]="+result[1][N-i]);
		}
		//System.out.println("---------------------");
		for(int i=0;i<N;i++){
			System.out.println("result[0]["+(i)+"]="+result[0][i]);
			System.out.println("result[1]["+(i)+"]="+result[1][i]);
		}
		System.out.println("---------------------");
		for(int i=0;i<N;i++){
			double res=(c*result[0][i])/(z-1);
			double res1=(c/(z-1))*result[1][i];
			System.out.println("result[0]["+(N-i)+"]="+res);
			System.out.println("result[1]["+(N-i)+"]="+res1);
		}
	}
}