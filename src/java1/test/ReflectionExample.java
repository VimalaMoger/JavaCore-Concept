package java1.test;

import java1.reflection.Reflection;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertFalse;

public class ReflectionExample {

	Class<Reflection> clazz = Reflection.class;

	@Before
	public void setUp() {
	}

	@Test
	public void test() {
		Method[] methods = clazz.getDeclaredMethods();
		for(int i=0;i<methods.length;i++) {
			boolean bool = methods[i].getReturnType().equals(boolean.class) && methods[i].getName().startsWith("test");
			assertFalse(String.valueOf(bool), false);
		}
 	}
}