package Exceptions;

public class CUILExceptions extends Exception{
    private int codigoError;
    public CUILExceptions(int codigoError){
        super();
        this.codigoError=codigoError;
    }

    @Override
    public String getMessage(){
        String mensaje = "";
        switch(codigoError){
            case 13:
                mensaje= "Error, el CUIL tiene que incluir solo numeros.";
                break;
            case 14:
                mensaje="Error, el CUIL no comienza con 20 o 27.";
                break;
            case 15:
                mensaje="Error, el CUIL es demasiado corto.";
        }
        return mensaje;
    }
}

