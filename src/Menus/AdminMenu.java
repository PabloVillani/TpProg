package Menus;

import Admin.Admin;
import EventsGestion.Location;
import Exceptions.InputException;
import Util.ArrayMaker;
import Util.Finder;
import Util.Scanner;

import java.time.LocalDateTime;
import java.util.List;

//Despliega el menu del administrador en el Main.
public class AdminMenu {
    Admin admin = new Admin();
    Scanner scanner = new Scanner();
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    StatsMenu statsMenu = new StatsMenu();
    Location location = new Location();
    public void Menu() {
        int i = 0;
        do { //Presenta las opciones a realizar:
            System.out.println("1. Activar sintoma\n2. Desactivar sintoma\n3. Desbloquear usuario\n4. Estadisticas\n5. Cerrar sesion.");
            i = scanner.getInt("Que operacion desea realizar?:"); //Pregunta que opcion realizar
            switch (i) {
                case 1:  //Activar sintoma.
                    List<String> symptoms = arrayMaker.singleStringMaker("src/DataBase/PreexistingBases/SymptomsBase.txt");
                    for (int j = 0; j < symptoms.size(); j++) {
                        System.out.println(symptoms.get(j));
                    }
                    String symptom = scanner.getString("Introduzca el nombre del sintoma: ");
                    List<String> symptoms6 = arrayMaker.singleStringMaker("src/DataBase/ModificableBases/ActiveSymptoms.txt");
                    if(!finder.singleValueFinder(symptom, symptoms)){
                        System.out.println("El sintoma no existe.");
                    }if(finder.singleValueFinder(symptom, symptoms6)) {
                        System.out.println("Este sintoma ya esta activo.");
                    }else{
                        admin.activateSymptom(symptom);
                    }
                    break;
                case 2: //Desactivar sintomas.
                    List<String> symptoms2 = arrayMaker.singleStringMaker("src/DataBase/ModificableBases/ActiveSymptoms.txt");
                    for (int j = 0; j < symptoms2.size(); j++) {
                        if(symptoms2.get(i) != ""){
                            System.out.println(symptoms2.get(j));
                        }
                    }
                    String symptom2 = scanner.getString("Introduzca el nombre del sintoma a eliminar: ");
                    if(!finder.singleValueFinder(symptom2, symptoms2)){
                        System.out.println("El sintoma no existe");
                    }else{
                        admin.deactivateSymptom(symptom2);
                    }
                    break;
                case 3: //Desbloquear usuario
                    String cuil = scanner.getString("Introduzca el CUIL del ciudadano: ");
                    if(finder.singleValueFinder(cuil, arrayMaker.singleStringMaker("src/DataBase/ModificableBases/CuilOnlyDataBase.txt"))){
                        admin.unlock(cuil);
                    }else{
                        System.out.println("El ciudadano no existe.");
                    }
                    break;
                case 4: //Estadisticas
                    System.out.println("Ubicaciones a analizar");
                    Location location2 = new Location(location.locationChooser());
                    statsMenu.Menu(location2);
                    break;
                case 5:  //Salir.
                    System.out.println("Gracias por usar TraceIT.");
                    break;
                default:
                    try {
                        throw new InputException(81);
                    } catch (InputException e) {
                        e.printStackTrace();
                    }
                    break;
            }

        }while (i != 5); //No saldra del sistema hasta que introduzca el valor de 4.
    }
}