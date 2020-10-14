package Exceptions;
//Maneja todos los posibles errores que puede arrojar la creacion de una contraseña con medidas de seguridad (Longitud)
public class PasswordExceptions extends Exception{
    private int codigoError;
    public PasswordExceptions(int codigoError){
        super();
        this.codigoError=codigoError;
    }

    @Override
    public String getMessage(){
        String mensaje="";
        switch(codigoError){
            case 1:
                mensaje= "Error, la contraseña tiene que ser mayor a 5 caracteres.";
                break;
            case 2:
                mensaje="Error, la contraseña tiene que ser menor a 10 caracteres.";
                break;
        }
        return mensaje;
    }
}