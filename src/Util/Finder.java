package Util;

import java.util.Iterator;
import java.util.ArrayList;

public class Finder {
    //Busca a el usuario por su cuil y celular en una lista.
    public static boolean userFinder(String cuil, String mobile, String ubication, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(cuil.equals(s) && mobile.equals(a[1]) && ubication.equals((a[2]))){
                    return true;
                }
            }
        }
        return false;
    }
    //Busca al admin por su usuario y contraseña en una lista.
    public static boolean adminFinder(String user, String password, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(user.equals(s) && password.equals(a[1])){
                    return true;
                }
            }
        }
        return false;
    }
    //Comprueba que concuerden el cuil, el celular, y la contraseña.
    public static boolean password(String cuil,String mobile, String password, String ubication, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(cuil.equals(s) && mobile.equals(a[1]) && password.equals(a[2]) && ubication.equals(a[3])){
                    return true;
                }
            }
        }
        return false;
    }
}

