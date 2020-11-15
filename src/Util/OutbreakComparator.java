package Util;

import Events.Outbreak;

import java.util.ArrayList;
import java.util.Comparator;

public class OutbreakComparator implements Comparator<String[]> {

    ArrayList<String[]> outbreaks = new ArrayList<>();

    public OutbreakComparator(ArrayList<String[]> outbreaks) {
        this.outbreaks = outbreaks;
    }

    @Override
    public int compare(String[] o1, String[] o2) {
        return o2[1].compareTo(o1[1]);
    }
}
