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
				User u1 = UserHelper.getUser("�����");
				User u2 = UserHelper.getUser("�������");
				u2.addProject(new Project("������12", u1, null));
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
				User u = UserHelper.getUser("�����");
				u.addProject(new Project("������", u, null));
				println(UserHelper.getUser("�����").project);
				break;
			case 7:
				User u3 = UserHelper.getUser("�����");
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
	// print("������� �������:");
	// L = scn.next();
	// System.out.println(L);
	// print("������� ���:");
	// N = scn.next();
	// print("������� ��������:");
	// F = scn.next();
	// print("������� ���������:");
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
	// print("��� ��������� [Y/N]:");
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
	// print("������� ��������:");
	// n = scn.next();
	// print("������� ������������:");
	// l = scn.next();
	// print("������� ���������:");
	// c = scn.next();
	// Project project = new Project(n, l, c);
	// collectionProject.add(project);
	// print("��� ������ [Y/N]:");
	// String re = scn.next();
	// if (re.equalsIgnoreCase("N")) {
	// a = false;
	// }
	// }
	// }

	public static Integer menu() {
		int i = 0;
		println("1. ���������� ��������� �����������");
		println("2. ������� ������");
		println("3. ����� ��������� ������");
		println("4. null");
		println("5. ����� ��������� �����������");
		println("6. �����");
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

	public static void setCollection() {
		user = new User("�����", "�������", "����������", "1");
		UserHelper.collectionUser.add(user);

		Project pro = new Project("���_1", user, " ");
		user.addProject(pro);
		user.addProject(new Project("���_2", user, " "));

		user = new User("������", "������", "�������������", "2");
		UserHelper.collectionUser.add(user);
		user.addProject(pro);

		user = new User("������", "�����", "������������", "3");
		UserHelper.collectionUser.add(user);
		user.addProject(pro);

		user = new User("�������", "�����", "���������", "4");
		UserHelper.collectionUser.add(user);
		user = new User("����������", "�������", "�������", "5");
		UserHelper.collectionUser.add(user);
	}
}
