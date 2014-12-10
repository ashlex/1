
public class menu {
	char i;
	public void menu_start() {
		try{
		do{
			System.out.println("выберите 1");
			System.out.println("выберите 2");
			System.out.println("выберите 3");
			System.out.println("выберите 4");
			System.out.println("выберите 5");
			System.out.print("Ваш выбор: ");
			i=(char)System.in.read();
			System.out.println();
			System.out.println("i="+i+"\n");
		}while(i<'1'|i>'5');
		System.out.print("Цикл закончен\n");
		}catch(Exception e){}
	}

}