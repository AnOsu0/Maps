package Lesson;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class NotebookMagazine {
    public static void main(String[] args) {
        Map<Notebook,Integer> notebooks = new HashMap<>();

        notebooks.put(new Notebook("Lenovo", "B590"),6);
        notebooks.put(new Notebook("Dell", "Inspiron0211A"),9);
        notebooks.put(new Notebook("HP", "G2A33EA"),3);
        notebooks.put(new Notebook("Dell", "XPS0091V"),2);

        Set<Map.Entry<Notebook, Integer>> entries = notebooks.entrySet();

        Map<String,Integer> people = Map.of("Jan",12345,"Karol",23456,"Zofia",3456);
        System.out.println(people);
    }
}
