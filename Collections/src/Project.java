public class Project {

	String name; 
	String customer;
	User leader;

	public Project(String name, User leader, String customer) {
		this.name = name;
		this.leader = leader;
		this.customer = customer;
	}
	public User getLeader(){
		return leader;
	}
	public String toString() {
		return name + " " + leader + " " + customer;
	}
}
