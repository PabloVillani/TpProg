package Events;

import java.util.GregorianCalendar;

public class Invite {
    String CUILsender;
    String CUILreceiver;
    GregorianCalendar start;
    GregorianCalendar end;

    public Invite(String CUILsender, String CUILreceiver, GregorianCalendar start, GregorianCalendar end){
        this.CUILsender = CUILsender;
        this.CUILreceiver = CUILreceiver;
        this.start = start;
        this.end = end;
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