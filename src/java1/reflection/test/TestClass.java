
package java1.reflection.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

public class TestClass {
	@Test
	public void test() {
            model.sortBookData.Book book = new model.sortBookData.Book("Effective Java-1", "Joshua Bloch", 2001);
		     Method[] methods = book.getClass().getDeclaredMethods();

		      for ( int i = 0; i < methods.length; i++ ) {
		         if (methods[i].getName().equals("getYear")) {
		            methods[i].setAccessible( true );
					 System.out.println(methods[i]);
		            try {
		               int value = (int) methods[i].invoke( book, null );
		               assertEquals( 2001, value );
		            } catch (Exception e) {
		               fail( e.getMessage() );
		            }
		         }
		      }

	}

}
