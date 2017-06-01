import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by alexey on 23.05.17.
 */
public class Main {

    public static void main(String[] args) {
        String name = IOUtils.readString("Input name: ");
        String address = IOUtils.readString("Input address: ");

        Provider provider = new Provider(name, address);

        System.out.println(provider);

        String newName = IOUtils.readString("Let`s change name: ");
        provider.setName(newName);

        System.out.println(provider);

        System.out.println("Creating provider with default constructor: ");
        Provider provider1 = new Provider();
        System.out.println(provider1);

        System.out.println("Creating provider with copy constructor: ");
        Provider provider2 = new Provider(provider1);
        System.out.println(provider2);

        System.out.println("Let`s compare provider1 with provider2: ");
        System.out.println("Compare result: " + provider1.equals(provider2));


        System.out.println("\nCreate product with empty constructor: ");
        Product product = new Product();

        System.out.println(product);

        System.out.println("Create product: ");

        String pName = IOUtils.readString("Input name: ");
        String units = IOUtils.readString("Input units: ");
        int price = IOUtils.readInt("Input price: ");
        int amount = IOUtils.readInt("Input amount: ");
        Date date = IOUtils.readDate("Input date: ");
        Product.StorageCondition condition = IOUtils.readConditions("Input condition: ");

        Product product1 = new Product(pName, units, price, amount, date, condition);

        System.out.println(product1);

        System.out.println("Create product with copy constructor(based on product1): ");
        Product product2 = new Product(product1);

        System.out.println(product2);

        int newPrice = IOUtils.readInt("Let`s change price: ");
        product2.setPrice(newPrice);

        System.out.println(product2);

        System.out.println("Let`s compare product with product1: ");
        System.out.println("Compare result: " + product.equals(product1));


        System.out.println("Create delivery with empty constructor: ");

        Delivery delivery = new Delivery();
        System.out.println(delivery);

        System.out.println("Create product: ");

        int amount1 = IOUtils.readInt("Input amount: ");
        Date date1 = IOUtils.readDate("Input date: ");
        Delivery delivery1 = new Delivery(provider, amount1, date1);

        System.out.println(delivery1);

        System.out.println("Create delivery with copy constructor(based on delivery1): ");
        Delivery delivery2 = new Delivery(delivery1);

        int amount2 = IOUtils.readInt("Let`s change amount: ");
        delivery2.setAmount(amount2);

        System.out.println(delivery2);

        System.out.println("Let`s compare delivery1 with delivery2: ");
        System.out.println("Compare result: " + delivery1.equals(delivery2));
        System.out.println();


        System.out.println("Create Warehouse with empty constructor: ");

        Warehouse warehouse = new Warehouse();
        System.out.println(warehouse);

        System.out.println("Create Warehouse: ");

        String name1 = IOUtils.readString("Input amount: ");
        String address1 = IOUtils.readString("Input date: ");
        ArrayList<Delivery> deliveries = new ArrayList<>();
        deliveries.add(delivery);
        deliveries.add(delivery1);
        Warehouse warehouse1 = new Warehouse(name1, address1, deliveries);

        System.out.println(warehouse1);

        System.out.println("Create Warehouse with copy constructor(based on warehouse1): ");
        Warehouse warehouse2 = new Warehouse(warehouse1);

        System.out.println(warehouse2);

        String newAddress = IOUtils.readString("Let`s change address: ");
        warehouse2.setAddress(newAddress);

        System.out.println(delivery2);

        System.out.println("Let`s compare warehouse1 with warehouse2: ");
        System.out.println("Compare result: " + warehouse1.equals(warehouse2));
        System.out.println();
    }

}
