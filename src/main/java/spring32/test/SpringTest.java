package spring32.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-07-15 14:48
 */
public class SpringTest {


  public static void main(String[] args) {

    ClassPathResource resource = new ClassPathResource("beans.xml");
    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
    reader.loadBeanDefinitions(resource);

    Person person = (Person) factory.getBean("person");
    System.out.println(person.say());
    Person person2 = (Person) factory.getBean("person");

    System.out.println(person == person2);

  }

}
