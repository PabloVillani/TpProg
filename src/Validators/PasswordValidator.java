package Validators;

import Exceptions.PasswordExceptions;
//Comprueba las medidas de seguridad de la contraseña.
public class PasswordValidator {
    public static boolean passwordValidator(String password) {
        boolean validation = true;
        try {
            if (password.length() < 5) { //La contraseña tiene que ser mayor a 5 caracteres.
                throw new PasswordExceptions(1);
            } else if (password.length() > 10) { //La contraseña no puede ser mayor a 10 caracteres.
                throw new PasswordExceptions(2);
            }
        } catch (PasswordExceptions ex) {
            System.out.println(ex.getMessage());
            validation = false;
        }
        return validation;
    }
}
