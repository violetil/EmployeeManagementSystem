package employee.management.system;

import java.sql.*;

public class ConnectDatabase {
    String url = "jdbc:mysql://localhost:3306/EmployeeManagementSystem";
    String user = "root";
    String password = "134970Ftl";

    Connection c;
    Statement s;

    public ConnectDatabase() {
        try {
            c = DriverManager.getConnection(url, user, password);
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
