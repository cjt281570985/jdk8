package ssy.reflect;

import com.google.common.collect.Lists;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import jdk8.stream3.Student;

public class ReflectTest {
	
	
	public Object copyCustomer(Object sourceObj) throws Exception{
		Class<?> classType = sourceObj.getClass();
		Field[] fields = classType.getDeclaredFields();
		
		Constructor cons = classType.getConstructor(new Class[]{});
		Object objectcopy = cons.newInstance(new Object[]{});
		//Object objectcopy = classType.newInstance();  //此行可替代上面2行,无参构造时
		
		for (Field field : fields) {
			String fieldName = field.getName();
			String methodGet = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
			String methodSet = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
			
			Method getMethod = classType.getMethod(methodGet, new Class[]{});
			Method setMethod = classType.getMethod(methodSet, new Class[]{field.getType()});
			
			Object value = getMethod.invoke(sourceObj, new Object[]{});
			setMethod.invoke(objectcopy, new Object[]{value});
		}
		System.out.println("----------------------------");
		
		return objectcopy;
	}

	public static Object getFilds(Object obj) throws Exception{
		List<String> list = Lists.newArrayList();
		Class<?> classType = obj.getClass();
		Field[] fields = classType.getDeclaredFields();

		for (Field field : fields) {
			list.add(field.getName());
		}
		System.out.println(list);
		return list;
	}
	

	public static void main(String[] args) throws Exception{
		ReflectTest ts = new ReflectTest();
		//Object object = ts.copyCustomer(new Customer());
		//System.out.println(((Customer)object).getName());
		
		Customer cus = new Customer("吉米", 32);
		cus.setId("cjtid");
		Object object = ts.copyCustomer(cus);
		System.out.println(object);

		System.out.println("--------------------------------");

		ReflectTest.getFilds(Customer.class);
	}

}


class Customer {
	private String id;
	private String name;
	private int age;
	
	public Customer() {
		
	}
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}