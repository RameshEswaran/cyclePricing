package socialone.chainassembly;

import socialone.util.PricingUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ChainAssembly {
    private BigDecimal chainSprocketPrice;
    private BigDecimal chainRawMaterialPrice;
    private static final BigDecimal MANUAL_ASSEMBLY_PRICE_HIKE=BigDecimal.valueOf(0.10);
    private static final BigDecimal FACTORY_ASSEMBLY_PRICE_HIKE=BigDecimal.valueOf(0.25);

    public ChainAssembly() {
        this.chainRawMaterialPrice=BigDecimal.valueOf(700);
        this.chainSprocketPrice=BigDecimal.valueOf(200);
    }

    public BigDecimal getManualAssemblyPrice(LocalDate date){
        BigDecimal rawMaterialPrice=chainSprocketPrice.add(chainRawMaterialPrice);
        BigDecimal manualAssemblyPrice=rawMaterialPrice.add(rawMaterialPrice.multiply(MANUAL_ASSEMBLY_PRICE_HIKE));
        return  PricingUtil.getTotalPriceBasedOnDate(date,manualAssemblyPrice);
    }

    public BigDecimal getFactoryAssemblyPrice(LocalDate date){
        BigDecimal rawMaterialPrice=chainSprocketPrice.add(chainRawMaterialPrice);
        BigDecimal factoryAssemblyPrice=rawMaterialPrice.add(rawMaterialPrice.multiply(FACTORY_ASSEMBLY_PRICE_HIKE));
        return  PricingUtil.getTotalPriceBasedOnDate(date,factoryAssemblyPrice);
    }

}
