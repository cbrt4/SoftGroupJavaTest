package alex.softgroupjavatest.test5;

import java.io.*;
import java.util.*;

/*
* 5. Create classes, which describe employees with
* hourly wage and fixed payment. Give your suggestions
* about relations between classes. Implement method for
* calculating the average monthly salary. For employees
* with hourly wage use next formula: “average monthly
* salary= 20.8*8* hourly rate”, for employees with fixed
* payment – “average monthly salary= fixed monthly payment”.
* Write well commented code for solving next problems
* a) Sort the collection of employees in descending order
* by the average monthly salary. In the case of equal salary –
* by the name. Write ID, name and monthly salary for all
* employees from collection.
* b) Write information about first five employees from collection
* (problem a)
* c) Write ID of three last employees from collection (problem b).
* d) Write code for reading and writing collection of these objects
* from (into) file.
* e) Write code for handling the incorrect format of incoming file.
*/

public class Main {

    private static void initialize(List<Employee> employees) {

        employees.add(new EmployeeFixedPayment(1,
                "Gordon",
                "Freeman",
                28,
                "0638804175",
                "kepocih@mail.ru",
                2500));

        employees.add(new EmployeeFixedPayment(3,
                "Gregory",
                "House",
                43,
                "0988512483",
                "getoffman@gmail.com",
                2500));

        employees.add(new EmployeeHourlyWage(2,
                "Eugen",
                "Masser",
                33,
                "0998647111",
                "musthavesomeskills@i.ua",
                15));

        employees.add(new EmployeeHourlyWage(5,
                "Max",
                "Payne",
                42,
                "0636678945",
                "payneispain@gmail.com",
                15));

        employees.add(new EmployeeHourlyWage(4,
                "Andrew",
                "Laeddis",
                37,
                "0796475447",
                "shutterisland@mail.ru",
                14));

        employees.add(new EmployeeFixedPayment(7,
                "John",
                "Deer",
                31,
                "0678955232",
                "nevermind@gmail.com",
                2230));

        employees.add(new EmployeeHourlyWage(6,
                "Robert",
                "Martin",
                30,
                "0732714555",
                "fuckgoogleaskme@mail.ru",
                12.50));

        employees.add(new EmployeeHourlyWage(9,
                "Antonio",
                "Bolgard",
                29,
                "0934421277",
                "havesomemoney@gala.net",
                14));

        employees.add(new EmployeeFixedPayment(8,
                "Ryan",
                "Seemann",
                30,
                "0666941618",
                "thisisnotmysandwich@mail.ru",
                2410));
    }

    public static void main(String[] args) throws IOException {

        List<Employee> employees = new LinkedList<>();

        initialize(employees);

        //problem A:

        /*employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.calculatePayment() > e2.calculatePayment()) return -1;
                    if (e1.calculatePayment() < e2.calculatePayment()) return 1;
                    return e1.getName().compareTo(e2.getName());
                })
                .forEach(System.out::println);*/

        //problem B:

        //employees.subList(0,5).forEach(System.out::println);

        //problem C:

        //employees.subList(employees.size()-3, employees.size()).forEach(System.out::println);
        /*for (int i = employees.size()-3; i < employees.size(); i++) {
            System.out.println(employees.get(i).getId());
        }*/

        //problem D:

        /*FileOutputStream fileOutputStream = new FileOutputStream("employees.ser");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*FileInputStream fileInputStream = new FileInputStream("employees.ser");
        List<Employee> employees2 = new LinkedList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            employees2 = ((LinkedList)objectInputStream.readObject());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\n++++++++++");

        employees2.stream()
                .forEach(System.out::println);*/
    }
}
