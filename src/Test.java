import Admin.Admin;
import UserGestion.ABM;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Admin admin = new Admin("user1","pass1");
        ABM.add("user","pass");
        ABM.remove("admin","adminp");
    }
}
