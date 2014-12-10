import java.util.ArrayList;
import java.util.Collection;

public class User {
	/*
	 * LastName - фамилия 
	 * FirstName - отчество 
	 * Name - имя Position - должность
	 */
	String firstName, lastName, name, devision;
	Collection<Project> project = new ArrayList<Project>();
	boolean leader;

	User(String lastName, String name, String firstName, String devision) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = name;
		this.devision = devision;
	}

	public void addNewProject(Project project) {
		this.project.add(project);
		UserHelper.addProject(project);
	}

	public void addProject(Project project) {
		this.project.add(project);
	}
	
	public void removeProject(Project project) {
		this.project.remove(project);
	}

	public String getDevision() {
		return this.devision;
	}

	public Collection<Project> getProject() {
		return this.project;
	}

	public String toString() {
		if (devision == null) {
			return lastName + " " + name + " " + firstName;
		} else {
			return lastName + " " + name + " " + firstName + " " + devision;
		}
	}
}
