package Exceptions;
//Maneja todos los errores que podria causar el Scanner.getString para el numero de CUIL.
public class CUILExceptions extends Exception{
    private int codeError;
    public CUILExceptions(int codeError){
        super();
        this.codeError=codeError;
    }

    @Override
    public String getMessage(){
        String message = "";
        switch(codeError){
            case 13:
                message= "Error, el CUIL tiene que incluir solo numeros.";
                break;
            case 14:
                message="Error, el CUIL no comienza con 20 o 27."; //El CUIL siempre empieza dos numeros (20 = hombre, 27 = mujer)
                break;
            case 15:
                message="Error, el CUIL es demasiado corto.";
        }
        return message;
    }
}

