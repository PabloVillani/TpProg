package Validadores;

import Exceptions.CelularExceptions;
//Comprueba que el numero celular sea valido
public class CeluValidador {
    public static boolean celuValidador(String celu){
        boolean validacion = true;
        try {
            if (!celu.matches("[0-9]+")) { //Busca que el celular solo tenga numeros
                throw new CelularExceptions(21);
            }
            else if(celu.length() > 10){ //Busca el celular sea de maximo 10 numeros (Longitud maxima en Argentina)
                throw new CelularExceptions(22);
            }
        } catch (CelularExceptions ex) {
            System.out.println(ex.getMessage());
            validacion = false;
        }
        return validacion;
    }
}
