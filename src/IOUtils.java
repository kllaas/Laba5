import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alexey on 24.05.17.
 */
public class IOUtils {

    public static int readInt(String text) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(text);

        while (true)
            try {
                String str = br.readLine();

                if (str.matches("^-?\\d+$"))
                    return Integer.parseInt(str);

                System.out.println("Input is incorrect.");

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static String readString(String text) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        System.out.print(text);

        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    /**
     * Input date in format "06.27.2007"
     */
    public static Date readDate(String text) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DateFormat df = new SimpleDateFormat("MM.dd.yyyy");

        System.out.print(text);

        while (true)
            try {
                String input = br.readLine();

                return df.parse(input);

            } catch (IOException | ParseException e) {
                System.out.println("Input is incorrect");
            }
    }

    public static Product.StorageCondition readConditions(String text) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(text);

        while (true) try {
            String str = br.readLine();

            return Product.StorageCondition.valueOf(str);

        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Input is incorrect.");
        }
    }
}
