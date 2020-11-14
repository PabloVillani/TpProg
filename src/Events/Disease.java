package Events;

import java.util.ArrayList;

public class Disease {
    String nombre;
    ArrayList<Symptom> symptoms;

    public Disease(){}

    public Disease(String nombre, ArrayList<Symptom> symptoms){
        this.nombre = nombre;
        this.symptoms = symptoms;
    }

    public Disease coronavirus(){
        ArrayList<Symptom> symptoms = new ArrayList<>();
        symptoms.add(new Symptom("Fiebre"));
        symptoms.add(new Symptom("Tos seca"));
        symptoms.add((new Symptom("Cansancio")));
        symptoms.add((new Symptom("Dificultad para respirar")));
        symptoms.add((new Symptom("Perdida de olfato/gusto")));
        return new Disease("Coronavirus", symptoms);
    }

    public Disease sarampion(){
        ArrayList<Symptom> symptoms = new ArrayList<>();
        symptoms.add(new Symptom("Fiebre"));
        symptoms.add(new Symptom("Tos seca"));
        symptoms.add((new Symptom("Sarpullidos")));
        symptoms.add((new Symptom("Inflamacion en los ojos")));
        return new Disease("Sarampion", symptoms);
    }

    public Disease neumonia(){
        ArrayList<Symptom> symptoms = new ArrayList<>();
        symptoms.add(new Symptom("Fiebre"));
        symptoms.add(new Symptom("Tos con Flema"));
        symptoms.add((new Symptom("Escalofrios")));
        symptoms.add((new Symptom("Dificultad para respirar")));
        return new Disease("Neumonia", symptoms);
    }

}
