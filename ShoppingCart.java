import java.util.*;

class Item {
    String name;
    double price;
    double gst;
    double qty;
    double prodGst;
    double finalPrice;
    double mrpprice;

    Item(String na, double price, double gst, double qty) {
        this.name = na;
        this.price = price;
        this.gst = gst;
        this.qty = qty;
        this.prodGst = (gst / 100) * price;
        this.finalPrice = price + prodGst;
    }
}

public class ShoppingCart {

    public static void main(String[] args) {
        List<Item> pInfo = new ArrayList<Item>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to Print Bill \nEnter 0 to add item");
        int ch = sc.nextInt();
        do {
            System.out.println("Enetr name");
            String name = sc.next();
            System.out.println("Enter price");
            double price = sc.nextDouble();
            System.out.println("Enter gst");
            double gst = sc.nextDouble();
            System.out.println("Enter quantity");
            double qty = sc.nextDouble();
            Item prod = new Item(name, price, gst, qty);
            pInfo.add(prod);
            System.out.println("Enter 1 to printbill \n enter 0 to add item");
            ch = sc.nextInt();

        } while (ch != 1);
        sc.close();
        invoice(pInfo);

    }

    public static void invoice(List<Item> plst) {
        System.out.println("THANK YOU FOR SHOPPING");
        double total = 0;
        double maxgst = 0;
        double discount = 0;
        double hastopay = 0;
        String maxpiadgstname = "";

        for (Item i : plst) {
            total += i.finalPrice * i.qty;
            maxgst = Math.max(maxgst, (i.prodGst) * i.qty);
            if (maxgst == (i.prodGst) * i.qty) {
                maxpiadgstname = i.name;
            }
        }
        if (total > 500) {
            discount = 0.05 * total;
        }
        hastopay = total - discount;
        System.out.println("Total amount = " + total);
        System.out.println("Discount = " + discount);
        System.out.println("FINAL BILL AMOUNT = " + hastopay);
        System.out.println("MAX GST PAID FOR AN ITEM " + maxgst);
        System.out.println("Name of product max gst paid by us " + maxpiadgstname);
    }
}
