package Util;

import java.util.Iterator;
import java.util.ArrayList;

public class Finder {

    public static boolean singleValueFinder(String value1, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(value1.equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
    //Busca datos en un array de dos valores por su usuario y contraseña en una lista.
    public static boolean doubleValueFinder(String value1, String value2, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(value1.equals(s) && value2.equals(a[1])){
                    return true;
                }
            }
        }
        return false;
    }

    //Busca que los tres valores concuerden
    public static boolean tripleValueFinder(String value1, String value2, String value3, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(value1.equals(s) && value2.equals(a[1]) && value3.equals(a[a.length -1])){
                    return true;
                }
            }
        }
        return false;
    }

    //Busca que los 4 valores concuerden.
    public static boolean fourValueFinder(String value1, String value2, String value3, String value4, ArrayList<String[]> list){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(value1.equals(s) && value2.equals(a[1]) && value3.equals(a[2]) && value4.equals(a[3])){
                    return true;
                }
            }
        }
        return false;
    }
    public static int indexOf(String item, ArrayList<String[]> list){
        for(int i= 0; i< list.size(); i++){
            if(item != null && item.equals(list.get(i)) || item==null && list.get(i) ==null){
                return i;
            }
        } return -1;
    }
}


