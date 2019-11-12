package core.data_models;

public class UserModelWithReturnThis {

    private String email;
    private String password;
    private String gender;
    private String sexualOrientation;
    private int age;
    private String location;

    public String getEmail() {
	return email;
    }

    public UserModelWithReturnThis setEmail(String email) {
	this.email = email;
	return this;
    }

    public String getPassword() {
	return password;
    }

    public UserModelWithReturnThis setPassword(String password) {
	this.password = password;
	return this;
    }

    public String getGender() {
	return gender;
    }

    public String getSexualOrientation() {
	return sexualOrientation;
    }

    public UserModelWithReturnThis setSexualOrientation(String sexualOrientation) {
	this.sexualOrientation = sexualOrientation;
	return this;
    }

    public int getAge() {
	return age;
    }

    public UserModelWithReturnThis setAge(int age) {
	this.age = age;
	return this;
    }

    public String getLocation() {
	return location;
    }

    public UserModelWithReturnThis setLocation(String location) {
	this.location = location;
	return this;
    }

    public UserModelWithReturnThis setGenger(String gender) {
	this.gender = gender;
	return this;
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
