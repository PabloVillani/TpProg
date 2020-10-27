 package Exceptions;

public class SymptomsExceptions extends Exception{
    private int codeError;
    public SymptomsExceptions(int codeError){
        super();
        this.codeError= codeError;
    }

    @Override
    public String getMessage(){
        String message="";
        if(codeError == 34) {
            message = "Error, sintoma no existente.";
        }
        if(codeError == 35){
            message="Error, ya escribio ese sintoma.";
        }
        if(codeError == 36){
            message="Error, no tiene este sintoma.";
        }
        return message;
    }
}
