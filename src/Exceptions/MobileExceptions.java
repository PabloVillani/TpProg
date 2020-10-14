package Exceptions;
//Maneja todos los errores que podria causar el Scanner.getString para el numero celular.
public class MobileExceptions extends Exception{
    private int codigoError;
    public MobileExceptions(int codigoError){
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
