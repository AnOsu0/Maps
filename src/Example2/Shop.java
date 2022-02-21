package Example2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Shop {
    private static final String fileName = "C:\\Users\\LNV\\Desktop\\JavaFiles\\produktyMapy.txt";
    private static final File file = new File(fileName);
    private static HashSet<Product> allProducts = new HashSet<>();
    private static Map<String, Set<Product>> sets = new HashMap<>();


    public static void makeProductSet () throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            String[] split = line.split(";");
            String category = split[0];
            String name = split[1];
            double price = Double.parseDouble(split[2]);
            Product product = new Product(category,name,price);
            allProducts.add(product);
        }
    }

    private static HashSet<String> makeKeySet(){
     HashSet<String> set = new HashSet<>();
        for (Product p : allProducts) {
            set.add(p.getCategory());
        }
        return set;
    }


    public static void fillMap() throws FileNotFoundException {
        makeProductSet();
        HashSet<String> keys = makeKeySet();
        for (String key : keys) {
            HashSet<Product> set = new HashSet<>();
            for (Product product : allProducts) {
                if (product.getCategory().equals(key)){
                 set.add(product);
                }
            }
            sets.put(key,set);
        }

        System.out.println(sets);
    }




}
