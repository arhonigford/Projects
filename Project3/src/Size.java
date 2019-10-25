import javax.swing.text.StyleContext;
import java.math.BigDecimal;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public enum Size implements Consumable, Sellable {
    SMALL(5, BigDecimal.valueOf(0.2), BigDecimal.valueOf(2.85)),
    MEDIUM(10, BigDecimal.valueOf(0.3), BigDecimal.valueOf(3.45)),
    LARGE(15, BigDecimal.valueOf(0.4), BigDecimal.valueOf(4.05));
    private int calories;
    private BigDecimal cost;
    private BigDecimal price;


    private Size(int calories, BigDecimal cost, BigDecimal price) {
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
