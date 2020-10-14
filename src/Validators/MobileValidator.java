package Validators;

import Exceptions.MobileExceptions;
//Comprueba que el numero celular sea valido
public class MobileValidator {
    public static boolean mobileValidator(String mobile){
        boolean validation = true;
        try {
            if (!mobile.matches("[0-9]+")) { //Busca que el celular solo tenga numeros
                throw new MobileExceptions(21);
            }
            else if(mobile.length() > 10){ //Busca el celular sea de maximo 10 numeros (Longitud maxima en Argentina)
                throw new MobileExceptions(22);
            }
        } catch (MobileExceptions ex) {
            System.out.println(ex.getMessage());
            validation = false;
        }
        return validation;
    }
}
