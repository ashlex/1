import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UserHelper {
	static Collection<User> collectionUser = new ArrayList<User>();
	static Collection<Project> collectionProject = new ArrayList<Project>();

	public static void addProject(Project project) {
		collectionProject.add(project);
	}

	public static Collection<User> getAllUser() {
		return collectionUser;
	}

	public static Collection<Project> getAllProject() {
		return collectionProject;
	}

	public static Collection<Project> getAllProject(User user) {
		return user.getProject();
	}

	public static User getUser(String lastName) {
		Iterator<User> it = collectionUser.iterator();
		while (it.hasNext()) {
			User user = (User) it.next();
			if (user.lastName == lastName) {
				return user;
			}
		}
		return null;
	}

	public static Collection<User> getUser(User leader) {
		
//		список подчиненных для заданного руководителя (по всем проектам, которыми он руководит);
		
		Collection<User> users = new ArrayList<User>();
		Iterator<Project> it = collectionProject.iterator();
		while (it.hasNext()) {
			Project project = (Project) it.next();
			if (leader == project.getLeader()) {
				Iterator<User> it2 = collectionUser.iterator();
				while (it2.hasNext()) {
					User user2 = (User) it2.next();
					Iterator<Project> it3 = user2.getProject().iterator();
					while (it3.hasNext()) {
						Project project2 = (Project) it3.next();
						if (project2 == project) {
							if(user2!=leader){
								users.add(user2);
							}
						}
					}
				}
			}
		}
		return users;
	}

	public static Collection<User> getUser(Project project) {
		
//		список сотрудников, работающих над заданным проектом;
		
		Collection<User> user = new ArrayList<User>();
		Iterator<User> it = collectionUser.iterator();
		while (it.hasNext()) {
			User ur = (User) it.next();

			if (project == null) {
				if (ur.getProject() == null) {
					user.add(ur);
				}
			} else {
				Iterator<Project> itp = ur.getProject().iterator();
				while (itp.hasNext()) {
					Project project2 = (Project) itp.next();
					if (project2 == project) {
						user.add(ur);
					}
				}
			}
		}
		return user;
	}

	public static Collection<User> getUser() {
		
//		список сотрудников не учавствующих ни в одном проекте
		
		Collection<User> user = new ArrayList<User>();
		Iterator<User> it = collectionUser.iterator();
		while (it.hasNext()) {
			User ur = (User) it.next();
			if (ur.getProject().size() == 0) {
				user.add(ur);
			}
		}
		return user;
	}

	public static Collection<User> getAllUser(String devision) {

		// список сотрудников из заданного отдела, не участвующих ни в одном
		// проекте;

		Collection<User> user = new ArrayList<User>();
		Iterator<User> it = collectionUser.iterator();
		while (it.hasNext()) {
			User ur = (User) it.next();
			if (ur.getDevision() == devision) {
				if (ur.getProject().size() == 0) {
					user.add(ur);
				}
			}
		}
		return user;
	}

	public static Project getProject(String name) {
		Iterator<Project> it = collectionProject.iterator();
		while (it.hasNext()) {
			Project project = (Project) it.next();
			if (project.name == name) {
				return project;
			}
		}
		return null;
	}
	public static Collection<User> getLeader(User user){
		
//		список руководителей для заданного сотрудника (по всем проектам, в которых он участвует);
		
		Collection<User> leaders=new ArrayList<User>();
		Collection<Project> project=user.getProject();
		Iterator<Project> it=project.iterator();
		while (it.hasNext()) {
			Project project2 = (Project) it.next();
			leaders.add(project2.getLeader());			
		}
		return leaders;
	}

	public static void setUser(String lastName, String name, String firstName, String position) {
		collectionUser.add(new User(lastName, name, firstName, position));
	}

	public static void updateUser(User user, boolean value) {
		user.leader = value;
	}
}
