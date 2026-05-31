import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao =
                new EmployeeDAO();

        while(true) {

            System.out.println(
                    "\n===== EMPLOYEE MANAGEMENT SYSTEM ====="
            );

            System.out.println(
                    "1. Add Employee"
            );

            System.out.println(
                    "2. View Employees"
            );

            System.out.println(
                    "3. Search Employee"
            );

            System.out.println(
                    "4. Update Employee"
            );

            System.out.println(
                    "5. Delete Employee"
            );

            System.out.println(
                    "6. Exit"
            );

            System.out.print(
                    "Enter Choice: "
            );

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    sc.nextLine();

                    System.out.print(
                            "Enter Name: "
                    );

                    String name =
                            sc.nextLine();

                    System.out.print(
                            "Enter Department: "
                    );

                    String dept =
                            sc.nextLine();

                    System.out.print(
                            "Enter Salary: "
                    );

                    double salary =
                            sc.nextDouble();

                    sc.nextLine();

                    System.out.print(
                            "Enter Email: "
                    );

                    String email =
                            sc.nextLine();

                    Employee emp =
                            new Employee(
                                0,
                                    name,
                                    dept,
                                    salary,
                                    email
                            );

                    dao.addEmployee(emp);

                    break;

                case 2:

                    dao.viewEmployees();

                    break;

                case 3:

                    System.out.print(
                            "Enter Employee ID: "
                    );

                    int searchId =
                            sc.nextInt();

                    dao.searchEmployeeById(
                            searchId
                    );

                    break;

                case 4:

                    System.out.print(
                            "Enter Employee ID: "
                    );

                    int updateId =
                            sc.nextInt();

                    System.out.print(
                            "Enter New Salary: "
                    );

                    double newSalary =
                            sc.nextDouble();

                    dao.updateEmployee(
                            updateId,
                            newSalary
                    );

                    break;

                case 5:

                    System.out.print(
                            "Enter Employee ID: "
                    );

                    int deleteId =
                            sc.nextInt();

                    dao.deleteEmployee(
                            deleteId
                    );

                    break;

                case 6:

                    System.out.println(
                            "Exiting..."
                    );

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }
    }
}