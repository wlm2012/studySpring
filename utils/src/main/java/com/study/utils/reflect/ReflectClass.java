package com.study.utils.reflect;

import com.study.utils.entity.Person;
import com.study.utils.entityEnum.Inquired;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.Arrays;

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
        Person person = (Person)clazz.getConstructor().newInstance();
        Method printYear = clazz.getMethod("printYear", String.class);
        printYear.invoke(person, "2020");

    }

    public static void ResourceTest() throws ClassNotFoundException, IOException {
        Class<Person> c1 = (Class<Person>) Class.forName("com.study.utils.entity.Person");
        //create 1.txt under Person.class fold for test
        System.out.println(c1.getResource("1.txt"));
        InputStream inputStream = c1.getResourceAsStream("1.txt");
        StringBuffer stringBuffer = new StringBuffer();
        byte[] buf = new byte[1024 * 10];
        int temp;
        while ((temp = inputStream.read(buf)) > 0) {
            stringBuffer.append(new String(buf, 0, temp));
        }
        System.out.println(stringBuffer);

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

    public static void setAndGetField() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> c1 = (Class<Person>) Class.forName("wlm.entity.Person");
        var harry = c1.getConstructor(String.class, int.class, String.class).newInstance("Harry", 14, "1");

        //change the value of "sex", 1->2
        Field sex = c1.getDeclaredField("sex");
        sex.set(harry, "2");

        //change the value of "name" , Harry->potter
        Field name = c1.getDeclaredField("name");
        //private field ,need setAccessible(true)
        name.setAccessible(true);
        name.set(harry, "potter");

        //static field  set xxx.class or object
        Field like = c1.getDeclaredField("like");
        like.set(Person.class, "kde");
        like.set(harry, "unix");

        /**
         * output:
         * potter
         * 14
         * 2
         */
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object s = field.get(harry);
            System.out.println(s);
        }

    }


    public static Object copyArray(Object a, int newLength) {
        Class c1 = a.getClass();
        if (!c1.isArray()) {
            return null;
        }
        Class type = c1.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(type, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(newLength, length));
        return newArray;
    }
}
