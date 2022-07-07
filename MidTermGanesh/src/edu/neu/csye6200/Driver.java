package edu.neu.csye6200;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 100 TOTAL POINTS
 *
 * Store Assignment:
 *
 * Complete the supplied code fragment to meet the following requirements:
 *
 * NOTE: all classes and interfaces MUST BE inner to Driver class
 *
 * GIVEN:
 * - Driver class code fragment
 * - StoreAPI inner interface
 *
 *
 * 1. 10 POINTS: design Sellable inner interface;
 * 2. 10 POINTS: design Item inner class which implements Sellable
 * 3. 15 POINTS: design abstract Person inner class
 * 4. 10 POINTS: design Employee inner class derived from Person
 * 5. 15 POINTS: design Store inner class which implements StoreAPI to contain both Employees (MUST Use Person API) and Items (MUST Use Sellable API)
 * 6. 40 POINTS: complete design of Driver class main method.
 *
 * @author dpeters
 *
 */
public class Driver {

//    public static final int MAJOR_REVISION;
//    public static final int MINOR_REVISION;
    private static String version;



    /**
     * Person abstract class
     * TODO Student complete implementation
     *
     * @author dpeters
     *
     */
    static private abstract class Person  {
        private final String firstName;
        private final String lastName;
        private final int age;
        private final int id;
        private final double wage;


        Person(String firstName, String lastName, int age, int id, double wage) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.id = id;
            this.wage = wage;
        }

