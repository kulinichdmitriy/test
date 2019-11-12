package core.data_models;

public class RunMe {
    public static void main(String[] args) {
	// Зполняем модель C return this
	UserModelWithReturnThis model1 = new UserModelWithReturnThis();
	model1.setAge(33);
	model1.setEmail("a1");
	model1.setGenger("b1");
	model1.setLocation("c1");
	model1.setPassword("d1");
	model1.setSexualOrientation("c1");

	// Зполняем модель БЕЗ return this
	UserModelWithOutReturnThis model2 = new UserModelWithOutReturnThis();
	model2.setAge(22);
	model2.setEmail("a");
	model2.setGenger("b");
	model2.setLocation("c");
	model2.setPassword("d");
	model2.setSexualOrientation("c");

	// Вывод моделей
	System.out.println(model1.toString());
	System.out.println("\n");
	System.out.println(model2.toString());

	// Зполняем "сокращенный вариант" модель C return this
	UserModelWithReturnThis model3 = new UserModelWithReturnThis();
	model3
			.setAge(33)
			.setEmail("a1")
			.setGenger("b1")
			.setLocation("c1")
			.setPassword("d1")
			.setSexualOrientation("c1");

    }
}
