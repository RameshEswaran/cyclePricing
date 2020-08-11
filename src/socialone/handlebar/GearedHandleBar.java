package socialone.handlebar;

import socialone.util.PricingUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

public class GearedHandleBar extends HandleBar {
    private BigDecimal frontGearPrice;
    private BigDecimal backGearPrice;
    private BigDecimal gearCablePrice;

    public GearedHandleBar(){
        this.frontGearPrice=BigDecimal.valueOf(800);
        this.backGearPrice=BigDecimal.valueOf(600);
        this.gearCablePrice=BigDecimal.valueOf(300);
    }

    public BigDecimal getGearedHandleBarPrice(LocalDate date){
      BigDecimal GearedHandleBarPrice=super.getHandleBarPrice().add(
         Stream.of(frontGearPrice,backGearPrice,gearCablePrice).reduce(BigDecimal::add).get());
        return PricingUtil.getTotalPriceBasedOnDate(date,GearedHandleBarPrice);
    }

}
