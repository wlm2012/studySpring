package com.study.utils.reflect;

import com.study.utils.entity.Person;
import com.study.utils.entity.Teacher;
import com.study.utils.entityEnum.Inquired;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
public class ReflectClass {

    public static void test() {
        Class<Inquired> class1 = Inquired.class;
        String name = class1.getName();
        System.out.println(name);
    }

    public static void testClassLoader() throws ClassNotFoundException {
        //1、获取一个系统的类加载器（可以获取,当前这个类就是它加载的）
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //2、获取系统类加载器的父类加载器（扩展加载器，可以获取）
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //3、获取扩展类加载器（引导类加载器，不可获取）
        ClassLoader parentParent = parent.getParent();
        System.out.println(parentParent);

        //4、测试当前类是那个类加载器加载的（系统加载器，可以获取）
        ClassLoader classLoader = Class.forName("com.study.utils.reflect.ReflectClass").getClassLoader();
        System.out.println(classLoader);

        //5、测试JDK提供的Object类 由那个类加载器加载的（引导类，不可获取）
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);
    }


    public static void testClass() throws ClassNotFoundException {

        //通过这个类的全限定名称 （包名+这个类的类名）Class.forName来获取
        System.out.println(Class.forName("com.study.utils.entity.Person"));
        //通过实例来获取
        Person person = new Person();
        System.out.println(person.getClass());
        //通过类名获取
        System.out.println(Person.class);
        //获取所有的构造器
        System.out.println(Arrays.toString(Person.class.getConstructors()));
    }

    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.study.utils.entity.Person");

        // getConstructors 只有public constructors
        log.info("getConstructors 只有public constructors");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        log.info("getDeclaredConstructors  所有构造器");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }

        log.info("使用private的构造器，构造实例, 需要setAccessible(true)，否则不需要");
        Constructor<?> privateConstructor = clazz.getDeclaredConstructor(String.class, int.class);
        privateConstructor.setAccessible(true);
        Person person = (Person) privateConstructor.newInstance("wlm", 11);
        String name = person.getName();
        System.out.println(name);
        System.out.println(person.getOld());
        person.printName();

    }

    public static void testMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.study.utils.entity.Teacher");
        log.info("获取该类和所有父类的public方法，重要：只有public方法");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        log.info("获取该类的所有方法，包括私有方法,不包括从父类继承过来的任何方法");
        methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        log.info("获取private static 方法 ，需要setAccessible(true) ，并且obj参数无用，可以为null");
        //For a static method, the first parameter is ignored, you can set it to null
        Method method = clazz.getDeclaredMethod("getClazz", long.class);
        method.setAccessible(true);
        long invoke = (long) method.invoke(null, 3);
        System.out.println("invoke: " + invoke);


        log.info("public 成员方法调用");
        Person person = (Person) clazz.getConstructor().newInstance();
        Method printYear = clazz.getMethod("printYear", String.class);
        printYear.invoke(person, "2020");

    }


    public static void testField() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.study.utils.entity.Teacher");

        log.info("获取该类的所有字段，但不能获取父类字段");
        Field[] fields1 = c1.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }

        log.info("获取该类和父类所有的public字段");
        fields1 = c1.getFields();
        for (Field field : fields1) {
            System.out.println(field);
        }


        var harry = (Teacher) c1.getConstructor(String.class, int.class, String.class, long.class).newInstance("Harry", 14, "1", 100);
        //change the value of "students", 100->20
        System.out.println(harry.getStudents());
        Field sex = c1.getDeclaredField("students");
        sex.setAccessible(true);
        sex.set(harry, 20);
        System.out.println(harry.getStudents());


        //static field  set xxx.class or object，实例字段只能通过实例赋值
        System.out.println(harry.getLike());
        Field like = c1.getField("like");

        like.set(Person.class, "kde");
        System.out.println(harry.getLike());

        like.set(harry, "unix");
        System.out.println(harry.getLike());


        //获取field字段的值
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object s = field.get(harry);
            System.out.println(field + " : " + s);
        }

    }


    public static void printField(Class<Person> c1) {
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            String modifier = Modifier.toString(c1.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(modifier + "   ");
            }
            System.out.println(field.getType().getName() + "   " + field.getName());
        }
    }

    public static void ResourceTest() throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.study.utils.entity.Person");
        // /C:/study_java/studySpring/utils/target/classes/com/study/utils/entity/
        String path = Objects.requireNonNull(c1.getResource("")).getPath();
        System.out.println(path);
        //  /C:/study_java/studySpring/utils/target/test-classes/
        path = Objects.requireNonNull(c1.getResource("/")).getPath();
        System.out.println(path);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] copyArray(T[] array, int newLength) {
        Class<?> c1 = array.getClass();
        if (!c1.isArray()) {
            return null;
        }
        Class<?> type = c1.getComponentType();
        int length = Array.getLength(array);
        // Unchecked cast: 'java.lang.Object' to 'T[]'
        T[] newArray = (T[]) Array.newInstance(type, newLength);

        System.arraycopy(array, 0, newArray, 0, Math.min(newLength, length));
        return newArray;
    }

    public static void GenericTest() throws NoSuchFieldException {
        Class<Teacher> clazz = Teacher.class;
        Field score = clazz.getDeclaredField("score");
        Class<?> type = score.getType();
        System.out.println("getType "+type);
        Type genericType = score.getGenericType();
        if (genericType instanceof ParameterizedType parameterizedType){
            Type rawType = parameterizedType.getRawType();
            System.out.println("rawType "+ rawType);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("泛型类型是：" + actualTypeArgument);
            }
        }
    }


}
