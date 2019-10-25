import java.math.BigDecimal;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public final class Employee extends Person implements Employable {
    private BigDecimal hourlyWage;

    public Employee(String name, int age, BigDecimal hourlyWage) throws NullPointerException, IllegalArgumentException {
        super(name, age);
        if (name == null || hourlyWage == null) {
            throw new NullPointerException();
        } else if (age < 0 || hourlyWage.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        this.hourlyWage = hourlyWage;


    }

    @Override
    public BigDecimal getHourlyWage() {
        return this.hourlyWage;
    }

    @Override
    public void setHourlyWage(BigDecimal hourlyWage) throws NullPointerException, IllegalArgumentException {
        if (hourlyWage == null) {
            throw new NullPointerException();
        } else if (hourlyWage.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        this.hourlyWage = hourlyWage;

    }

    public boolean equals(Object object) {
        if (object instanceof Employee) {
            if (((Employee) object).getAge() == getAge())
                if (((Employee) object).getName().equals(getName()))
                    return ((Employee) object).getHourlyWage().compareTo(getHourlyWage()) == 0;
        }
        return false;
    }

    public String toString() {
        String s = "Employee[" + getName() + ", " + getAge() + ", "
                + getHourlyWage() + "]";
        return s;
    }
}
