package Hospital_Project;
import java.io.IOException;
import java.sql.SQLException;

import static Hospital_Project.HospitalService.*;


public class HospitalRunner {
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        hospitalService.start();

    }
}
