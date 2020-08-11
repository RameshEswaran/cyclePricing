package socialone.handlebar;

import socialone.util.PricingUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

public class HandleBar {

    private BigDecimal  handleBarScrewPrice;
    private BigDecimal  bellPrice;
    private BigDecimal  barPrice;
    private BigDecimal breakSetPrice;

    public HandleBar() {
        this.handleBarScrewPrice=BigDecimal.valueOf(400);
        this.bellPrice=BigDecimal.valueOf(600);
        this.barPrice=BigDecimal.valueOf(300);
        this.breakSetPrice=BigDecimal.valueOf(200);
    }

    protected BigDecimal getHandleBarPrice(){
        return Stream.of(handleBarScrewPrice,bellPrice,barPrice
                ,breakSetPrice).reduce(new BigDecimal(0),BigDecimal::add);
    }

    public BigDecimal getNormalHandleBarPrice(LocalDate date){
        BigDecimal normalHandleBArPrice=getHandleBarPrice();
        return PricingUtil.getTotalPriceBasedOnDate(date,normalHandleBArPrice);
    }

}
