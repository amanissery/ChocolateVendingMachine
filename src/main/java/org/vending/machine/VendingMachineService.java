package org.vending.machine;

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
	
}