        @Override
        public String toString() {
            return  "Person # " + id + "  Emp Name: " +  firstName + " " + lastName + "    Emp Age: "  + age + "    Emp Hourly Wage: "  + wage + "\n";
        }
    }
    /**
     * Employee class
     * Employee has an id, an age, first name, last name and a wage.
     * TODO Student complete implementation
     *
     * @author dpeters
     *
     */
    static public class Employee extends Person {

        public Employee(int id, String firstName, String lastName, int age, double wage) {
            super(firstName, lastName, age, id, wage);
        }

        public Employee(String[] params) {
            this(Integer.parseInt(params[0]), params[2], params[3], Integer.parseInt(params[1]), Double.parseDouble(params[4]));
        }

        public Employee (String line) {
            this(line.split(","));
        }
    }
    /**
     * Interface Sellable
     * TODO Student complete implementation
     *
     * @author dpeters
     *
     */
    static private interface Sellable {

        int getId();

        String getName();

        double getCost();
    }

    /**
     * Item class
     * Items have an id, cost and a name
     * TODO Student complete implementation
     *
     * @author dpeters
     *
     */
    static private class Item implements Sellable {

        private final int id;
        private final String name;
        private final double cost;

        public Item(int id, String name, double cost) {
            this.id = id;
            this.name = name;
            this.cost = cost;
        }

        public Item(String[] params) {
            this(Integer.parseInt(params[0]), params[2], Double.parseDouble(params[1]));
        }

        public Item(String line) {
            this(line.split(","));
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return "Item Id: " + id + "  Item Name: " + name + "     Item Cost: " + cost + "\n";
        }
    }
    /**
     * StoreAPI interface
     */
    static private interface StoreAPI {
        void add(Person person);
        void add(Sellable item);
        void sortEmployees(Comparator<Person> c);
        void sortItems(Comparator<Sellable> c);
        List<Employee> getEmployees();
        List<Sellable> getItems();
    }
    /**
     * Store
     * TODO BY STUDENT Complete implementation
     *
     * Store has employees and items
     *
     * @author dpeters
     *
     */
    static public class Store  implements StoreAPI{

        public final List<Employee> employees;
        public final List<Sellable> items;


        public List<Employee> getEmployees() {
            return employees;
        }

        public List<Sellable> getItems() {
            return items;
        }

        public Store() {
            employees = new ArrayList<>();
            items = new ArrayList<>();

        }


        @Override
        public void add(Person person) {
            if (person instanceof Employee) {
                employees.add((Employee) person);
            }
            else {
                throw new IllegalArgumentException("This person is not of type employee");
            }
        }

        @Override
        public void add(Sellable item) {
            items.add(item);
        }

        @Override
        public void sortEmployees(Comparator<Person> c) {
            Collections.sort(employees, c);
        }

        @Override
        public void sortItems(Comparator<Sellable> c) {
            Collections.sort(items, c);
        }

        @Override
        public String toString() {
            StringBuilder ret = new StringBuilder("Employees:\n");
            for (Person p: employees) {
                ret.append(p.toString());
            }
            ret.append("Items:\n");
            for (Sellable i: items) {
                ret.append(i.toString());
            }
            return ret.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("**********************************");
        System.out.println("    CSYE6200 Midterm July 2022 ...");
        System.out.println("**********************************");

        // TODO BY STUDENT


        StoreAPI store = new Store();
        /**
         * add employees to store
         *
         * (by parsing the following CSV Strings)
         *
         * "3,21,James,Pope,12.99"
         * "1,31,Bob,James,15.99"
         * "2,27,Don,Hope,14.99"
         */
        store.add(new Employee("3,21,James,Pope,12.99"));
        store.add(new Employee("1,31,Bob,James,15.99"));
        store.add(new Employee("2,27,Don,Hope,14.99"));

        // TODO BY STUDENT 10 POINTS:

        /**
         * add items to store inventory
         *
         * (by parsing the following CSV Strings
         *
         * "3,1.49,Wheat Bread"
         * "1,3.49,OJ"
         * "2,2.49,Skim Milk"
         */
        // TODO BY STUDENT 10 POINTS:

        store.add(new Item("3,1.49,Wheat Bread"));
        store.add(new Item("1,3.49,OJ"));
        store.add(new Item("2,2.49,Skim Milk"));


        /**
         * show original store state
         */
        // TODO BY STUDENT
        System.out.println("Original Store state");
        System.out.println("==============================");
        System.out.println(store);

        /**
         * Sorting to be completed by Studend as indicated (TODO) 10 POINTS:
         */



        System.out.println("Sort employees by PERSON ID...");
        System.out.println("==============================");
        // TODO BY STUDENT
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.id, o2.id);
            }
        });
        System.out.println(store.getEmployees());


        System.out.println("Sort items by ITEM ID...");
        System.out.println("========================");
        // TODO BY STUDENT
        store.sortItems(new Comparator<Sellable>() {
            @Override
            public int compare(Sellable o1, Sellable o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
        System.out.println(store.getItems());

        System.out.println("Store current state after applying above sorting");
        System.out.println("================================================");
        System.out.println(store);



        System.out.println("Sort employees by PERSON LAST NAME...");
        System.out.println("=====================================");
        // TODO BY STUDENT
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        });
        System.out.println(store.getEmployees());


        System.out.println("Sort items by ITEM NAME...");
        System.out.println("==========================");

        // TODO BY STUDENT
        store.sortItems(new Comparator<Sellable>() {
            @Override
            public int compare(Sellable o1, Sellable o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(store.getItems());

        System.out.println("Store current state after applying above sorting");
        System.out.println("================================================");
        System.out.println(store);


        System.out.println("Sort employees by PERSON FIRST NAME...");
        System.out.println("======================================");

        // TODO BY STUDENT
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        });
        System.out.println(store.getEmployees());


        System.out.println("Sort items by ITEM PRICE...");
        System.out.println("===========================");

        // TODO BY STUDENT
        store.sortItems(new Comparator<Sellable>() {
            @Override
            public int compare(Sellable o1, Sellable o2) {
                return Double.compare(o1.getCost(), o2.getCost());
            }
        });
        System.out.println(store.getItems());

        System.out.println("Store current state after applying above sorting");
        System.out.println("================================================");
        System.out.println(store);



        System.out.println("Sort employees by PERSON AGE (YOUNGEST FIRST)...");
        System.out.println("================================================");
        // TODO BY STUDENT
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });
        System.out.println(store.getEmployees());

        System.out.println("Store current state after applying above sorting");
        System.out.println("================================================");
        System.out.println(store);



        System.out.println("Sort employees by PERSON AGE (OLDEST FIRST)...");
        System.out.println("==============================================");

        // TODO BY STUDENT
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -Integer.compare(o1.age, o2.age);
            }
        });
        System.out.println(store.getEmployees());

        System.out.println("Store current state after applying above sorting");
        System.out.println("================================================");
        System.out.println(store);


        System.out.println("Sort employees by HIGHEST WAGE...");
        System.out.println("==================================");

        // TODO BY STUDENT
        store.sortEmployees(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -Double.compare(o1.wage, o2.wage);
            }
        });
        // TODO BY STUDENT 10 POINTS:
        System.out.println(store.getEmployees());

        System.out.println("Store current state after applying above sorting");
        System.out.println("================================================");
        System.out.println(store);

        System.out.println("************************************");
        System.out.println("CSYE6200 Midterm July 2022 ... done!");
        System.out.println("************************************");
    }

}


