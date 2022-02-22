package Example2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Shop {
    private static final String fileName = "C:\\Users\\LNV\\Desktop\\JavaFiles\\produktyMapy.txt";
    private static final File file = new File(fileName);
    private static HashSet<Product> allProducts = new HashSet<>();
    private static Map<String, Set<Product>> sets = new HashMap<>();


    private static void makeProductSet() throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] split = line.split(";");
            String category = split[0];
            String name = split[1];
            double price = Double.parseDouble(split[2]);
            Product product = new Product(category, name, price);
            allProducts.add(product);
        }
    }

    private static HashSet<String> makeKeySet() {
        HashSet<String> set = new HashSet<>();
        for (Product p : allProducts) {
            set.add(p.getCategory());
        }
        return set;
    }


    private static void fillMap() throws FileNotFoundException {
        makeProductSet();
        HashSet<String> keys = makeKeySet();
        for (String key : keys) {
            HashSet<Product> set = new HashSet<>();
            for (Product product : allProducts) {
                if (product.getCategory().equals(key)) {
                    set.add(product);
                }
            }
            sets.put(key, set);
        }
    }

    private static void printMap(String key) {
        Set<Product> products = sets.get(key);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static Product findBiggest(String key) {
        double biggest = 0;
        Set<Product> products = sets.get(key);
        for (Product product : products) {
            if (product.getPrice() > biggest) {
                biggest = product.getPrice();
            }
        }
        return findProduct(biggest,key);
    }

    private static Product findLeast(String key) {
        double least = findBiggest(key).getPrice();
        Set<Product> products = sets.get(key);
        for (Product product : products) {
            if (product.getPrice() < least) {
                least = product.getPrice();
            }
        }

        return findProduct(least,key);
    }

    private static Product findProduct(double price, String key){
        Product find = null;
        Set<Product> products = sets.get(key);
        for (Product product : products) {
            if(product.getPrice() == price){
                find = product;
            }
        } return find;
    }

    private static double AvaragePrice(String key) {
        double sum = 0;
        Set<Product> products = sets.get(key);
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum / products.size();
    }

    public static void mainMethod() throws FileNotFoundException {
        fillMap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj dla jakiej kategorii chcesz wyświetlić produkty");
        String key = sc.nextLine();
        printMap(key);
        System.out.println("Średnia cena produktów: " + AvaragePrice(key));
        System.out.println("Najtańszy prdukt " + findLeast(key));
        System.out.println("Najwdroższy produkt " + findBiggest(key));
    }
}
