import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	static User user;
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		setUsers();
		boolean a = true;
		println("�������:");
		printCollections(UserHelper.collectionProject);
		println("����������:");
		printCollections(UserHelper.collectionUser);
		println("������:");
		println("D, QA");
		while (a) {
			int select = menu();
			switch (select) {
			case 1:
				// ������ �����������, ���������� ��� �������� ��������;

				printCollections(UserHelper.getUser(UserHelper.getProject("NF")));
				break;
			case 2:
//				������ ��������, � ������� ��������� �������� ���������;
				printCollections(UserHelper.getAllProject(UserHelper.getUser("�������")));
				break;
			case 3:
//				������ ����������� �� ��������� ������, �� ����������� �� � ����� �������;
				printCollections(UserHelper.getAllUser("D"));
				break;
			case 4:
//				������ �����������, �� ����������� �� � ����� �������;
				printCollections(UserHelper.getUser());
				break;
			case 5:
//				������ ����������� ��� ��������� ������������ (�� ���� ��������, �������� �� ���������);
				printCollections(UserHelper.getUser(UserHelper.getUser("����������")));
				break;
			case 6:
//				������ ������������� ��� ��������� ���������� (�� ���� ��������, � ������� �� ���������);
				printCollections(UserHelper.getLeader(UserHelper.getUser("�������")));
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

		user = new User("����������", "�������", "�������", "QA");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, true);
		user.addNewProject(new Project("Product", user, "asd"));

		user = new User("�������", "�����", "������������", "QA");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, true);
		user.addNewProject(new Project("NF", user, "bvm"));

		user = new User("�����", "�������", "����������", "D");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("Product"));

		user = new User("������", "������", "�������������", "D");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("Product"));

		user = new User("������", "�����", "������������", "D");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("NF"));

		user = new User("�������", "�����", "���������", "Q");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("NF"));

		user = new User("�������", "����", "�������", "Q");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("Product"));
		user.addProject(UserHelper.getProject("NF"));

		user = new User("������", "�������", "����������", "D");
		UserHelper.collectionUser.add(user);
		UserHelper.updateUser(user, false);
		user.addProject(UserHelper.getProject("NF"));
	}

	public static Integer menu() {
		int i = 0;
		print("��� �����:");
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
