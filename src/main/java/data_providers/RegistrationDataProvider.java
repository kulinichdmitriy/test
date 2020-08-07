package data_providers;

import core.data_models.UserModel;
import org.testng.annotations.DataProvider;

import java.util.Date;

public class RegistrationDataProvider {

    @DataProvider(name = "regDataProvider")
    public static Object[][] regDataProvider() {
        UserModel userModelMale = new UserModel();
        userModelMale.setGenger("male");
        userModelMale.setSexualOrientation("hetero");
        userModelMale.setPassword("asdqwe123");
        userModelMale.setAge(20);
        userModelMale.setEmail("dmitriykulinich" + (new Date()).getTime() + "@maildrop.ropot.net");

        return new Object[][]{
                {userModelMale}

        };
    }
}
