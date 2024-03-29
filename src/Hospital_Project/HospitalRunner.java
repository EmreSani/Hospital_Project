package Hospital_Project;
import java.io.IOException;
import static Hospital_Project.HospitalService.*;


public class HospitalRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        hospitalService.start();

    }
}
