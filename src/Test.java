import com.sun.org.glassfish.gmbal.Description;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        try {
            Class<?> catsClass = Class.forName("Cat");

            System.out.println("Cats class is \"" + catsClass.toString() + "\"");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        Class<Cat> catsClass1 = Cat.class;

        System.out.println("Cats class is \"" + catsClass1.toString() + "\"");

        Field[] fields = catsClass1.getDeclaredFields();

        for (Field field : fields)
            System.out.println(field);

        try {
            System.out.println(catsClass1.getField("eyeColor"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println();

        Method[] methods = catsClass1.getDeclaredMethods();

        for (Method method : methods)
            System.out.println(method);

        Cat cat = new Cat("blue", "black", "Fishka");
        Cat cat2 = new Cat("brown", "white", "Barsic");

        System.out.println();

        Class<? extends Cat> catsClass2 = Cat.class;

        try {
            Field eyeColorField = catsClass2.getDeclaredField("eyeColor");
            Field tailColorField = catsClass2.getDeclaredField("tailColor");
            Field catsNameField = catsClass2.getDeclaredField("name");

            tailColorField.setAccessible(true);
            catsNameField.setAccessible(true);

            String catsTail = (String) tailColorField.get(cat);
            String catsEye = (String) eyeColorField.get(cat);
            String catsName = (String) catsNameField.get(cat);

            //Declared - не обязательно

            Annotation[] annotations = catsNameField.getDeclaredAnnotations();
            Description description = catsNameField.getDeclaredAnnotation(Description.class);
            Annotation[] annotattions2 = catsNameField.getDeclaredAnnotationsByType(Description.class);

            System.out.println("Cats eye color is " + catsEye);
            System.out.println("Cats tail color is " + catsTail);
            System.out.println("Cats name is " + catsName);

            System.out.println(catsNameField.getName() + " - is name " + catsNameField.getType() + " - is type " + catsNameField.getModifiers() + " - is modifiers");

            System.out.println();

            System.out.println(Arrays.toString(annotations));
            System.out.println(description);
            System.out.println(Arrays.toString(annotattions2));

            System.out.println();

            catsNameField.set(cat, "Fishunya");
            System.out.println(catsNameField.get(cat));


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
