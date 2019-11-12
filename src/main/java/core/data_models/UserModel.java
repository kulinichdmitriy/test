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

    public UserModel setPassword(String password) {
	this.password = password;
	return this;
    }

    public UserModel setGenger(String gender) {
	this.gender = gender;
	return this;
    }

    public UserModel setSexualOrientation(String sexualOrientation) {
	this.sexualOrientation = sexualOrientation;
	return this;
    }

    public UserModel setEmail(String email) {
	this.email = email;
	return this;
    }

    public UserModel setLocation(String location) {
	this.location = location;
	return this;
    }
}
