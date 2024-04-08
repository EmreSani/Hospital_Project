package Hospital_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBankService {
    static Connection con;

    static {
        try {
            con = DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/hospital_dev02","dev02","123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
