package core.data_models;

public class UserModel {

    private String email;
    private String password;
    private String gender;
    private String sexualOrientation;
    private int age = 21;
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

    public UserModel setPassword() {
	this.password = password;
	return this;
    }

    public UserModel setGenger() {
	this.gender = gender;
	return this;
    }

    public UserModel setSexualOrientation() {
	this.sexualOrientation = sexualOrientation;
	return this;
    }

    public UserModel setEmail() {
	this.email = email;
	return this;
    }

    public UserModel setLocation() {
	this.location = location;
	return this;
    }
}
