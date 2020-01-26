import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesTax {
    private boolean isTaxed;
    private String item;
    private boolean isImported;
    private double price;
    private int quantity;

    public SalesTax(String item, int quantity, double price, boolean isTaxed, boolean isImported)
    {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.isTaxed = isTaxed;
        this.isImported = isImported;
    }
    public boolean getImport()
    {
        return isImported;
    }
    public double getPrice()
    {
        return price;
    }
    public void setImportTax()
    {
        if(isTaxed == true && isImported == true)
        {
           // price = price * 1.15;

            price = (Math.round(price * 20.0 * 1.15 ) / 20.0);

        }
        else if(isTaxed == true)
        {
           // price = price * 1.1;
            price = (Math.round(price * 20.0 * 1.1 ) / 20.0);
        }
        else if(isImported == true)
        {
            //price = price * 1.05;
            price = (Math.round(price * 20.0 * 1.05 ) / 20.0);
        }
    }

    public String toString()
    {
        BigDecimal bd = new BigDecimal(price).setScale(2,RoundingMode.HALF_UP);
        String sale = quantity + " ";
        if(isImported == true)
        {
            sale = sale + "imported ";
        }
        sale = sale + item  + " at " + bd;
        return sale;
    }
    public String OutputString()
    {
        BigDecimal bd = new BigDecimal(price).setScale(2,RoundingMode.HALF_UP);
        String sale = quantity + " ";
        if(isImported == true)
        {
            sale = sale + "imported ";
        }
        sale = sale + item  + ": " + bd;
        return sale;
    }
}
