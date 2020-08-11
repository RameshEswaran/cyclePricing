package socialone.util;

import java.math.BigDecimal;
import java.time.LocalDate;

//This Util functions enables the calculation of price for products at any given time
public class PricingUtil {
    private static final LocalDate initialDate=LocalDate.of(2020,8,11);
    private static final int REMAINING_MONTHS_IN_CURRENT_YEAR=4;

    public static BigDecimal getTotalPriceBasedOnDate(LocalDate date, BigDecimal price){
        int diff=date.getYear()-initialDate.getYear();
        int numberOfMonths=0;
        if( diff > 1){
            numberOfMonths=REMAINING_MONTHS_IN_CURRENT_YEAR+((diff-1)*12)+date.getMonth().getValue();
        }
        else if(diff==1){
            numberOfMonths=REMAINING_MONTHS_IN_CURRENT_YEAR+date.getMonth().getValue();
        }
        else if(diff==0){
            numberOfMonths=0;
        }
        else
            System.out.println("Error:Enter Valid date");
        return price.add(price.multiply(BigDecimal.valueOf(numberOfMonths*0.01)));
    }
}
