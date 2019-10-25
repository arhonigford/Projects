import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public final class Tea extends Drink {
    private Ingredient[] ingredients;
    private Type type;

    public Tea(String name, Size size, Type type, Ingredient[] ingredients) throws NullPointerException {
        super(name, getTotalCalories(ingredients, size), getTotalCost(ingredients, size), size.getPrice(), size);
        if (name == null || size == null || type == null || ingredients == null) {
            throw new NullPointerException();
        } else {
            for (Ingredient i : ingredients) {
                if (i == null)
                    throw new NullPointerException();
            }
        }
        this.ingredients = ingredients;
        this.type = type;


    }

    public Tea(String name, int calories, BigDecimal cost, BigDecimal price,
               Size size, Type type, Ingredient[] ingredients) throws NullPointerException, IllegalArgumentException {
        super(name, calories, cost, price, size);
        if (name == null || size == null || type == null || ingredients == null || price == null || cost == null) {
            throw new NullPointerException();
        } else if (calories < 0 || cost.compareTo(BigDecimal.ZERO) < 0 | price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        } else {
            for (Ingredient i : ingredients) {
                if (i == null)
                    throw new NullPointerException();
            }
        }
        this.ingredients = ingredients;
        this.type = type;

    }

    public static int getTotalCalories(Ingredient[] ingredients, Size size) {
        int totalCalories = 0;
        for (Ingredient i : ingredients) {
            totalCalories += i.getCalories();
        }
        totalCalories += size.getCalories();
        return totalCalories;
    }


    public static BigDecimal getTotalCost(Ingredient[] ingredients, Size size) {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (Ingredient i : ingredients) {
            totalCost = totalCost.add(i.getCost());
        }
        totalCost = totalCost.add(size.getCost());
        return totalCost;
    }

    public Type getType() {
        return type;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public boolean equals(Object object) {
        if (object instanceof Tea) {
            if (((Tea) object).getType().equals(type)) {
                if (((Tea) object).getSize().equals(getSize())) {
                    if (((Tea) object).getIngredients().length == ingredients.length) {
                        int count = 0;
                        for (Ingredient i : ((Tea) object).getIngredients()) {
                            if (i.equals(ingredients[count])) {
                                count++;
                            } else {
                                return false;
                            }
                        }
                        return count == ingredients.length;

                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        String s = "Tea[" + getName() + ", " + getCalories() + ", " +
                getCost() + ", " + getPrice() + ", " + getSize() + ", " +
                getType() + ", " + Arrays.toString(getIngredients()) + "]";
        return s;
    }
}
