package cnwir.com.baseprj.domain;

/**
 * Created by cfp on 15-9-25.
 */
public class Person {

    private int _id;

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "_id=" + _id +
                ", info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
