package test_suites;

import core.data_models.UserModel;
import data_providers.RegistrationDataProvider;
import org.testng.annotations.Test;
import test_objects.RegistrationTest;

import static core.ApplicationManager.app;

public class RegistrationTS extends TestSuiteBase {

    RegistrationTest reg = new RegistrationTest();

    @Test(dataProvider = "regDataProvider", dataProviderClass = RegistrationDataProvider.class, priority = 1)
    public void registration(UserModel userModel) {

        reg.registration(userModel);
        app().rest().clearCookie();
    }

    @Test(dependsOnMethods = {"registration"})
    public void confirm() {
        reg.confirmation();

    }
}
