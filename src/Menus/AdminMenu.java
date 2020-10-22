package Menus;

import Admin.Admin;
import Util.ArrayMaker;
import Util.Finder;
import Util.Scanner;

import java.util.List;

//Despliega el menu del administrador en el Main.
public class AdminMenu {
    public static void Menu() {
        int i = 0;
        do { //Presenta las opciones a realizar:
            System.out.println("1. Notificar sintoma.\n2. Dar de baja un sintoma\n3. Modificar sintomas\n4. Desbloquear usuario\n5. Cerrar sesion.");
            i = Scanner.getInt("Que operacion desea realizar?:"); //Pregunta que opcion realizar
            switch (i) {
                case 1:  //Activar sintoma.
                    List<String> symptoms = ArrayMaker.singleStringMaker("src/DataBase/PreexistingBases/SymptomsBase.txt");
                    System.out.println();
                    String symptom = Scanner.getString("Introduzca el nombre del sintoma: ");
                    if(!Finder.singleValueFinder(symptom, symptoms)){
                        System.out.println("El sintoma no existe.");
                    }else{
                        Admin.activateSymptom(symptom);
                    }
                    break;
                case 2: //Desactivar sintomas.
                    List<String> symptoms2 = ArrayMaker.singleStringMaker("src/DataBase/ModificableBases/ActiveSymptoms.txt");
                    System.out.println();
                    String symptom2 = Scanner.getString("Introduzca el nombre del sintoma a eliminar: ");
                    if(!Finder.singleValueFinder(symptom2, symptoms2)){
                        System.out.println("El sintoma no existe");
                    }else{
                        Admin.deactivateSymptom(symptom2);
                    }
                    break;
                case 3: //Modificar sintomas.
                    String symptom1 = Scanner.getString("Introduzca el nombre del sintoma a modificar: ");
                    if(!Finder.singleValueFinder(symptom1, ArrayMaker.singleStringMaker("src/DataBase/ModificableBases/ActiveSymptoms.txt"))){
                        System.out.println("El sintoma no existe");
                    }else{
                        Admin.modificateSymptom(symptom1);
                    }
                    break;
                case 4: //Desbloquear usuario
                    String cuil = Scanner.getString("Introduzca el CUIL del ciudadano: ");
                    if(Finder.singleValueFinder(cuil, ArrayMaker.singleStringMaker("src/DataBase/ModificableBases/CuilOnlyDataBase.txt"))){
                        Admin.unlock(cuil);
                    }else{
                        System.out.println("El ciudadano no existe.");
                    }
                    break;
                case 5: //Salir.
                    System.out.println("Gracias por usar TraceIT.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        }while (i != 5); //No saldra del sistema hasta que introduzca el valor de 5.
    }
}