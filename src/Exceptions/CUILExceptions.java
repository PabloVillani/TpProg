package Exceptions;
//Maneja todos los errores que podria causar el Scanner.getString para el numero de CUIL.
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
                mensaje="Error, el CUIL no comienza con 20 o 27."; //El CUIL siempre empieza dos numeros (20 = hombre, 27 = mujer)
                break;
            case 15:
                mensaje="Error, el CUIL es demasiado corto.";
        }
        return mensaje;
    }
}

