package Student_Database_Ex7;

public class Student {
	private int id;
	private String lastName;
	private String firstName;
	private String street;
	private String postOffice;
	private int postCode;
	public Student() {
		id = -1;
		lastName="";
		firstName="";
		street="";
		postCode = -1;
		postOffice="";
	}
	public Student(int id, String lastname, String firstname, String street, int postcode,String postoffice) {
		super();
		this.id = id;
		this.lastName = lastname;
		this.firstName = firstname;
		this.street = street;
		this.postOffice = postoffice;
		this.postCode = postcode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostoffice() {
		return postOffice;
	}
	public void setPostoffice(String postoffice) {
		this.postOffice = postoffice;
	}
	public int getPostcode() {
		return postCode;
	}
	public void setPostcode(int postcode) {
		this.postCode = postcode;
	}
	public String toString() {
		return id + " " + firstName + " " + lastName;
	}

}
