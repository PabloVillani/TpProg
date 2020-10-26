package Exceptions;

public class InputException extends Exception{
    private int codeError;
    public InputException(int codeError){
        super();
        this.codeError= codeError;
    }

    @Override
    public String getMessage(){
        String message="";
        if(codeError == 81){
                message= "Opcion no valida.";
        }
        return message;
    }
}
