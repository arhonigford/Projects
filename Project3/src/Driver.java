import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        Ingredient[] ingredients = new Ingredient[4];
        ingredients[0] = Ingredient.CREAM;
        ingredients[1] = Ingredient.CREAM;
        ingredients[2] = Ingredient.SUGAR;
        ingredients[3] = Ingredient.SUGAR;
        Coffee c = new Coffee("Logan's Coffee", Size.MEDIUM, Roast.MEDIUM, ingredients);
        Coffee c2 = new Coffee("Logan's Coffee", Size.MEDIUM, Roast.MEDIUM, ingredients);
        System.out.println(c.equals(c2));

        Cafe cafe = new Cafe();
        Random random = new Random();
        cafe.open(4, random);
        Cafe cafe2 = new Cafe();
        cafe.open(4, random);
        System.out.println(cafe.equals(cafe2));
        Cafe cafe3 = new Cafe();
        cafe3.sellFoodProduct(c);
        Cafe cafe4 = new Cafe();
        cafe4.sellFoodProduct(c);
        System.out.println(cafe3.equals(cafe4));
        System.out.println(cafe3.getExpenses());
        System.out.println(cafe3.getRevenue());
        System.out.println(cafe4.getExpenses());
        System.out.println(cafe4.getRevenue());
        System.out.println(cafe3.getEmployees().size());
    }
}
