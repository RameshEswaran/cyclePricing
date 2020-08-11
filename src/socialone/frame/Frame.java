package socialone.frame;

import socialone.util.PricingUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

public class Frame {
    private BigDecimal frontBarPrice;
    private BigDecimal  backSeaterStandPrice;
    private BigDecimal  backBarPrice;
    private BigDecimal  pedalPrice;
    private BigDecimal  rimPrice;
    private static final BigDecimal PRICE_HIKE_ALUMINIUM_FRAME=BigDecimal.valueOf(0.20);
    private static final BigDecimal PRICE_HIKE_FIBER_FRAME=BigDecimal.valueOf(0.50);

    public Frame() {
        this.frontBarPrice=BigDecimal.valueOf(500);
        this.backBarPrice=BigDecimal.valueOf(100);
        this.backSeaterStandPrice=BigDecimal.valueOf(200);
        this.pedalPrice=BigDecimal.valueOf(800);
        this.rimPrice=BigDecimal.valueOf(400);
    }

    //Aluminium frame is the mid variant frame
    public BigDecimal getAluminiumFramePrice(LocalDate date){
        BigDecimal normalFramePrice=getNormalFramePrice();
        BigDecimal aluminiumFramePrice=normalFramePrice.add(normalFramePrice.multiply(PRICE_HIKE_ALUMINIUM_FRAME));
        return PricingUtil.getTotalPriceBasedOnDate(date,aluminiumFramePrice);
    }

    //steel frame is the cheapest frame
    public BigDecimal getSteelFramePrice(LocalDate date){
        BigDecimal normalFramePrice=getNormalFramePrice();
        return PricingUtil.getTotalPriceBasedOnDate(date,normalFramePrice);
    }

    //carbon frame is expensive than all the other frames
    public BigDecimal getFiberFramePrice(LocalDate date){
        BigDecimal normalFramePrice=getNormalFramePrice();
        BigDecimal carbonFramePrice=normalFramePrice.add(normalFramePrice.multiply(PRICE_HIKE_FIBER_FRAME));
        return PricingUtil.getTotalPriceBasedOnDate(date,carbonFramePrice);
    }

    private BigDecimal getNormalFramePrice(){
        return Stream.of(frontBarPrice, backSeaterStandPrice, backBarPrice
                , pedalPrice, rimPrice).reduce(new BigDecimal(0),BigDecimal::add);
    }

}
