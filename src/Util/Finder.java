package Util;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Finder {
    public Finder(){

    }
    public boolean singleValueFinder(String value1, List<String> list) {
        Iterator<String> i = list.iterator();
        for (String a : list) {
            if (value1.equals(a)) {
                return true;
            }
        }
        return true;
    }
    //Busca datos en un array de dos valores por su usuario y contraseña en una lista.
    public boolean doubleValueFinder(String value1, String value2, ArrayList<String[]> list){
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
    public boolean tripleValueFinder(String value1, String value2, String value3, ArrayList<String[]> list){
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
    public boolean fourValueFinder(String value1, String value2, String value3, String value4, ArrayList<String[]> list){
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
    public int indexOf(String item, ArrayList<String[]> list, int position){
        for(int i= 0; i< list.size(); i++){
            if(singleValueFinderArray(item, list, position)){
                return i;
            }
        } return -1;
    }

    public int indexOf2(String item, String item2, ArrayList<String[]> list){
        for(int i= 0; i< list.size(); i++){
            if(doubleValueFinder(item, item2, list)){
                return i;
            }
        } return -1;
    }

    public boolean singleValueFinderArray(String value1, ArrayList<String[]> list, int position){
        Iterator i = list.iterator();
        for(String[] a : list){
            for(String s : a ){
                if(value1.equals(a[position])){
                    return true;
                }
            }
        }
        return false;
    }
}


