import java.math.BigDecimal;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public class Drink extends FoodProduct {
    private Size size;

    public Drink(String name, Size size) throws NullPointerException {
        super(name, size.getCalories(), size.getCost(), size.getPrice());
        if (name == null || size == null) {
            throw new NullPointerException();
        }
        this.size = size;
    }

    public Drink(String name, int calories, BigDecimal cost, BigDecimal price, Size size)
            throws NullPointerException, IllegalArgumentException {
        super(name, calories, cost, price);
        if (size == null)
            throw new NullPointerException();
        this.size = size;
    }


    public Size getSize() {
        return this.size;
    }

    public boolean equals(Object object) {
        if (object instanceof Drink)
            if (((Drink) object).getName().equals(getName()))
                if (((Drink) object).getPrice().compareTo(getPrice()) == 0)
                    return ((Drink) object).getCost().compareTo(getCost()) == 0;
        return false;
    }

    public String toString() {
        String s = "Drink[" + getName() + ", " + getCalories() + ", " +
                getCost() + ", " + getPrice() + ", " + size + "]";
        return s;
    }
}
