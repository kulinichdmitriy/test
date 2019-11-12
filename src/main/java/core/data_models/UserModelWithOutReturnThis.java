package core.data_models;

public class UserModelWithOutReturnThis {

    private String email;
    private String password;
    private String gender;
    private String sexualOrientation;
    private int age;
    private String location;

    public String getEmail() {
	return email;
    }

    public String getPassword() {
	return password;
    }

    public String getGender() {
	return gender;
    }

    public String getSexualOrientation() {
	return sexualOrientation;
    }

    public int getAge() {
	return age;
    }

    public String getLocation() {
	return location;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setGenger(String gender) {
	this.gender = gender;
    }

    public void setSexualOrientation(String sexualOrientation) {
	this.sexualOrientation = sexualOrientation;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String toString() {
	return "email=" + email + "\n"
			+ "password=" + password + "\n"
			+ "password=" + password + "\n"
			+ "gender=" + gender + "\n"
			+ "sexualOrientation=" + sexualOrientation + "\n"
			+ "age=" + age + "\n"
			+ "location=" + location;
    }
}
