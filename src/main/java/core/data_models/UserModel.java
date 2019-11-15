package core.data_models;

import com.google.common.base.Strings;
import org.testng.TestException;

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
	if (Strings.isNullOrEmpty(email)) {
	    throw new TestException(this.getClass().getName() + " email is not defined");
	}
	this.email = email;
	return this;
    }

    public String getPassword() {
	return password;
    }

    public UserModel setPassword(String password) {
	if (Strings.isNullOrEmpty(password)) {
	    throw new TestException(this.getClass().getName() + " password is not defined");
	}
	this.password = password;
	return this;
    }

    public String getGender() {
	return gender;
    }

    public UserModel setGenger(String gender) {
	if (Strings.isNullOrEmpty(gender)) {
	    throw new TestException(this.getClass().getName() + " gender is not defined");
	}
	this.gender = gender;
	return this;
    }

    public String getSexualOrientation() {
	return sexualOrientation;
    }

    public UserModel setSexualOrientation(String sexualOrientation) {
	if (Strings.isNullOrEmpty(sexualOrientation)) {
	    throw new TestException(this.getClass().getName() + " sexualOrientation is not defined");
	}
	this.sexualOrientation = sexualOrientation;
	return this;
    }

    public int getAge() {
	return age;
    }

    public UserModel setAge(int age) {
	if (age <= 18 || age >= 79) {
	    throw new TestException(this.getClass().getName() + " age is not defined");
	}
	this.age = age;
	return this;
    }

    public String getLocation() {
	return location;
    }

    public UserModel setLocation(String location) {
	if (Strings.isNullOrEmpty(location)) {
	    throw new TestException(this.getClass().getName() + " location is not defined");
	}
	this.location = location;
	return this;
    }

    public String getAutologinKey() {
	return autologinKey;
    }

    public UserModel setAutologinKey(String autologinKey) {
	if (Strings.isNullOrEmpty(autologinKey)) {
	    throw new TestException(this.getClass().getName() + " autologinKey is not defined");
	}
	this.autologinKey = autologinKey;
	return this;
    }

    public String getCsrfToken() {
	return csrfToken;
    }

    public UserModel setCsrfToken(String csrfToken) {
	if (Strings.isNullOrEmpty(csrfToken)) {
	    throw new TestException(this.getClass().getName() + " setCsrfToken is not defined");
	}
	this.csrfToken = csrfToken;
	return this;
    }
}