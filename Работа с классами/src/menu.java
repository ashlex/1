
public class menu {
	char i;
	public void menu_start() {
		try{
		do{
			System.out.println("�������� 1");
			System.out.println("�������� 2");
			System.out.println("�������� 3");
			System.out.println("�������� 4");
			System.out.println("�������� 5");
			System.out.print("��� �����: ");
			i=(char)System.in.read();
			System.out.println();
			System.out.println("i="+i+"\n");
		}while(i<'1'|i>'5');
		System.out.print("���� ��������\n");
		}catch(Exception e){}
	}

}