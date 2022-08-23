import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static Scanner stringScanner;
    public static Scanner otherScanner;


    public static void main(String[] args) {
        ArrayList<Employee> employeesArrayList = new ArrayList<>();

        stringScanner = new Scanner(System.in);
        otherScanner = new Scanner(System.in);

        userPrompt(employeesArrayList);



    }



    public static void userPrompt(ArrayList<Employee> employeesArrayList){
        while(true){
            System.out.println("Enter \n" +
                    "1 to Add Employee \n" +
                    "2 to find Employee with Maximum Salary \n" +
                    "3 to find Employee with name starting with a  particular Character \n" +
                    "4 to find employee with name length more than a number \n" +
                    "5 to find total number of employees \n" +
                    "6 to sort employee details based on name \n" +
                    "7 to find Employee with salary greater than certain amount \n" +
                    "8 to exit ");

            switch (otherScanner.nextInt()){
                case 1:
                    System.out.println("Enter the Number of employees to add : ");
                    addEmployee(employeesArrayList,otherScanner.nextInt());
                    break;

                case 2:
                    findEmployeeWithMaxSalary(employeesArrayList);
                    break;

                case 3:
                    System.out.println("Enter the letter to search with : ");
                    findEmployeeNameStartingWith(employeesArrayList,stringScanner.nextLine());
                    break;

                case 4:
                    System.out.println("Enter the minimum length of employee name : ");
                    findEmployeeWithNameLength(employeesArrayList,otherScanner.nextInt());
                    break;

                case 5:
                    System.out.println("Total Number of Employees = "+employeesArrayList.stream().count());
                    break;

                case 6:
                    sortEmployeeBasedOnName(employeesArrayList);
                    break;

                case 7:
                    System.out.println("Enter the minimum employee salary : ");
                    findGreaterThan(employeesArrayList,otherScanner.nextDouble());
                    break;

                case 8:
                    return;

                default:
                    System.out.println("Enter a valid choice ");
            }
        }
    }




    //adding an employee into the list from keyboard
    public static void addEmployee(ArrayList<Employee> employeesArrayList,int count){
        while(count>0){
            System.out.println("Enter employee "+count+" id : ");
            int id = otherScanner.nextInt();
            System.out.println("Enter employee "+count+" name : ");
            String name = stringScanner.nextLine();
            System.out.println("Enter employee "+count+" salary ");
            employeesArrayList.add(new Employee(name,id, otherScanner.nextDouble()));
            count--;
        }
    }

    //finding employee with salary greater than some amount
    public static void findGreaterThan(ArrayList<Employee> employeesArrayList,double amount){
        System.out.println("Employee Details with salary greater than 15000");
        employeesArrayList.stream().filter(employee -> employee.getSalary()>amount).forEach(System.out::println);
    }


    //find employee with name starting with particular character
    public static void findEmployeeNameStartingWith(ArrayList<Employee> employeeArrayList, String startingLettter){
        System.out.println("Employee name starting with "+startingLettter+" are : ");
        employeeArrayList.stream().filter(employee -> employee.getName().toUpperCase().startsWith(startingLettter.toUpperCase())).map(employee -> employee.getName()).forEach(System.out::println);
    }

    //find employee with maximum salary
    public static void findEmployeeWithMaxSalary(ArrayList<Employee> employeesArrayList){
        System.out.println("Employee with Maximum salary :");
        Optional<Employee> maxSalary = employeesArrayList.stream().max(Comparator.comparingDouble(employee-> employee.getSalary()));
        System.out.println(maxSalary.get());
    }

    //find employee with name of particular length
    public static void findEmployeeWithNameLength(ArrayList<Employee> employeeArrayList,int length){
        System.out.println("Employees with Name length > "+length+" are : ");
        employeeArrayList.stream().filter(employee -> employee.getName().length()>length).map(employee -> employee.getName()).forEach(System.out::println);
    }

    //sorting the employee list based on name
    public static void sortEmployeeBasedOnName(ArrayList<Employee> employeeArrayList){
        System.out.println("Sorted employee list : ");
        employeeArrayList = (ArrayList<Employee>) employeeArrayList.stream().sorted((employee1,employee2)->employee1.getName().compareTo(employee2.getName())).collect(Collectors.toList());
        printEmployeeList(employeeArrayList);
    }


    //printing entire employee list
    public static void printEmployeeList(ArrayList<Employee> employeeArrayList){
        employeeArrayList.stream().forEach(System.out::println);
    }






}
