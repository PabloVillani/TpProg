package UserGestion;

import Citizen.Citizen;
import Util.ArrayMaker;
import Util.Finder;
import Util.Scanner;
import Util.Writer;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;

public class ConfirmContact {
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    Scanner scanner = new Scanner();
    Writer writer = new Writer();
    public ConfirmContact(){}
    public void ConfirmContact(Citizen c) throws IOException {
        ArrayList<String[]> awaitingContacts = arrayMaker.quintupleStringMaker("src/DataBase/ModificableBases/AwaitingContacts.txt");
        if(finder.singleValueFinderArray(c.getCuil(), awaitingContacts, 1)){
            int index = finder.indexOf(c.getCuil(),awaitingContacts);
            String[] invite = awaitingContacts.get(index);
            String cuilSender = invite[0];
            String cuilReceiver = c.getCuil();
            String startDate = invite[2];
            String endDate = invite[3];
            String location = invite[4];
            System.out.println("CUIL del emisor: " +cuilSender+ "\nTu Cuil: " +cuilReceiver+"\nFecha de inicio: " + startDate + "\nFecha de fin: " + endDate + "\nUbicacion: " + location);
            int i = scanner.getInt("Este contacto existio?\n1. Si\n2. No\n");
            if(i == 1){
                writer.fiveValueWriter(cuilSender,cuilReceiver,startDate,endDate,location, "src/DataBase/ModificableBases/ConfirmedContacts.txt");
                writer.replace("src/DataBase/ModificableBases/AwaitingContacts.txt", cuilSender + "," + cuilReceiver + "," + startDate + "," + endDate + "," + location,"");
                FileChannel src = new FileInputStream("src/DataBase/ModificableBases/AwaitingContacts.txt").getChannel();
                FileChannel dest = new FileOutputStream("src/DataBase/ModificableBases/AwaitingContactSupport.txt").getChannel();
                dest.transferFrom(src, 0, src.size());
                try (BufferedReader inputFile = new BufferedReader(new FileReader("src/DataBase/ModificableBases/AwaitingContactSupport.txt"));
                     PrintWriter outputFile = new PrintWriter(new FileWriter("src/DataBase/ModificableBases/AwaitingContacts.txt"))) {
                    String lineOfText;
                    while ((lineOfText = inputFile.readLine()) != null) {
                        lineOfText = lineOfText.trim();
                        if (!lineOfText.isEmpty()) {
                            outputFile.println(lineOfText);
                        }
                    }
                }
            }if(i == 2){
                ArrayList<String[]> rejectedReq = arrayMaker.doubleStringMaker("src/DataBase/ModificableBases/RejectedRequests.txt");
                if(finder.doubleValueFinder(cuilSender,"0",rejectedReq)){
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt",cuilSender+",0",cuilSender+",1");
                }if(finder.doubleValueFinder(cuilSender,"1",rejectedReq)){
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt",cuilSender+",1",cuilSender+",2");
                }if(finder.doubleValueFinder(cuilSender,"2",rejectedReq)){
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt",cuilSender+",3",cuilSender+",4");
                }if(finder.doubleValueFinder(cuilSender,"3",rejectedReq)){
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt",cuilSender+",3",cuilSender+",4");
                }if(finder.doubleValueFinder(cuilSender,"4",rejectedReq)){
                    writer.replace("src/DataBase/ModificableBases/RejectedRequests.txt",cuilSender+",4",cuilSender+",5");
                }
            }
        }

    }
}
