package org.vending.machine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineService {

    private static VendingMachineService instance;
    private VendingMachineService() {
    }

    public static VendingMachineService getInstance(){
        if(VendingMachineService.instance == null) {
            VendingMachineService.instance = new VendingMachineService();
        }
        return VendingMachineService.instance;
    }

    private static double balanceAmount = 0.0d;

    public boolean isCoinAcceptedDenomination(final String coin){
        if (coin.equalsIgnoreCase("0.1") || coin.equalsIgnoreCase("0.2") || coin.equalsIgnoreCase("0.5")
                || coin.equalsIgnoreCase("1") || coin.equalsIgnoreCase("2")){
            return true;
        }else{
            return false;
        }
    }

    public void processCoin(final String coin){
        if(isCoinAcceptedDenomination(coin)){
            incrementAmount(Double.parseDouble(coin));
        }
    }

    private void incrementAmount(double coin){
        balanceAmount+= coin;
    }

    public double getBalanceAmount(){
        return balanceAmount;
    }

    public List<String> getAvailableOptions(double balanceAmount){
        List<String> availableProducts = new ArrayList<String>();
        if(balanceAmount >= 2.0){
            availableProducts.add("1. Organic Raw $2");
        }
        if(balanceAmount >= 2.5){
            availableProducts.add("2. Caramel $2.5");
        }
        if(balanceAmount >= 3.1){
            availableProducts.add("3. Hazelnut $3.1");
        }
        if(balanceAmount < 3.1){
            availableProducts.add("4. Insert more coins");
        }
        return availableProducts;
    }
}
