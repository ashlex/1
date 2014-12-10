import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	static User user;
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		setUsers();
		boolean a = true;
		println("Проекты:");
		printCollections(UserHelper.collectionProject);
		println("Сотрудники:");
		printCollections(UserHelper.collectionUser);
		println("Отделы:");
		println("D, QA");
		while (a) {
			int select = menu();
			switch (select) {
			case 1:
				// список сотрудников, работающих над заданным проектом;

				printCollections(UserHelper.getUser(UserHelper.getProject("NF")));
				break;
			case 2:
//				список проектов, в которых участвует заданный сотрудник;
				printCollections(UserHelper.getAllProject(UserHelper.getUser("Ягунова")));
				break;
			case 3:
//				список сотрудников из заданного отдела, не участвующих ни в одном проекте;
				printCollections(UserHelper.getAllUser("D"));
				break;
			case 4:
//				список сотрудников, не участвующих ни в одном проекте;
				printCollections(UserHelper.getUser());
				break;
			case 5:
//				список подчиненных для заданного руководителя (по всем проектам, которыми он руководит);
				printCollections(UserHelper.getUser(UserHelper.getUser("Калашников")));
				break;
			case 6:
//				список руководителей для заданного сотрудника (по всем проектам, в которых он участвует);
				printCollections(UserHelper.getLeader(UserHelper.getUser("Ягунова")));
				break;
			case 7:
				a = false;
				break;
			default:
				break;
			}
		}
	}

	public static void setUsers() {

		user = new User("Калашников", "Евгений", "Юрьевич", "QA");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, true);
		user.addNewProject(new Project("Product", user, "asd"));

		user = new User("Канурин", "Сргей", "Владимирович", "QA");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, true);
		user.addNewProject(new Project("NF", user, "bvm"));

		user = new User("Шаров", "Алексей", "Васильевич", "D");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("Product"));

		user = new User("Петров", "Сергей", "Станиславович", "D");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("Product"));

		user = new User("Иванов", "Антон", "Владимирович", "D");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("NF"));

		user = new User("Сидоров", "Игорь", "Андреевич", "Q");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("NF"));

		user = new User("Ягунова", "Алла", "Юрьевна", "Q");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("Product"));
		user.addProject(UserHelper.getProject("NF"));

		user = new User("Маркин", "Евгений", "Русланович", "D");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("NF"));
	}

	public static Integer menu() {
		int i = 0;
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

	public static void print(String string) {
		System.out.print(string);
	}

	public static void println(Object string) {
		System.out.println(string);
	}
}
