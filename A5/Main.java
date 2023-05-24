import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Apple {
	private void repair(int cost) {
		System.out.println("Repairing" + cost);
	}
}

interface reflect {
}

public class Main {

	public static void main(String[] args) throws Exception {

		Class c = Class.forName("Apple");

		Apple apple = (Apple) c.newInstance();
		Apple apple1 = (Apple) c.newInstance();

		Method m = c.getDeclaredMethod("repair", int.class);
		m.setAccessible(true);
		m.invoke(apple, 30);

	}
}
