package Lesson;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NotebookStore {
    public static void main(String[] args) {
        Map<String,Notebook> notebooks = new HashMap<>();

        notebooks.put("B590", new Notebook("Lenovo", "B590"));
        notebooks.put("Inspiron0211A", new Notebook("Dell", "Inspiron0211A"));
        notebooks.put("G2A33EA", new Notebook("HP", "G2A33EA"));
        notebooks.put("XPS0091V", new Notebook("Dell", "XPS0091V"));

//        String key = "G2A33EA";
//        Notebook notebook = notebooks.get(key);
//        System.out.println(notebook);
//        notebooks.remove("B590");
//        System.out.println(notebooks);
//
//        Set<String> keys = notebooks.keySet();
//        for (String key : keys) {
//            System.out.println(key + " : " + notebooks.get(key));
//        }

        Set<Map.Entry<String, Notebook>> entries = notebooks.entrySet();
        for (Map.Entry<String, Notebook> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

//        System.out.println(keys);
//        Collection<Notebook> values = notebooks.values();
//        System.out.println(values);
    }
}
