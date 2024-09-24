package java5.enumExamples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEnumConstant {

	@Test
	void test() {
			String input = " hello";
		    String expectedToUpper = " HELLO";
		    String expectedReverse = "olleh ";
		    String expectedTrim = "hello";
		    String expectedBase64 = "IGhlbGxv";
		    String expectedMd5 = "292a5af68d31c10e31ad449bd8f51263";
		    Application app = new Application();
		    
		    assertEquals(expectedTrim,app.applyOperation(EnumBasics.TRIM, input));
		    assertEquals(expectedToUpper,app.applyOperation(EnumBasics.TO_UPPER, input));
		    assertEquals(expectedReverse,app.applyOperation(EnumBasics.REVERSE, input));
		    assertEquals(expectedBase64,app.applyOperation(ExtendingEnum.BASE64_ENCODE, input));
	}

}
