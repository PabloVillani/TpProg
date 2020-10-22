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
        switch(codeError){
            case 34:
                message= "Error, sintoma no existente.";
                break;
            case 35:
                message="Error, ya escribio ese sintoma.";
                break;
        }
        return message;
    }
}
