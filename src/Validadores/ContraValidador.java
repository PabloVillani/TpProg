package Validadores;

import Exceptions.PasswordExceptions;

public class ContraValidador {
    public static boolean contraValidador(String contra) {
        boolean validacion = true;
        try {
            if (contra.length() < 5) {
                throw new PasswordExceptions(1);
            } else if (contra.length() > 10) {
                throw new PasswordExceptions(2);
            }
        } catch (PasswordExceptions ex) {
            System.out.println(ex.getMessage());
            validacion = false;
        }
        return validacion;
    }
}
