package Util;

import java.util.List;

public class UbicationChooser {
    public static String ubicationChooser() {
        List<String> ubications = ArrayMaker.singleStringMaker("src/DataBase/PreexistingBases/Ubications.txt");
        System.out.println();
        String linea = "";
        int i = Scanner.getInt("Elija su ubicacion: ");
        if (i < 0 || i > 5) {
            System.out.println("Numero Invalido."); //Recursion en caso de ingresar un numero invalido.
            ubicationChooser();
        } else {
            if (i == 1) {
                linea = "Escobar";
            }
            if (i == 2) {
                linea = "Gral. Rodriguez";
            }
            if (i == 3) {
                linea = "Pilar";
            }
            if (i == 4) {
                linea = "Tigre";
            }
            if (i == 5) {
                linea = "Zarate";
            }
        }
        return linea;
    }
}

