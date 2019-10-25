import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public enum Ingredient implements Consumable, Sellable {
    CREAM(40, BigDecimal.valueOf(.05), BigDecimal.ZERO),
    SUGAR(16, BigDecimal.valueOf(0.01), BigDecimal.ZERO);
    private int calories;
    private BigDecimal cost;
    private BigDecimal price;

    private Ingredient(int calories, BigDecimal cost, BigDecimal price) {
        this.calories = calories;
        this.cost = cost;
        this.price = price;
    }


    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public BigDecimal getCost() {
        return this.cost;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

}
