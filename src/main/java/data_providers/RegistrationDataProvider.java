package data_providers;

import core.data_models.UserModel;
import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {

    @DataProvider(name = "regDataProvider")
    public static Object[][] regDataProvider() {
	UserModel userModelMale = new UserModel();
	userModelMale.setGenger("male");
	userModelMale.setSexualOrientation("hetero");
	userModelMale.setPassword("123456");
	userModelMale.setAge(20);

	UserModel userModelFemale = new UserModel();
	userModelFemale.setGenger("female");
	userModelFemale.setSexualOrientation("homo");
	userModelFemale.setPassword("asdqwe");
	userModelFemale.setAge(50);

	return new Object[][] {
			{ userModelMale },
			{ userModelFemale },
	};
    }
}
