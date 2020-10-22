package Events;

import EventsGestion.Location;

import java.util.GregorianCalendar;

public class Encounter {
    String CUILsender;
    String CUILreceiver;
    GregorianCalendar start;
    GregorianCalendar end;
    Location location;
    public Encounter(String CUILsender, String CUILreceiver, GregorianCalendar start, GregorianCalendar end, Location location){
        this.CUILsender = CUILsender;
        this.CUILreceiver = CUILreceiver;
        this.start = start;
        this.end = end;
        this.location = location;
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

    public String GregorianCalendarToString(GregorianCalendar d){
        return d.toString();
    }
}
