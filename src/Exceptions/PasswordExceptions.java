package Exceptions;
//Maneja todos los posibles errores que puede arrojar la creacion de una contraseña con medidas de seguridad (Longitud)
public class PasswordExceptions extends Exception{
    private int codeError;
    public PasswordExceptions(int codeError){
        super();
        this.codeError= codeError;
    }

    @Override
    public String getMessage(){
        String message="";
        switch(codeError){
            case 1:
                message= "Error, la contraseña tiene que ser mayor a 5 caracteres.";
                break;
            case 2:
                message="Error, la contraseña tiene que ser menor a 10 caracteres.";
                break;
        }
        return message;
    }
}