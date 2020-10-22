package Events;

import EventsGestion.Location;
import java.util.GregorianCalendar;
import Util.Scanner;

public class Invite {
    Scanner scanner = new Scanner();
    String CUILsender;
    String CUILreceiver;
    GregorianCalendar start;
    GregorianCalendar end;
    Location location;
    String locationName;
    public Invite(){}
    public Invite(String CUILsender, String CUILreceiver, GregorianCalendar start, GregorianCalendar end, String locationName){
        this.CUILsender = CUILsender;
        this.CUILreceiver = CUILreceiver;
        this.start = start;
        this.end = end;
        this.locationName = locationName;
    }

    public GregorianCalendar getStart() {
        return start;
    }

    public void setStart(GregorianCalendar start) {
        this.start = start;
    }

    public GregorianCalendar getEnd() {
        return end;
    }

    public void setEnd(GregorianCalendar end) {
        this.end = end;
    }



}