package basic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-11 16:15
 */
public class TestClone1 {

    public static void main(String[] args) throws Exception {
        User user = new User(18, "吉米");
        User clone = (User)user.clone();

        System.out.println(clone);
        System.out.println("--------------------------------");
        user.setName("jimmy");

        System.out.println(user);
        System.out.println(clone);
    }

}


//需要实现 Cloneable  和 重写 clone()
class User implements Cloneable {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return this.name + ", " + age;
    }
}