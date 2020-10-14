package Util;

import java.util.Iterator;
import java.util.ArrayList;

public class Finder {
    //Busca a el usuario por su cuil y celular en una lista.
    public static boolean userFinder(String cuil, String celular, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(cuil.equals(s) && celular.equals(a[1])){
                    return true;
                }
            }
        }
        return false;
    }
    //Busca al admin por su usuario y contraseña en una lista.
    public static boolean adminFinder(String usuario, String contra, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(usuario.equals(s) && contra.equals(a[1])){
                    return true;
                }
            }
        }
        return false;
    }
    //Comprueba que concuerden el cuil, el celular, y la contraseña.
    public static boolean password(String cuil,String celular, String contra, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(cuil.equals(s) && celular.equals(a[1]) && contra.equals(a[2])){
                    return true;
                }
            }
        }
        return false;
    }
}

