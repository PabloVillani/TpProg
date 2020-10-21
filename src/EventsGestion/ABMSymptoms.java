package EventsGestion;

import Events.Symptom;
import Util.Replacer;
import Util.Scanner;
import Util.Writer;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class ABMSymptoms {
    static ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
    public ABMSymptoms(ArrayList<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public static void add(Symptom s) throws IOException {
        symptoms.add(s);
        Writer.singleValueWriter(s.getName(),"src/DataBase/ModificableBases/ActiveSymptoms.txt");
    }

    public static void remove(Symptom s) throws IOException {
        symptoms.remove(s);
        Replacer.replace("src/DataBase/ModificableBases/ActiveSymptoms.txt",s.getName(), "");
        FileChannel src = new FileInputStream("src/DataBase/ModificableBases/ActiveSymptoms.txt").getChannel();
        FileChannel dest = new FileOutputStream("src/DataBase/ModificableBases/ActiveSymptomsSupport.txt").getChannel();
        dest.transferFrom(src, 0, src.size());
        try (BufferedReader inputFile = new BufferedReader(new FileReader("src/DataBase/ModificableBases/ActiveSymptomsSupport.txt"));
             PrintWriter outputFile = new PrintWriter(new FileWriter("src/DataBase/ModificableBases/ActiveSymptoms.txt"))) {
             String lineOfText;
             while ((lineOfText = inputFile.readLine()) != null) {
                 lineOfText = lineOfText.trim();
                 if (!lineOfText.isEmpty()) {
                     outputFile.println(lineOfText);
                 }
             }
        }
    }

    public void mod (Symptom s){
        symptoms.remove(s);
        String newName = Scanner.getString("Eliga el nuevo nombre del sintoma: ");
        Replacer.replace("src/DataBase/ModificableBases/ActiveSymptoms.txt", s.getName(), newName);
        s.setName(newName);
        symptoms.add(s);
    }
}
