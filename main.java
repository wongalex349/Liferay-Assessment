import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class main {

    public static void main(String[] args)
    {
        System.out.println("Input");
        System.out.println("Input 1: ");
        SalesTax book = new SalesTax("book", 1, 12.49, false, false);
        SalesTax musicCD = new SalesTax("music CD", 1, 14.99, true, false);
        SalesTax chocolateBar = new SalesTax("chocolate bar", 1, 0.85, false, false);
        SalesTax[] sales1 = new SalesTax[]{book, musicCD, chocolateBar};
        for(int i = 0; i < sales1.length; i++)
            System.out.println(sales1[i]);

        System.out.println("\nInput 2: ");
        SalesTax chocolate = new SalesTax("box of chocolate", 1, 10.00, false, true);
        SalesTax  perfume = new SalesTax("bottle of perfume", 1, 47.50, true, true);
        SalesTax[] sales2 = new SalesTax[]{chocolate, perfume};
        for(int i = 0; i < sales2.length; i++)
            System.out.println(sales2[i]);

        System.out.println("\nInput 3: ");
        SalesTax perfumeBottle = new SalesTax("bottle of perfume", 1, 27.99, true, true);
        SalesTax  perfume3= new SalesTax("bottle of perfume", 1, 18.99, true, false);
        SalesTax pills = new SalesTax("packet of headache pills", 1, 9.75, false, false);
        SalesTax chocolateBox = new SalesTax("box of chocolates", 1, 11.25, false, true);
        SalesTax[] sales3 = new SalesTax[]{perfumeBottle, perfume3, pills, chocolateBox};
        for(int i = 0; i < sales3.length; i++)
            System.out.println(sales3[i]);


        System.out.println("\nOutput");
        System.out.println("Output 1: ");
        getOutput(sales1);
        System.out.println("\nOutput 2: ");
        getOutput(sales2);
        System.out.println("\nOutput 3: ");
        getOutput(sales3);
    }
    public static void getOutput(SalesTax[] sales)
    {

        double price = 0;
        double initial = 0;
        for(int i = 0; i < sales.length; i++)
            initial = initial + sales[i].getPrice();
        for(int i = 0; i < sales.length; i++) {
                sales[i].setImportTax();
                System.out.println(sales[i].OutputString());
                price = price + sales[i].getPrice();
        }
        BigDecimal tax= new BigDecimal(price- initial).setScale(2,RoundingMode.HALF_UP);
        BigDecimal amount = new BigDecimal(price).setScale(2,RoundingMode.HALF_UP);

        System.out.println("Sales Taxes: " + tax);
        System.out.println("Total: " + amount);
    }
}
