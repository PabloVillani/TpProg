package Exceptions;

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