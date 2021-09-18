package com.study.springcodeanalyze;

import com.study.springcodeanalyze.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    @Test
    public void TestSimpleLoad() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("META-INF/dependency-lookup-context.xml"));
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
//        ArrayList<User> users=new ArrayList<>();
//        users.remove(0);
        BeanFactory bf = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        User user1 = (User) bf.getBean("user");
        System.out.println(user1);

    }
}
