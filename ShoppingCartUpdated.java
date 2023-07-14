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

public class ShoppingCartUpdated {
    public static void main(String[] args) {
        List<Item> pInfo = new ArrayList<Item>();
        Item i1 = new Item("Wallet", 1100, 18, 1);
        Item i2 = new Item("Umbrella", 900, 12, 2);
        Item i3 = new Item("Cigarette", 200, 28, 3);
        Item i4 = new Item("Honey", 100, 0, 4);
        pInfo.add(i1);
        pInfo.add(i2);
        pInfo.add(i3);
        pInfo.add(i4);
        invoice(pInfo);
    }

    public static void invoice(List<Item> plst) {
        System.out.println("THANK YOU FOR SHOPPING");
        double total = 0;
        double maxgst = 0;
        double totalDiscount = 0;
        String maxpiadgstname = "";
        for (Item i : plst) {
            double priceWithDiscount = 0;
            if (i.price > 500) {
                priceWithDiscount = 0.05 * i.price;
                totalDiscount = priceWithDiscount * i.qty;
            } else {
                priceWithDiscount = i.price;
            }
            total += priceWithDiscount * i.qty;
            maxgst = Math.max(maxgst, (i.prodGst) * i.qty);
            if (maxgst == (i.prodGst) * i.qty) {
                maxpiadgstname = i.name;
            }
        }
        System.out.println("Total Discount On Purchase = " + totalDiscount);
        System.out.println("FINAL BILL AMOUNT = " + total);
        System.out.println("Name of product max gst paid by us " + maxpiadgstname + "MAX GST PAID FOR AN ITEM " + maxgst);
    }
}
