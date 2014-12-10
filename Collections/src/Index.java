import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Index {
	static Scanner scn = new Scanner(System.in);
	static User user;

	static Project project;

	public static void maine() {
		boolean a = true;
		setCollection();
		while (a) {
			int select = menu();
			switch (select) {
			case 1:
				printCollections(UserHelper.getUser());
				break;
			case 2:
				User u1 = UserHelper.getUser("Шаров");
				User u2 = UserHelper.getUser("Сидоров");
				u2.addProject(new Project("Проект12", u1, null));
				break;
			case 3:
				printCollections(UserHelper.getAllProject());
				break;
			case 4:
				printCollections(UserHelper.getAllUser());
				break;
			case 5:
				printCollections(UserHelper.collectionUser);
				break;
			case 6:
				User u = UserHelper.getUser("Шаров");
				u.addProject(new Project("Проект", u, null));
				println(UserHelper.getUser("Шаров").project);
				break;
			case 7:
				User u3 = UserHelper.getUser("Шаров");
				printCollections(UserHelper.getUser(u3));
				
				break;
			case 8:
				a = false;
				break;
			default:
				break;
			}
		}

	}

	public static void print(String string) {
		System.out.print(string);
	}

	public static void println(Object string) {
		System.out.println(string);
	}

	// private static void recColection() {
	// boolean a = true;
	// String L, F, N, P;
	// while (a) {
	// scn.reset();
	// print("Введите фамилию:");
	// L = scn.next();
	// System.out.println(L);
	// print("Введите имя:");
	// N = scn.next();
	// print("Введите отчество:");
	// F = scn.next();
	// print("Введите должность:");
	// if (scn.hasNext()) {
	// P = scn.next();
	// } else {
	// P = null;
	// }
	// if (P == null) {
	// continue;
	// } else {
	// user = new User(L, N, F, P);
	// }
	// println(user);
	// UserHelper.collectionUser.add(user);
	// print("Ещё сотрудник [Y/N]:");
	//
	// String re = scn.next();
	//
	// if (re.equalsIgnoreCase("N")) {
	// a = false;
	// }
	// }
	// }

	// private static void recProject() {
	//
	// boolean a = true;
	// String n, l, c;
	// while (a) {
	// print("Введите название:");
	// n = scn.next();
	// print("Введите руководителя:");
	// l = scn.next();
	// print("Введите заказчика:");
	// c = scn.next();
	// Project project = new Project(n, l, c);
	// collectionProject.add(project);
	// print("Ещё заявка [Y/N]:");
	// String re = scn.next();
	// if (re.equalsIgnoreCase("N")) {
	// a = false;
	// }
	// }
	// }

	public static Integer menu() {
		int i = 0;
		println("1. Заполнение коллекции сотрудников");
		println("2. Создать заявку");
		println("3. Вывод коллекции заявок");
		println("4. null");
		println("5. Вывод коллекции сотрудников");
		println("6. Выход");
		print("Ваш выбор:");
		i = scn.nextInt();
		return i;
	}

	public static void printCollections(Collection<?> hs2) {
		Iterator<?> it = hs2.iterator();
		while (it.hasNext()) {
			println(it.next());
		}
	}

	public static void setCollection() {
		user = new User("Шаров", "Алексей", "Васильевич", "1");
		UserHelper.collectionUser.add(user);

		Project pro = new Project("про_1", user, " ");
		user.addProject(pro);
		user.addProject(new Project("про_2", user, " "));

		user = new User("Петров", "Сергей", "Станиславович", "2");
		UserHelper.collectionUser.add(user);
		user.addProject(pro);

		user = new User("Иванов", "Антон", "Владимирович", "3");
		UserHelper.collectionUser.add(user);
		user.addProject(pro);

		user = new User("Сидоров", "Игорь", "Андреевич", "4");
		UserHelper.collectionUser.add(user);
		user = new User("Калашников", "Евгений", "Юрьевич", "5");
		UserHelper.collectionUser.add(user);
	}
}
