package util;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import Ciudadano.Ciudadano;
public class Finder {
    String line;
    public static boolean finder(String cuil, String celular, ArrayList<String[]> list){
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
    public static int indexOf(String a, List<Ciudadano> ciudadanos) {
        for(int i= 0; i< ciudadanos.size(); i++){
            if(a != null && a.equals(ciudadanos.get(i).getCuil()) || a==null && ciudadanos.get(i).getCuil() == null){
                return i;
            }
        } return -1;
    }
}

