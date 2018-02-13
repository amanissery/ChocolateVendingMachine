# ChocolateVendingMachine

This is an exercise to simulate a chocolate vending machine.

The specifications are

1. User can enter the following denominations : 10c, 20c, 50c, $1, $2
2. Price for the chocolates are  - Caramel $2.50, Hazelnut - $3.10, Organic Raw - $2
3. App must not allow the user to enter invalid currency
4. App must ensure that user has entered the correct amount of money prior to prompting for their selection
5.  App should handle the condition if the user enters too much money


Example:

Vending Machine Started
Please insert coin. Accepted coins : 0.1, 0.2, 0.5, 1, 2
2
Current balance is '2.0'
1. Organic Raw $2
4. Insert more coins
4
Please insert coin. Accepted coins : 0.1, 0.2, 0.5, 1, 2
2
Current balance is '4.0'
1. Organic Raw $2
2. Caramel $2.5
3. Hazelnut $3.1
3
Please collect your chocolate
Please collect your change : 0.9

Assumption:

Out of range selections in the selection menu are not handled. Vending machine will display only available options and other inputs can not be entered.

Instruction to run:

Pre requisites : Java 1.8, Apache maven

Steps to run the application :

1. Clone the maven project ChocolateVendingMachine from git repository
2. Package using the following command
  mvn clean compile package
3. Run jar using the following command
java -jar target/ChocolateVendingMachine-1.0-SNAPSHOT.jar
4. Key in the inputs


