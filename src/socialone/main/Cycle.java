package socialone.main;

import socialone.seat.Seating;
import socialone.wheel.Wheels;
import socialone.chainassembly.ChainAssembly;
import socialone.frame.Frame;
import socialone.handlebar.GearedHandleBar;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

//This class cycle shows the price of a cycle at any given time.
public class Cycle {
    public static  void main(String a[]){ Map<String,String> inputConfigurationMap=new HashMap<>();
        try {
            inputConfigurationMap.put("Frame", a[0]);
            inputConfigurationMap.put("HandleBar", a[1]);
            inputConfigurationMap.put("ChainAssembly", a[2]);
            inputConfigurationMap.put("Seat", a[3]);
            inputConfigurationMap.put("Wheel", a[4]);
            //The date is date at which the user wants to know the price
            inputConfigurationMap.put("Date", a[5]);

            System.out.println("totalPrice:"+calculatePriceForGivenConfig(inputConfigurationMap));
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Kindly provide all the 6 configurations");
        }


    }

    public static BigDecimal calculatePriceForGivenConfig(Map<String,String> inputConfigurationMap){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate inputDate = LocalDate.parse(inputConfigurationMap.get("Date"), formatter);
        return gerFramePrice(inputConfigurationMap, inputDate)
                .add(getHandleBarPrice(inputConfigurationMap, inputDate))
                .add(getChainAssemblyPrice(inputConfigurationMap, inputDate))
                .add(getSeatPrice(inputConfigurationMap, inputDate))
                .add(getWheelPrice(inputConfigurationMap, inputDate));

    }

    private static BigDecimal gerFramePrice(Map<String, String> inputConfigurationMap, LocalDate inputDate) {
       Frame frame =new Frame();
        BigDecimal framePrice=BigDecimal.valueOf(0);
        switch (inputConfigurationMap.get("Frame")){
            case "FIBRE":
                framePrice=frame.getFiberFramePrice(inputDate);
                break;
            case "ALUMINIUM" :
                framePrice=frame.getAluminiumFramePrice(inputDate);
                break;
            case "STEEL"  :
                framePrice=frame.getSteelFramePrice(inputDate);
                break;
        }
        return framePrice;
    }

    private static BigDecimal getHandleBarPrice(Map<String, String> inputConfigurationMap, LocalDate inputDate) {
        GearedHandleBar handleBar=new GearedHandleBar();
        BigDecimal handleBarPrice=BigDecimal.valueOf(0);
        switch (inputConfigurationMap.get("HandleBar")){
            case "NORMAL":
                handleBarPrice=handleBar.getNormalHandleBarPrice(inputDate);
                break;
            case "GEARED" :
                handleBarPrice=handleBar.getGearedHandleBarPrice(inputDate);
                break;
        }
        return handleBarPrice;
    }

    private static BigDecimal getChainAssemblyPrice(Map<String, String> inputConfigurationMap, LocalDate inputDate) {
        ChainAssembly chainAssembly=new ChainAssembly();
        BigDecimal chainAssemblyPricePrice=BigDecimal.valueOf(0);
        switch (inputConfigurationMap.get("ChainAssembly")){
            case "MANUAL":
                chainAssemblyPricePrice=chainAssembly.getManualAssemblyPrice(inputDate);
                break;
            case "FACTORY" :
                chainAssemblyPricePrice=chainAssembly.getFactoryAssemblyPrice(inputDate);
                break;
        }
        return chainAssemblyPricePrice;
    }

    private static BigDecimal getSeatPrice(Map<String, String> inputConfigurationMap, LocalDate inputDate) {
        Seating seating=new Seating();
        BigDecimal seatingPrice=BigDecimal.valueOf(0);
        switch (inputConfigurationMap.get("Seat")){
            case "NORMAL":
                seatingPrice=seating.getNormalCushionPrice(inputDate);
                break;
            case "COMFORT" :
                seatingPrice=seating.getComfortCushionPrice(inputDate);
                break;
        }
        return seatingPrice;
    }

    private static BigDecimal getWheelPrice(Map<String, String> inputConfigurationMap, LocalDate inputDate) {
        Wheels wheel=new Wheels();
        BigDecimal WheelPrice=BigDecimal.valueOf(0);
        switch (inputConfigurationMap.get("Wheel")){
            case "TUBE":
                WheelPrice=wheel.getTubeWheelPrice(inputDate);
                break;
            case "TUBELESS" :
                WheelPrice=wheel.getTubeLessWheelPrice(inputDate);
                break;
        }
        return WheelPrice;
    }
}

