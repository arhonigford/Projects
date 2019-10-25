import java.math.BigDecimal;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public class FoodProduct extends Object implements Identifiable, Consumable, Sellable {
    private String name;
    private int calories;
    private BigDecimal cost;
    private BigDecimal price;

    public FoodProduct(String name, int calories, BigDecimal cost, BigDecimal price)
            throws NullPointerException, IllegalArgumentException {
        if (name == null || cost == null || price == null) {
            throw new NullPointerException();
        } else if (calories < 0 || cost.compareTo(BigDecimal.ZERO) < 0 | price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.calories = calories;
            this.cost = cost;
            this.price = price;
        }
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getCost() {
        return this.cost;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    public boolean equals(Object object) {
        if (object instanceof FoodProduct) {
            if (((FoodProduct) object).getName().equals(this.name))
                if (((FoodProduct) object).getCalories() == this.calories)
                    if (((FoodProduct) object).getCost().compareTo(this.cost) == 0)
                        return (((FoodProduct) object).getPrice().compareTo(this.price) == 0);

        }

        return false;

    }

    public String toString() {
        String s = "FoodProduct[" + getName() + ", " + getCalories() + ", " + getCost() + ", " + getPrice() + "]";
        return s;
    }
}
