package UserGestion;

import Citizen.Citizen;
import Exceptions.InputException;
import Util.ArrayMaker;
import Util.Finder;
import Util.Scanner;
import Util.Writer;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class ConfirmContact {
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    Scanner scanner = new Scanner();
    Writer writer = new Writer();
    public ConfirmContact(){}
    public void confirmContact(Citizen c){
        ArrayList<String[]> awaitingContacts = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/AwaitingContacts.txt");
        if(finder.singleValueFinderArray(c.getCuil(), awaitingContacts, 1)) {
            int index = finder.indexOf(c.getCuil(), awaitingContacts, 1);
            String[] invite = awaitingContacts.get(index);
            String cuilSender = invite[0];
            String cuilReceiver = c.getCuil();
            String startDate = invite[2];
            String endDate = invite[3];
            String location = invite[4];
            System.out.println("CUIL del emisor: " + cuilSender + "\nTu Cuil: " + cuilReceiver + "\nFecha de inicio: " + startDate + "\nFecha de fin: " + endDate + "\nUbicacion: " + location);
            int i = scanner.getInt("Este contacto existio?\n1. Si\n2. No\n");
            if (i == 1) {
                writer.fiveValueWriter(cuilSender, cuilReceiver, startDate, endDate, location, "src/DataBase/ModificableBases/ConfirmedContacts.txt");
                writer.replace("src/DataBase/ModificableBases/AwaitingContacts.txt", cuilSender + "," + cuilReceiver + "," + startDate + "," + endDate + "," + location, "");
                FileChannel src = null;
                try {
                    src = new FileInputStream("src/DataBase/ModificableBases/AwaitingContacts.txt").getChannel();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FileChannel dest = null;
                try {
                    dest = new FileOutputStream("src/DataBase/ModificableBases/AwaitingContactSupport.txt").getChannel();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    dest.transferFrom(src, 0, src.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedReader inputFile = new BufferedReader(new FileReader("src/DataBase/ModificableBases/AwaitingContactSupport.txt"));
                     PrintWriter outputFile = new PrintWriter(new FileWriter("src/DataBase/ModificableBases/AwaitingContacts.txt"))) {
                    String lineOfText;
                    while ((lineOfText = inputFile.readLine()) != null) {
                        lineOfText = lineOfText.trim();
                        if (!lineOfText.isEmpty()) {
                            outputFile.println(lineOfText);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (i == 2) {
                ArrayList<String[]> rejectedReq = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/RejectedRequests.txt");
                if (finder.doubleValueFinder(cuilSender, "0", rejectedReq)) {
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt", cuilSender + ",0", cuilSender + ",1");
                }
                if (finder.doubleValueFinder(cuilSender, "1", rejectedReq)) {
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt", cuilSender + ",1", cuilSender + ",2");
                }
                if (finder.doubleValueFinder(cuilSender, "2", rejectedReq)) {
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt", cuilSender + ",3", cuilSender + ",4");
                }
                if (finder.doubleValueFinder(cuilSender, "3", rejectedReq)) {
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt", cuilSender + ",3", cuilSender + ",4");
                }
                if (finder.doubleValueFinder(cuilSender, "4", rejectedReq)) {
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt", cuilSender + ",4", cuilSender + ",5");
                }
                writer.replace("src/DataBase/ModificableBases/AwaitingContacts.txt", cuilSender + "," + cuilReceiver + "," + startDate + "," + endDate + "," + location, "");
                FileChannel src = null;
                try {
                    src = new FileInputStream("src/DataBase/ModificableBases/AwaitingContacts.txt").getChannel();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FileChannel dest = null;
                try {
                    dest = new FileOutputStream("src/DataBase/ModificableBases/AwaitingContactSupport.txt").getChannel();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    dest.transferFrom(src, 0, src.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedReader inputFile = new BufferedReader(new FileReader("src/DataBase/ModificableBases/AwaitingContactSupport.txt"));
                     PrintWriter outputFile = new PrintWriter(new FileWriter("src/DataBase/ModificableBases/AwaitingContacts.txt"))) {
                    String lineOfText;
                    while ((lineOfText = inputFile.readLine()) != null) {
                        lineOfText = lineOfText.trim();
                        if (!lineOfText.isEmpty()) {
                            outputFile.println(lineOfText);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(i != 1 && !(i == 2)){
                try {
                    throw new InputException(81);
                } catch (InputException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
