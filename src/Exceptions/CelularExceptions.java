package Exceptions;

public class CelularExceptions extends Exception{
    private int codigoError;
    public CelularExceptions(int codigoError){
        super();
        this.codigoError=codigoError;
    }

    @Override
    public String getMessage(){
        String mensaje="";
        switch(codigoError){
            case 21:
                mensaje= "Error, el celular tiene que incluir solo numeros.";
                break;
            case 22:
                mensaje="Error, el celular tiene mas de 10 digitos.";
                break;
        }
        return mensaje;
    }
}
