package EventsGestion;

import Events.Symptom;
import Util.Scanner;
import Util.Writer;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class ABMSymptoms {
    ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
    Writer writer = new Writer();
    Scanner scanner = new Scanner();
    public ABMSymptoms() {
    }

    public void addSymptom(Symptom s) throws NullPointerException {
        symptoms.add(s);
        writer.singleValueWriter(s.getName(),"src/DataBase/ModificableBases/ActiveSymptoms.txt");
    }

    public void remove(Symptom s) throws IOException {
        symptoms.remove(s);
        writer.replace("src/DataBase/ModificableBases/ActiveSymptoms.txt",s.getName(), "-");

    }

    public void mod (Symptom s){
        symptoms.remove(s);
        String newName = scanner.getString("Elija el nuevo nombre del sintoma: ");
        writer.replace("src/DataBase/ModificableBases/ActiveSymptoms.txt", s.getName(), newName);
        s.setName(newName);
        symptoms.add(s);
    }
}