/* OUTPUT


**********************************
    CSYE6200 Midterm July 2022 ...
**********************************
Original Store state
==============================
Employees:
Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
Items:
Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49
Item Id: 1  Item Name: OJ     Item Cost: 3.49
Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49

Sort employees by PERSON ID...
==============================
[Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
, Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
, Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
]
Sort items by ITEM ID...
========================
[Item Id: 1  Item Name: OJ     Item Cost: 3.49
, Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49
, Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49
]
Store current state after applying above sorting
================================================
Employees:
Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
Items:
Item Id: 1  Item Name: OJ     Item Cost: 3.49
Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49
Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49

Sort employees by PERSON LAST NAME...
=====================================
[Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
, Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
, Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
]
Sort items by ITEM NAME...
==========================
[Item Id: 1  Item Name: OJ     Item Cost: 3.49
, Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49
, Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49
]
Store current state after applying above sorting
================================================
Employees:
Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
Items:
Item Id: 1  Item Name: OJ     Item Cost: 3.49
Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49
Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49

Sort employees by PERSON FIRST NAME...
======================================
[Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
, Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
, Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
]
Sort items by ITEM PRICE...
===========================
[Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49
, Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49
, Item Id: 1  Item Name: OJ     Item Cost: 3.49
]
Store current state after applying above sorting
================================================
Employees:
Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
Items:
Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49
Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49
Item Id: 1  Item Name: OJ     Item Cost: 3.49

Sort employees by PERSON AGE (YOUNGEST FIRST)...
================================================
[Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
, Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
, Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
]
Store current state after applying above sorting
================================================
Employees:
Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
Items:
Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49
Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49
Item Id: 1  Item Name: OJ     Item Cost: 3.49

Sort employees by PERSON AGE (OLDEST FIRST)...
==============================================
[Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
, Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
, Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
]
Store current state after applying above sorting
================================================
Employees:
Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
Items:
Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49
Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49
Item Id: 1  Item Name: OJ     Item Cost: 3.49

Sort employees by HIGHEST WAGE...
==================================
[Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
, Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
, Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
]
Store current state after applying above sorting
================================================
Employees:
Person # 1  Emp Name: Bob James    Emp Age: 31    Emp Hourly Wage: 15.99
Person # 2  Emp Name: Don Hope    Emp Age: 27    Emp Hourly Wage: 14.99
Person # 3  Emp Name: James Pope    Emp Age: 21    Emp Hourly Wage: 12.99
Items:
Item Id: 3  Item Name: Wheat Bread     Item Cost: 1.49
Item Id: 2  Item Name: Skim Milk     Item Cost: 2.49
Item Id: 1  Item Name: OJ     Item Cost: 3.49

************************************
CSYE6200 Midterm July 2022 ... done!
************************************

        Process finished with exit code 0


 */

