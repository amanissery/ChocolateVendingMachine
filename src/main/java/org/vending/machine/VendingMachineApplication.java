package org.vending.machine;

import java.util.List;
import java.util.Scanner;

public class VendingMachineApplication {

	public static void main(String[] args) {
		System.out.println("Vending Machine Started");
        while (true) {

            System.out.println("Please insert coin");

            Scanner userInput = new Scanner(System.in);
            String coin = "";
            if (userInput.hasNext()){
                coin = userInput.nextLine();
            }
            VendingMachineService.getInstance().processCoin(coin);
            System.out.println("Current balance is '" + VendingMachineService.getInstance().getBalanceAmount() + "'");
            List<String> availableOptions = VendingMachineService.getInstance().getAvailableOptions(
                    VendingMachineService.getInstance().getBalanceAmount());

            availableOptions.forEach(eachOption -> {
                System.out.println(eachOption);
            });



            break;

        }
	}

}