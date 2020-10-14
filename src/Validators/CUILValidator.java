package Validators;

import Exceptions.CUILExceptions;
//Comprueba que el numero celular sea valido.
public class CUILValidator {
    public static boolean cuilValidador(String cuil){
        boolean validacion = true;
        try {
            if (!cuil.matches("[0-9]+")) { //Controla que el CUIL solo tenga numeros
                throw new CUILExceptions(13);
            }
            else if(cuil.length() < 2){ //Controla que el CUIL sea mayor a 2 caracteres (para evitar errores en la siguiente excepcion)
                throw new CUILExceptions(15);
            }
            else if (!cuil.startsWith("20") && !cuil.startsWith("27")) { //Controla que sea un CUIL valido (Que empiece con los verificadores de genero)
                throw new CUILExceptions(14);
            }


        } catch (CUILExceptions ex) {
            System.out.println(ex.getMessage());
            validacion = false;
        }
        return validacion;
    }
 }

