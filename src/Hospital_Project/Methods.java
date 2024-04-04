package Hospital_Project;

import java.io.IOException;
import java.sql.SQLException;

public interface Methods {
    void entryMenu() throws InterruptedException, IOException, SQLException;
    void add ();
    void remove ();
    void list ();
    void createList ();
}
