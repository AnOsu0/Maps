package Exaple1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Handler;

public class Company {
    private static final int EXIT = 0;
    private static final int ADD_EMPLOYEE = 1;
    private static final int FIND_EMPLOYEE = 2;
    private static Scanner sc = new Scanner(System.in);

    private static Map<String,Employee> employees= new HashMap<>();

    public static void mainLoop (){
        int options = -1;
        while (options!= EXIT) {
            System.out.println("Wybierz opcję");
            System.out.println("0 - wyjście z programu");
            System.out.println("1 - dodanie nowego pracownika");
            System.out.println("2 - wyświetlenie pracownika");
            options = sc.nextInt();
            sc.nextLine();
            switch (options){
                case ADD_EMPLOYEE -> addEmployee();
                case FIND_EMPLOYEE -> findEmployee();
            }

        }
        System.out.println("Koniec programu");
    }

    private static void findEmployee() {
        System.out.println("Podaj Imię szukanej osoby");
        String firstName = sc.nextLine();
        System.out.println("Podaj Nazwisko szukanej osoby");
        String lastName = sc.nextLine();
        String key = firstName + " " + lastName;
        Employee employee = employees.get(key);
        System.out.println(employee);
    }

    private static void addEmployee() {
        System.out.println("Podaj Imię");
        String firstName = sc.nextLine();
        System.out.println("Podaj Nazwisko");
        String lastName = sc.nextLine();
        System.out.println("Podaj wypłatę");
        double salary = sc.nextDouble();
        sc.nextLine();
        String key = firstName + " " + lastName;
        employees.put(key,new Employee(firstName,lastName,salary));
    }
}
