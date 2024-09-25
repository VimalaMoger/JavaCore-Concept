package java5.annotations;


import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


@Documented  //visible in JavaDoc for classes using this annotation
@Inherited  //child class inherits from  a class annotated with this
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) //available at runtime, for inspection via reflection
public @interface CustomAnnotation {
    //defining properties
    String value();
    String name();
    int age();
    String[] newNames() default  {};

}

@CustomAnnotation(value = "123", name = "John", age = 20)
class MyClass{
}

class Subclass extends MyClass{
}

class MainClass {
    public static void main(String[] args) {
        //accessing class level annotation using Reflection
        Class aClass = Subclass.class;
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof CustomAnnotation) {
                System.out.println("name " + ((CustomAnnotation) annotation).name());
                System.out.println("newNames " + Arrays.toString(((CustomAnnotation) annotation).newNames()));
            }
        }

        //accessing method level annotation
        Class animalClass = Animal.class;
        Method method = null;
        Method methodParameter = null;
        Field field = null;
        try {
            method = animalClass.getMethod("say", null);
            methodParameter = animalClass.getMethod("getInput", String.class);
            field = animalClass.getField("myField");
        } catch (NoSuchMethodException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        Annotation[] declaredMethodAnnotations = method.getDeclaredAnnotations();
        for (Annotation annotation : declaredMethodAnnotations) {
            if (annotation instanceof CustomAnnotation) {
                System.out.println("name " + ((CustomAnnotation) annotation).name());
                System.out.println("NewNames " + Arrays.toString(((CustomAnnotation) annotation).newNames()));
            }

        }

        //accessing parameter annotations
        Annotation[][] parameterAnnotations = methodParameter.getParameterAnnotations();

        //Class<?>[] parameterTypes = method.getParameterTypes();
        for (Annotation[] annotationList : parameterAnnotations) {
            for (Annotation annotation : annotationList) {
                if (annotation instanceof CustomAnnotation) {
                    System.out.print("accessing parameter annotations... ");
                    System.out.println("value " + ((CustomAnnotation) annotation).value());
                }
            }
        }

        //accessing Field level annotations
        Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
        for(Annotation annotation : fieldAnnotations){
            if(annotation instanceof CustomAnnotation){
                System.out.print("accessing parameter annotations... ");
                System.out.println("value " + ((CustomAnnotation) annotation).value());
            }
        }

    }
}

class Animal {
    @CustomAnnotation(age = 100, name="someName",  value = "Hello World")
    public String myField = null;

    //method with annotation
    @CustomAnnotation(value = "123", name = "John", age = 20, newNames = {"name1", "name2"})
    public void say() {
    }

    //parameter with annotation
    public void getInput(@CustomAnnotation(value = "ID111", name = "John", age = 20) String parameter) {
    }
}


