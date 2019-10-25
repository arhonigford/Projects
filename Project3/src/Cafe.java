import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public final class Cafe extends Object implements Serializable {
    private ArrayList<Employee> employees;
    private BigDecimal expenses;
    private BigDecimal revenue;

    public Cafe() {
        expenses = BigDecimal.ZERO;
        revenue = BigDecimal.ZERO;
        employees = new ArrayList<>();
    }

    public static FoodProduct makeFoodProduct(String name, int calories, BigDecimal cost, BigDecimal price)
            throws NullPointerException, IllegalArgumentException {
        FoodProduct fp = new FoodProduct(name, calories, cost, price);
        return fp;
    }

    public static Coffee makeCoffee(String name, Size size, Roast roast, Ingredient[] ingredients)
            throws NullPointerException {
        Coffee c = new Coffee(name, size, roast, ingredients);
        return c;
    }

    public static Tea makeTea(String name, Size size, Type type, Ingredient[] ingredients)
            throws NullPointerException {
        Tea t = new Tea(name, size, type, ingredients);
        return t;
    }

    public void sellFoodProduct(FoodProduct foodProduct) throws NullPointerException {
        if (foodProduct == null) {
            throw new NullPointerException();
        } else {
            expenses = expenses.add(foodProduct.getCost());
            revenue = revenue.add(foodProduct.getPrice());
        }
    }

    public void hireEmployee(Employee employee) throws NullPointerException, IllegalArgumentException {
        if (employee == null) {
            throw new NullPointerException();
        } else if (employee.getAge() < 14) {
            throw new IllegalArgumentException();
        } else {
            employees.add(employee);
        }
    }

    public boolean fireEmployee(Employee employee) throws NullPointerException {
        if (employee == null) {
            throw new NullPointerException();
        } else if (employees.contains(employee)) {
            employees.remove(employee);
            return true;
        }
        return false;
    }

    public boolean updateEmployeeWage(Employee employee, BigDecimal newHourlyWage)
            throws NullPointerException, IllegalArgumentException {
        if (employee == null || newHourlyWage == null) {
            throw new NullPointerException();
        } else if (newHourlyWage.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException();
        else if (employees.contains(employee)) {
            int index = employees.indexOf(employee);
            employees.get(index).setHourlyWage(newHourlyWage);
            return true;
        }
        return false;
    }

    public void open(int hours, Random random) throws IllegalArgumentException, NullPointerException {
        if (hours < 0) {
            throw new IllegalArgumentException();
        } else if (random == null) {
            throw new NullPointerException();
        } else {
            for (int i = 0; i < hours; i++) {
                int customers = random.nextInt(100);
                for (int j = 0; j < customers; j++) {
                    int randNum = random.nextInt(100);
                    if (randNum <= 24) {
                        FoodProduct fp = new FoodProduct("Chocolate Sprinkle Donut",
                                290, BigDecimal.valueOf(0.20), BigDecimal.valueOf(0.95));
                        makeFoodProduct(fp.getName(), fp.getCalories(), fp.getCost(), fp.getPrice());
                        sellFoodProduct(fp);
                    } else if (randNum <= 49) {
                        Ingredient[] ingredients = new Ingredient[4];
                        ingredients[0] = Ingredient.CREAM;
                        ingredients[1] = Ingredient.CREAM;
                        ingredients[2] = Ingredient.SUGAR;
                        ingredients[3] = Ingredient.SUGAR;
                        Coffee c = new Coffee("Logan's Coffee", Size.MEDIUM, Roast.MEDIUM, ingredients);
                        makeCoffee(c.getName(), c.getSize(), c.getRoast(), c.getIngredients());
                        sellFoodProduct(c);
                    } else if (randNum <= 74) {
                        Ingredient[] ingredients = new Ingredient[1];
                        ingredients[0] = Ingredient.SUGAR;
                        Tea t = new Tea("Andrew's Tea", Size.SMALL, Type.GREEN, ingredients);
                        makeTea(t.getName(), t.getSize(), t.getType(), t.getIngredients());
                        sellFoodProduct(t);
                    }
                }
            }
        }
        for (Employee e : employees) {
            BigDecimal expenseToAdd = BigDecimal.valueOf(hours).multiply(e.getHourlyWage());
            expenses = expenses.add(expenseToAdd);
        }
    }

    public BigDecimal getExpenses() {
        return this.expenses;
    }

    public BigDecimal getRevenue() {
        return this.revenue;
    }

    public BigDecimal getProfit() {
        BigDecimal profit = this.revenue.subtract(this.expenses);
        return profit;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public boolean equals(Object object) {
        if (object instanceof Cafe) {
            if (((Cafe) object).getRevenue().compareTo(getRevenue()) == 0) {
                if (((Cafe) object).getExpenses().compareTo(getExpenses()) == 0) {
                    if (((Cafe) object).getEmployees().size() == employees.size()) {
                        int count = 0;
                        for (Employee i : ((Cafe) object).getEmployees()) {
                            if (i.equals(employees.get(count))) {
                                count++;
                            } else {
                                return false;
                            }
                        }
                        return count == employees.size();
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        String employeeString = "";
        int index = 1;
        int endIndex = employees.size();
        for (Employee e : employees) {
            if (index == endIndex) {
                employeeString = employeeString + "Employee[" + e.getName() + ", " +
                        e.getAge() + ", " + e.getHourlyWage() + "]";
            } else {
                employeeString = employeeString + "Employee[" + e.getName() + ", " +
                        e.getAge() + ", " + e.getHourlyWage() + "], ";
                index++;
            }


        }
        String s = "Cafe[" + getExpenses() + ", " + getRevenue() + ", ["
                + employeeString + "]]";
        return s;
    }
}
