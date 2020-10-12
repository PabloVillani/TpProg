package Validadores;
import Exceptions.CUILExceptions;

public class CUILValidador {
    public static boolean cuilValidador(String cuil){
        boolean validacion = true;
        try {
            if (!cuil.matches("[0-9]+")) {
                throw new CUILExceptions(13);
            }
            else if(cuil.length() < 2){
                throw new CUILExceptions(15);
            }
            else if (!cuil.startsWith("20") && !cuil.startsWith("27")) {
                throw new CUILExceptions(14);
            }


        } catch (CUILExceptions ex) {
            System.out.println(ex.getMessage());
            validacion = false;
        }
        return validacion;
    }
 }

