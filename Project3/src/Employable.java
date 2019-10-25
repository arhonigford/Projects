import java.math.BigDecimal;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public interface Employable {
    BigDecimal getHourlyWage();

    void setHourlyWage(BigDecimal hourlyWage) throws NullPointerException, IllegalArgumentException;
}
