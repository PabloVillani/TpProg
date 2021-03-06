package Util;

import Events.Disease;
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
        return false;
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
            String[] line = list.get(i);
            if(item.equals(line[position])){
                return i;
            }
        } return -1;
    }

    public int indexOf2(String item, String item2, ArrayList<String[]> list){
        for(int i= 0; i< list.size(); i++){
            String[] line = list.get(i);
            if(item.equals(line[0]) && item2.equals(line[1])){
                return i;
            }
        } return -1;
    }

    public boolean singleValueFinderArray(String value1, ArrayList<String[]> list, int position){
        for(String[] a : list){
            for(String s : a ){
                if(a[position].equals(value1)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diseaseFinder(Disease value1, List<Disease> list) {
        Iterator<Disease> i = list.iterator();
        for (Disease a : list) {
            if (value1.equals(a)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf2ByPosition(String item, String item2,int position1, int position2, ArrayList<String[]> list){
        for(int i= 0; i< list.size(); i++){
            String[] line = list.get(i);
            if(item.equals(line[position1]) && item2.equals(line[position2])){
                return i;
            }
        } return -1;
    }
    public boolean finderOf2ByPosition(String item, String item2,int position1, int position2, ArrayList<String[]> list){
        for(int i= 0; i< list.size(); i++){
            String[] line = list.get(i);
            if(item.equals(line[position1]) && item2.equals(line[position2])){
                return true;
            }
        } return false;
    }
}


