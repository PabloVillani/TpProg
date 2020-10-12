package Validadores;

import Exceptions.PasswordExceptions;
//Compreuba las medidas de seguridad de la contraseña.
public class ContraValidador {
    public static boolean contraValidador(String contra) {
        boolean validacion = true;
        try {
            if (contra.length() < 5) { //La contraseña tiene que ser mayor a 5 caracteres.
                throw new PasswordExceptions(1);
            } else if (contra.length() > 10) { //La contraseña no puede ser mayor a 10 caracteres.
                throw new PasswordExceptions(2);
            }
        } catch (PasswordExceptions ex) {
            System.out.println(ex.getMessage());
            validacion = false;
        }
        return validacion;
    }
}
