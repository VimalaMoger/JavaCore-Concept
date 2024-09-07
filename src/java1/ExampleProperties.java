package java1;

import java.util.Properties;
import java.util.Set;

public class ExampleProperties {

	public static void main(String[] args) {

		//default list
		Properties properties = new Properties();
		properties.put("Florida", "Tallahassee");

		Properties capitals = new Properties(properties);
		capitals.put("Texas", "Austin");
		capitals.put("Indiana", "Indianapolis");
		Set states =capitals.keySet();
		for(Object name: states) {
			System.out.println(name +"'s capital is "+ capitals.getProperty((String) name));
		}
		System.out.println(capitals.getProperty("Florida"));
	}
}
