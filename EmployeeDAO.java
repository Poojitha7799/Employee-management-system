import java.sql.*;

public class EmployeeDAO {

    private static final String url =
            "jdbc:mysql://localhost:3306/employeedb";

    private static final String username = "root";

    private static final String password = "your password";

    // ADD EMPLOYEE
    public void addEmployee(Employee emp) {

        if(emp.getName().isEmpty()) {

            System.out.println("Name cannot be empty");
            return;
        }

        if(emp.getSalary() <= 0) {

            System.out.println("Invalid salary");
            return;
        }

        if(!emp.getEmail().contains("@")) {

            System.out.println("Invalid email");
            return;
        }

        String query =
                "INSERT INTO employee(name, department, salary, email) VALUES(?,?,?,?)";

        try (
                Connection con =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement ps =
                        con.prepareStatement(query)
        ) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getEmail());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "Employee added successfully"
                );
            }

        }
       catch(SQLException e) {

    if(e.getMessage().contains("Duplicate")) {

        System.out.println(
                "Email already exists"
        );
    }
    else {

        System.out.println(
                "Database Error: " + e.getMessage()
        );
    }
}
    }

    // VIEW EMPLOYEES
    public void viewEmployees() {

        String query =
                "SELECT * FROM employee";

        try (
                Connection con =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement ps =
                        con.prepareStatement(query);

                ResultSet rs =
                        ps.executeQuery()
        ) {

            System.out.println(
                    "\n===== EMPLOYEE LIST ====="
            );

           while(rs.next()) {

    Employee emp =
            new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary"),
                    rs.getString("email")
            );

    System.out.println(emp);
}

        }
        catch(SQLException e) {

            System.out.println(
                    "Database Error: " + e.getMessage()
            );
        }
    }

    // SEARCH EMPLOYEE
    public void searchEmployeeById(int id) {

        String query =
                "SELECT * FROM employee WHERE id=?";

        try (
                Connection con =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement ps =
                        con.prepareStatement(query)
        ) {

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("department") + " | " +
                        rs.getDouble("salary") + " | " +
                        rs.getString("email")
                );
            }
            else {

                System.out.println(
                        "Employee not found"
                );
            }

        }
        catch(SQLException e) {

            System.out.println(
                    "Database Error: " + e.getMessage()
            );
        }
    }

    // UPDATE EMPLOYEE
    public void updateEmployee(
            int id,
            double newSalary
    ) {

        if(newSalary <= 0) {

            System.out.println(
                    "Invalid salary"
            );

            return;
        }

        String query =
                "UPDATE employee SET salary=? WHERE id=?";

        try (
                Connection con =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement ps =
                        con.prepareStatement(query)
        ) {

            ps.setDouble(1, newSalary);

            ps.setInt(2, id);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "Employee updated successfully"
                );
            }
            else {

                System.out.println(
                        "Employee not found"
                );
            }

        }
        catch(SQLException e) {

            System.out.println(
                    "Database Error: " + e.getMessage()
            );
        }
    }

    // DELETE EMPLOYEE
    public void deleteEmployee(int id) {

        String query =
                "DELETE FROM employee WHERE id=?";

        try (
                Connection con =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement ps =
                        con.prepareStatement(query)
        ) {

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "Employee deleted successfully"
                );
            }
            else {

                System.out.println(
                        "Employee not found"
                );
            }

        }
        catch(SQLException e) {

            System.out.println(
                    "Database Error: " + e.getMessage()
            );
        }
    }
}
