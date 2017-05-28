import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by alexey on 23.05.17.
 */
public class Warehouse implements Comparable<Warehouse>{

    private String name;

    private String address;

    private ArrayList<Delivery> deliveries;

    public Warehouse(String name, String address, ArrayList<Delivery> deliveries) {
        this.name = name;
        this.address = address;
        this.deliveries = deliveries;
    }

    public Warehouse() {
        name = "";
        address = "";
        deliveries = new ArrayList<>();
    }

    public Warehouse(Warehouse warehouse) {
        this(warehouse.getName(), warehouse.getAddress(), warehouse.getDeliveries());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(ArrayList<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public String toString() {
        String s = "\n## Warehouse" +
                "\n      " + "name: " + name +
                "\n      " + "address: " + address +
                "\n      ###### Deliveries array #####";

        for (Delivery delivery : deliveries) {
            s += delivery.toString();
        }

        s += "\n      ###### Deliveries array end #####\n\n";

        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Warehouse other = (Warehouse) obj;

        if (!name.equals(other.name))
            return false;
        if (!address.equals(other.address))
            return false;
        if (compareLists(deliveries, other.deliveries))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = 31 * hashCode + name.hashCode();
        hashCode = 31 * hashCode + address.hashCode();
        hashCode = 31 * hashCode + deliveries.hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(Warehouse provider) {
        return this.equals(provider) ? 1 : 0;
    }

    private boolean compareLists(List<Delivery> a, List<Delivery> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).compareTo(b.get(i)) != 1) {
                return false;
            }
        }
        return true;
    }
}
