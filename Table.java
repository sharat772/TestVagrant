import java.util.*;

class PenContainer {
    String colour = "Blue";
    String shape = "Glass";
    List<Pen> pens = new ArrayList<Pen>();

    public void addPen(Pen p) {
        pens.add(p);
    }

    public void removePen(Pen p) {
        pens.remove(p);
    }

    public int getPenCount() {
        return pens.size();
    }
}

class Pen {
    String colour;
    String type;

    Pen(String colour, String type) {
        this.colour = colour;
        this.type = type;
    }
}

public class Table {
    public static void main(String[] args) {
        Pen p1 = new Pen("Blue", "Gel");
        Pen p2 = new Pen("Green", "Ball");
        PenContainer holder = new PenContainer();
        holder.addPen(p1);
        holder.addPen(p2);
        System.out.println(holder.getPenCount());
        holder.removePen(p2);
        System.out.println(holder.getPenCount());
    }
}
