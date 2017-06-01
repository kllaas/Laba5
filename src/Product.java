import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alexey on 23.05.17.
 */
public class Product implements Comparable<Product> {

    private String name;

    private String units;

    private int price;

    private int amount;

    private Date date;

    private StorageCondition storageCondition;

    public Product(String name, String units, int price, int amount, Date date, StorageCondition storageCondition) {
        this.name = name;
        this.units = units;
        this.price = price;
        this.amount = amount;
        this.date = date;
        this.storageCondition = storageCondition;
    }

    public Product() {
        this.name = "";
        this.units = "";
        this.price = 0;
        this.amount = 0;
        this.date = new Date();
        this.storageCondition = StorageCondition.COOLED;
    }

    public Product(Product product) {
        this(product.getName(), product.getUnits(), product.getPrice(),
                product.getAmount(), product.getDate(), product.getStorageCondition());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StorageCondition getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(StorageCondition storageCondition) {
        this.storageCondition = storageCondition;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM.dd.yyyy");

        return "\n## Product" +
                "\n      " + "name: " + name +
                "\n      " + "units: " + units +
                "\n      " + "price: " + price +
                "\n      " + "date: " + df.format(date) +
                "\n      " + "conditions: " + storageCondition.toString() +
                "\n      " + "address: " + amount + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Product other = (Product) obj;

        if (price != other.price)
            return false;
        if (amount != other.amount)
            return false;
        if (storageCondition != other.storageCondition)
            return false;
        if (date.compareTo(other.date) != 1)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = 31 * hashCode + price;
        hashCode = 31 * hashCode + amount;
        hashCode = 31 * hashCode + storageCondition.hashCode();
        hashCode = 31 * hashCode + date.hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(Product provider) {
        return this.equals(provider) ? 1 : 0;
    }

    public enum StorageCondition {
        FROZEN,
        COOLED,
        AERATED
    }
}
