package general;

public enum Vars {
	CREATE_OBJECT("�������� ������ ������ ");
	
	private String abbreviation;
	private Vars(String abbreviation){
		this.abbreviation=abbreviation;
	}
	public String getAbbreviation(){
		return abbreviation;
	}
}
