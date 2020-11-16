package Menus;

import EventsGestion.Location;
import EventsGestion.StatsManager;
import Exceptions.InputException;
import Util.Scanner;
import java.util.ArrayList;

public class StatsMenu {
    StatsManager statsManager = new StatsManager();
    Scanner scanner = new Scanner();

    public void Menu(Location location){
        int n = 0;
        do {
            System.out.println("1. Top 3 sintomas de la zona\n2. Brotes en la zona\n3. Volver al menu principal");
            n = scanner.getInt("Elija que operacion realizar.");
            switch (n){
                case 1:
                    System.out.println(statsManager.top3Symptoms(location));
                    break;
                case 2:
                    ArrayList<String[]> outbreaks = statsManager.biggestOutbreaks(location);
                    for (int i = 0; i < outbreaks.size(); i++) {
                        String[] line = outbreaks.get(i);
                        System.out.println("\n"+ i+1 + "." + "Sintoma: " + line[0] + "\nCiudadanos Afectados: " + line[1] + "\nUbicacion:" + line[2] + "\nFecha Reportada:" + line[3]);
                    }
                    break;
                case 3:
                    break;
                default:
                    try {
                        throw new InputException(81);
                    } catch (InputException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }while (n!=3);
    }

}
