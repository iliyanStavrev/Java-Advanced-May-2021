package BankAccount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer,BankAccount>value = new HashMap<>();



        while (!input.equals("End")){
            String []tokens = input.split("\\s+");
            String command = tokens[0];

            BankAccount bankAccount = new BankAccount();
            switch (command){

                case "Create":

                    System.out.println("Account ID" + bankAccount.getId() + " created");
                    value.put(bankAccount.getId(), bankAccount);
                    break;

                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    if (id > value.size()){
                        System.out.println("Account does not exist");
                    }
                    else {
                        int amount = Integer.parseInt(tokens[2]);
                        value.get(id).deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n",amount,id);
                    }

                    break;

                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newInterest);
                    break;

                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (id > value.size()){
                        System.out.println("Account does not exist");
                    }
                    else {
                        double interest = value.get(id).getInterestRate(years);
                        System.out.printf("%.2f%n",interest);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
