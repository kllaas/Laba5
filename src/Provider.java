/**
 * Created by alexey on 23.05.17.
 */
public class Provider implements Comparable<Provider> {

    private String name;

    private String address;

    public Provider(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Provider() {
        name = "";
        address = "";
    }

    public Provider(Provider provider) {
        this(provider.name, provider.address);
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

    @Override
    public String toString() {
        return "\n## Provider" +
                "\n      " + "name: " + name +
                "\n      " + "address: " + address + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Provider other = (Provider) obj;

        if (!name.equals(other.name))
            return false;
        if (!address.equals(other.address))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = 31 * hashCode + name.hashCode();
        hashCode = 31 * hashCode + address.hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(Provider provider) {
        return this.equals(provider) ? 1 : 0;
    }
}
