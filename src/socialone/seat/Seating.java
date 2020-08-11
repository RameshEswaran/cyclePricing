package socialone.seat;

import socialone.util.PricingUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Seating {

    private BigDecimal seatFittingsPrice;
    private BigDecimal seatWoodPrice;
    private static final BigDecimal NORMAL_CUSHION_PRICE_HIKE=BigDecimal.valueOf(0.10);
    private static final BigDecimal COMFORT_CUSHION_PRICE_HIKE=BigDecimal.valueOf(0.30);

    public Seating() {
        this.seatFittingsPrice=BigDecimal.valueOf(120);
        this.seatWoodPrice=BigDecimal.valueOf(230);
    }

    public BigDecimal getNormalCushionPrice(LocalDate date){
        BigDecimal rawMaterialPrice=seatFittingsPrice.add(seatWoodPrice);
        BigDecimal normalCushionPrice=rawMaterialPrice.add(rawMaterialPrice.multiply(NORMAL_CUSHION_PRICE_HIKE));
        return  PricingUtil.getTotalPriceBasedOnDate(date,normalCushionPrice);
    }

    public BigDecimal getComfortCushionPrice(LocalDate date){
        BigDecimal rawMaterialPrice=seatFittingsPrice.add(seatWoodPrice);
        BigDecimal factoryAssemblyPrice=rawMaterialPrice.add(rawMaterialPrice.multiply(COMFORT_CUSHION_PRICE_HIKE));
        return  PricingUtil.getTotalPriceBasedOnDate(date,factoryAssemblyPrice);
    }
}
