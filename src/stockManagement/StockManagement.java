package stockManagement;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StockManagement {
    static String name;
    static String name2;
    private static double sprice;
    private static double NumOfShares;
    static double Balance = 2000;
    private static double total_Balance;
    static double total_val;
    static long numofshearbuy;

    static Scanner scan = new Scanner(System.in);
    static ArrayList<String> stock = new ArrayList<>();
    static ArrayList<Double> shareprice = new ArrayList<>();
    static ArrayList<Double> NumberOfShares = new ArrayList<Double>();

    static ArrayList<String> List1 = new ArrayList<>();
    static ArrayList<Double> List2 = new ArrayList<>();
    static ArrayList<String> List3 = new ArrayList<>();

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        StockManagement.name = name;
    }

    public static double getSprice() {
        return sprice;
    }

    public static void setSprice(double sprice) {
        StockManagement.sprice = sprice;
    }

    public static double getNumOfShares() {
        return NumOfShares;
    }

    public static void setNumOfShares(double numOfShares) {
        NumOfShares = numOfShares;
    }


    public static void stockdetails() {
        System.out.println("enter the stock name :");
        name = scan.next();
        stock.add(name);
        System.out.println("enter the share price of the stock :");
        sprice = scan.nextDouble();
        shareprice.add(sprice);
        System.out.println("enter the number of shares to you want :");
        NumOfShares = scan.nextDouble();
        NumberOfShares.add(NumOfShares);
        //     System.out.println(stock.get(0));
    }

    public static void totalvalue() {
        int stock1 = scan.nextInt();
        for (int i = 0; i < stock1; i++) {
            stockdetails();
            total_val = NumberOfShares.get(i) * 1 * shareprice.get(i);
            System.out.println("name of the stock :" + stock.get(i));

            System.out.println("the stock value : " + total_val + "\n\n");
        }
    }

    public void newaccount() {
        System.out.println("enter person name : ");
        name2 = scan.next();
        List1.add(name2);
    }

    public void display() {
        System.out.println("name of account holder name is :" + name2);
        System.out.println("current balance is : " + Balance);
    }

    public void buyandsell() {
        System.out.println("select the stocks given below :\n" + stock.get(0) + "one shareprice: \n" + shareprice.get(0) + "\n" + stock.get(1) +
                "one share value is :" + shareprice.get(1));
        String StockName1 = scan.next();
        for (int i = 0; i < stock.size(); i++) {
            if (StockName1.equals(stock.get(i))) {
                System.out.println("enter a share you want buy : ");
                long numofshearbuy = scan.nextLong();
                total_Balance = numofshearbuy * (1 * shareprice.get(i));
                System.out.println("would you like to buy=1 1 or 2 (sell=2) ?");
                int option = scan.nextInt();
                if (option == 1) {
                    if (Balance >= total_Balance) {
                        Balance = Balance - total_Balance;
                        List3.add(stock.get(i));
                        System.out.println("you have buyed" + stock.get(i) + "stock");
                    } else {
                        System.out.println("\n" + name + "you can not buy shareof :" + total_Balance);
                        System.out.println("your balance is : " + Balance);
                    }
                } else if (option == 2) {
                    Balance = Balance + total_Balance;
                    System.out.println("you have selected" + stock.get(i) + "stock");
                } else
                    System.out.println("you did not buy or sell here any stock");
            }
        }

    }

    public void addMultiDematAccount() {
        System.out.println("how many account you want add");
        long count = scan.nextLong();
        for (long i = 0; i < count; i++) {
            newaccount();
            buyandsell();
            List2.add(Balance);
            display();
            System.out.println("\n");
            Balance = 2000;
        }
    }

    public static void main(String[] args) {
        StockManagement stock = new StockManagement();
        stock.totalvalue();
        stock.newaccount();
        // stock.buyOrSellStock();
        stock.buyandsell();
        stock.display();
        // stock.addMultiDematAccount();
    }

}
