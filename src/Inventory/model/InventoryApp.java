package Inventory.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InventoryApp {
    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StockList stock = new StockList();

    public void run() throws Exception {
        stock.addNewItem("NeveRest 40 Gearmotor", 18);
        stock.addNewItem("DC Motor", 22);
        stock.addNewItem("HS-785HB winch servo", 1);
        stock.addNewItem("ZTE Speed phone", 10);
        stock.addNewItem("Powerpole extension cable", 10);
        stock.addNewItem("Logitech F310 gamepad", 9);

        String[] menu = new String[7];
        menu[0] = "INVENTORY:";
        menu[1] = "1) Add a new item";
        menu[2] = "2) Add an existing item";
        menu[3] = "3) Discontinue an Item";
        menu[4] = "4) View Item";
        menu[5] = "5) View Entire Stock";
        menu[6] = "Press number for an above action, or any other number to quit: ";

        int userChoice;
        do {
            for (String item : menu) {System.out.print("\n" + item);}
            userChoice = input.nextInt();

            switch (userChoice) {
                case 1: addNewItem(); break;
                case 2: addExistingItem(); break;
                case 3: itemDiscontinue(); break;
                case 4: showItem(); break;
                case 5: showStock(); break;
                default: break;
            }

        } while (userChoice >= 1 && userChoice <= 5);
    }

    public void addNewItem() throws Exception {
        System.out.println("Name of Item: ");
        String name = reader.readLine();
        System.out.println("Item amount: ");
        int amount = input.nextInt();
        stock.addNewItem(name, amount);
    }

    public void addExistingItem() {
        System.out.println("Stock number: ");
        int stockNum = input.nextInt();
        System.out.println("Item amount: ");
        int amount = input.nextInt();
        stock.addToItem(stockNum, amount);
    }

    public void itemDiscontinue() {
        System.out.print("Stock number: ");
        int stockNum = input.nextInt();
        stock.discontinue(stockNum);
    }

    public void showItem() {
        System.out.println("Stock number: ");
        int stockNum = input.nextInt();
        System.out.println(stock.itemAt(stockNum));
    }

    public void showStock() {
        for (int i = 1000; i < stock.size() + 1000; i++) {
            System.out.println(stock.itemAt(i));
        }
    }
}
