package Events;

import Util.Date;

public class Encouter {
    String CUILsender;
    String CUILreceiver;
    Date start;
    Date end;

    public Encouter(String CUILsender, String CUILreceiver, Date start, Date end){
        this.CUILsender = CUILsender;
        this.CUILreceiver = CUILreceiver;
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
