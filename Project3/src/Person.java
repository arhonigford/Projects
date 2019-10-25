import java.io.Serializable;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public class Person extends Object implements Identifiable, Serializable {
    private int age;
    private String name;

    public Person(String name, int age) throws NullPointerException, IllegalArgumentException {
        if (name == null)
            throw new NullPointerException();
        else if (age < 0)
            throw new IllegalArgumentException();

        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object object) {
        if (object instanceof Person) {
            if (((Person) object).getName().equals(name))
                if (((Person) object).getAge() == age) {
                    return true;
                }
        }
        return false;
    }

    public String toString() {
        String s = "Person[" + getName() + ", " + getAge() + "]";
        return s;

    }


}
