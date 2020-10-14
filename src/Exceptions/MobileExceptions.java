package Exceptions;
//Maneja todos los errores que podria causar el Scanner.getString para el numero celular.
public class MobileExceptions extends Exception{
    private int codeError;
    public MobileExceptions(int codeError){
        super();
        this.codeError= codeError;
    }

    @Override
    public String getMessage(){
        String message="";
        switch(codeError){
            case 21:
                message= "Error, el celular tiene que incluir solo numeros.";
                break;
            case 22:
                message="Error, el celular tiene mas de 10 digitos.";
                break;
        }
        return message;
    }
}
