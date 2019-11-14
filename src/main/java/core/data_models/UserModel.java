package core.data_models;

public class UserModel {

    private String email;
    private String password;
    private String gender;
    private String sexualOrientation;
    private int age;
    private String location;
    private String autologinKey;
    private String csrfToken;

    public String getEmail() {
	return email;
    }

    public UserModel setEmail(String email) {
	this.email = email;
	return this;
    }

    public String getPassword() {
	return password;
    }

    public UserModel setPassword(String password) {
	this.password = password;
	return this;
    }

    public String getGender() {
	return gender;
    }

    public UserModel setGenger(String gender) {
	this.gender = gender;
	return this;
    }

    public String getSexualOrientation() {
	return sexualOrientation;
    }

    public UserModel setSexualOrientation(String sexualOrientation) {
	this.sexualOrientation = sexualOrientation;
	return this;
    }

    public int getAge() {
	return age;
    }

    public UserModel setAge(int age) {
	this.age = age;
	return this;
    }

    public String getLocation() {
	return location;
    }

    public UserModel setLocation(String location) {
	this.location = location;
	return this;
    }

    public String getAutologinKey() {
	return autologinKey;
    }

    public UserModel setAutologinKey(String autologinKey) {
	this.autologinKey = autologinKey;
	return this;
    }

    public String setcsrfToken(String csrfToken) {
	return csrfToken;
    }

    public UserModel getcsrfToken(String csrfToken) {
	this.csrfToken = csrfToken;
	return this;
    }
}
