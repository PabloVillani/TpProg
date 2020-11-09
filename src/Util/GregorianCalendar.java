package Util;

public class GregorianCalendar {
    Scanner scanner = new Scanner();
    ArrayMaker arrayMaker = new ArrayMaker();
    Integer year;
    Integer month;
    Integer day;
    Integer hour;
    Integer minute;
    Integer second;

    public GregorianCalendar(){}

    public GregorianCalendar(Integer year, Integer month, Integer day, Integer hour){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
    }

    public Integer getYear() {
       return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getHour() {
        return hour;
    }

    public GregorianCalendar dateGenerator(){
        Integer year;
        Integer month;
        Integer day;
        Integer hour;
        year = scanner.getInt("Introduzca el año: ");
        month = scanner.getInt("Introduzca el mes en numeros (enero = 0, diciembre = 11): ");
        month = validMonth(month);
        day = scanner.getInt("Introduzca el dia: ");
        day = validDay(month,day);
        hour = scanner.getInt("Introduzca la hora: ");
        hour = validHour(hour);
        return new GregorianCalendar(year,month,day,hour);
    }

    public Integer validMonth(Integer month){
        Integer month1 = month;
        if(month<0 || month>11){
            System.out.println("Mes invalido.");
            month1 = scanner.getInt("Introduzca el mes en numeros (enero = 0, diciembre = 11): ");
            validMonth(month1);
        }
        return month1;
    }

    public Integer validDay(Integer month, Integer day){
        Integer day1 = day;
        if((month == 2 && day > 29) || ((month == 4 || month == 6 || month == 9 || month == 11) && day>30) || ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day>31)){
            System.out.println("Fecha invalida.");
            day1 = scanner.getInt("Introduzca el dia: ");
        }
        return day1;
    }

    public Integer validHour(Integer hour){
        Integer hour1 = hour;
        if(hour < 0 || hour > 23){
            System.out.println("Hora invalida.");
            hour1 = scanner.getInt("Introduzca el dia");
        }
        return hour1;
    }

    public boolean endDateMatch(GregorianCalendar start, GregorianCalendar end){
        if(start.getYear() > end.getYear()){
            return false;
        }else if(start.getMonth() > end.getMonth()){
            return false;
        }else if(start.getDay() > end.getDay()){
            return false;
        }else if(start.getHour() > end.getHour()){
            return false;
        }else {
            return true;
        }
    }

    public String gCToString(GregorianCalendar gc){
        return gc.getDay() + "-" + gc.getMonth() + "-" + gc.getYear() + "~" + gc.getHour();
    }

    public GregorianCalendar stringToGc(String s){
        String[] dateArray = s.split("-");
        Integer day = Integer.parseInt(dateArray[0]);
        Integer month = Integer.parseInt(dateArray[1]);
        String[] hourArray = dateArray[2].split("~");
        Integer year = Integer.parseInt(hourArray[0]);
        Integer hour = Integer.parseInt(hourArray[1]);
        return new GregorianCalendar(year,month,day,hour);
    }
    public boolean fourtyEightHoursBetweenDates(GregorianCalendar gc1, GregorianCalendar gc2){
        if(gc1.getYear() > gc2.getYear() || gc1.getYear() < gc2.getYear()){
            return false;
        }
        if(gc1.getMonth() > gc2.getMonth() || gc1.getMonth() < gc2.getMonth()){
            return false;
        }
        return (gc1.getDay() - gc2.getDay()) <= 2 && endDateMatch(gc1, gc2);
    }
}
