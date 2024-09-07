package java1.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class simpleJunitTester {
	public int execute(Class clazz) throws Exception{
		
		int failedCount =0 ;
		Object object =null;
		Method[]  m=null;
		try {
			object = clazz.newInstance();
			m =  clazz.getDeclaredMethods();
		}catch(InstantiationException e) {
			System.out.println("cant instansiate");
		}catch(IllegalAccessException e) {
			System.out.println("cant access");
		}
			
			for(Method method : m) {
				if(!method.getName().startsWith("test")) {
					failedCount += 1;
				}
			}
		return failedCount;
	}

	public static void main(String[] args) {
		Class<Reflection> clazz = Reflection.class;
		
		int failedCount =0 ;
		Object object =null;
		
		try {
			object = clazz.newInstance();
			Method[] m =  clazz.getDeclaredMethods();
			Arrays.stream(m).forEach(System.out::println);
			
			for(Method method : m) {
				if(!(method.getName().startsWith("test") && method.getReturnType() == boolean.class)) {
					
					failedCount++;
				}
			}
		}catch(InstantiationException e) {
			System.out.println("cant instansiate");
		}catch(IllegalAccessException e) {
			System.out.println("cant access");
		}
		System.out.println(failedCount);
	}
}
