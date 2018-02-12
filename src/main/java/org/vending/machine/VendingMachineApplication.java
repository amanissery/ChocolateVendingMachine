package org.vending.machine;

import java.util.List;
import java.util.Scanner;

public class VendingMachineApplication {

	public static void main(String[] args) {
		System.out.println("Vending Machine Started");
        while (true) {

            System.out.println("Please insert coin. Accepted coins : 0.1, 0.2, 0.5, 1, 2");

            Scanner userInput = new Scanner(System.in);
            String coin = "";
            if (userInput.hasNext()){
                coin = userInput.nextLine();
            }
            if(VendingMachineService.getInstance().processCoin(coin)) {
                System.out.println("Current balance is '" + VendingMachineService.getInstance().getBalanceAmount() + "'");
            }else{
                System.out.println("Invalid coin rejected. Please collect the coin and insert a valid coin.");
            }
            List<String> availableOptions = VendingMachineService.getInstance().getAvailableOptions(
                    VendingMachineService.getInstance().getBalanceAmount());
            //If balance is less than the lowest chocolate price, need to add insert more coins
            if(availableOptions.size() == 1){
                continue;
            }

            availableOptions.forEach(eachOption -> {
                System.out.println(eachOption);
            });

            Scanner userSelection = new Scanner(System.in);
            String selection = "";

            if (userSelection.hasNext()) {
                selection = userSelection.nextLine();

                if (selection.equalsIgnoreCase("4")) {
                    continue;
                }else{
                    System.out.println("Please collect your chocolate");
                    System.out.println("Please collect your change : " + VendingMachineService.getInstance().dispenseChange(
                            VendingMachineService.getInstance().getBalanceAmount(), selection));
                }
            }
            try{
                userInput.close();
                userSelection.close();
            }catch (Exception exception){
                System.out.println("Error closing input stream");
            }
            break;
        }
	}

}