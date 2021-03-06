package Student_Database_Ex7;

public class Student {
	private int id;
	private String firstname;
	private String lastname;
	private String streetaddress;
	private String postoffice;
	private int postcode;
	public Student() {
		id = -1;
		firstname="";
		lastname="";
		streetaddress="";
		postcode = -1;
		postoffice="";
	}
	public Student(int id, String firstname, String lastname, String streetaddress, int postcode,String postoffice) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.streetaddress = streetaddress;
		this.postoffice = postoffice;
		this.postcode = postcode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public String getPostoffice() {
		return postoffice;
	}
	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
}
