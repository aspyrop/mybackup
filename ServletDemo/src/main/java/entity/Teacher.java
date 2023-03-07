package entity;

public class Teacher {

	private int id;
	private String surname;
	private String name;
	private int subjectID;
	
	public Teacher() {

	}

	public Teacher(int id, String surname, String name, int subjectID) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.subjectID = subjectID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", surname=" + surname + ", name=" + name + ", subjectID=" + subjectID + "]";
	}
	
}
