package core.data_models;

public class UserModel {

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

    public UserModel setAge(int age) {
	this.age = age;
	return this;
    }

    public UserModel setPassword(String asdasd123) {
	this.password = password;
	return this;
    }

    public UserModel setGenger(String male) {
	this.gender = gender;
	return this;
    }

    public UserModel setSexualOrientation(String hetero) {
	this.sexualOrientation = sexualOrientation;
	return this;
    }

    public UserModel setEmail(String s) {
	this.email = email;
	return this;
    }

    public UserModel setLocation(String s) {
	this.location = location;
	return this;
    }
}
