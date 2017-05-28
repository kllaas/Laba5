import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alexey on 23.05.17.
 */
public class Delivery extends Product {

    private Provider provider;

    private int amount;

    private Date dateDelivered;

    public Delivery(Provider provider, int amount, Date dateDelivered) {
        this.provider = provider;
        this.amount = amount;
        this.dateDelivered = dateDelivered;
    }


    public Delivery(Delivery delivery) {
        this(delivery.getProvider(), delivery.getAmount(), delivery.getDateDelivered());
    }

    public Delivery() {
        provider = new Provider();
        amount = 0;
        dateDelivered = new Date();
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM.dd.yyyy");

        return "\n## Delivery" +
                "\n      " + "provider: " + provider.toString() +
                "\n      " + "amount: " + amount +
                "\n      " + "date: " + df.format(dateDelivered) + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Delivery other = (Delivery) obj;

        if (provider.compareTo(other.provider) != 1)
            return false;
        if (amount != other.amount)
            return false;
        if (dateDelivered.compareTo(other.dateDelivered) != 1)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = 31 * hashCode + provider.hashCode();
        hashCode = 31 * hashCode + amount;
        hashCode = 31 * hashCode + dateDelivered.hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(Product provider) {
        return this.equals(provider) ? 1 : 0;
    }
}
