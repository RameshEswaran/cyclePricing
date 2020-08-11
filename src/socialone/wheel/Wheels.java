package socialone.wheel;

import socialone.util.PricingUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Wheels {
    private BigDecimal tubeTyrePrice;
    private BigDecimal tubelessTyrePrice;
    private BigDecimal wheelRawMaterialPrice;

    public Wheels(){
        this.tubeTyrePrice=BigDecimal.valueOf(900);
        this.tubelessTyrePrice=BigDecimal.valueOf(1200);
        this.wheelRawMaterialPrice=BigDecimal.valueOf(1500);
    }

    public BigDecimal getTubeWheelPrice(LocalDate date){
        return PricingUtil.getTotalPriceBasedOnDate(date,tubeTyrePrice.add(wheelRawMaterialPrice));
    }

    public BigDecimal getTubeLessWheelPrice(LocalDate date){
        return PricingUtil.getTotalPriceBasedOnDate(date,tubelessTyrePrice.add(wheelRawMaterialPrice));
    }

}
