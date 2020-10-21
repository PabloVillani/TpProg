package Util;

import Events.Symptom;

import java.sql.SQLOutput;

//Metodo sacado de la Practica1 de Prog2.
public class Date {
    int year;
    int hour;
    int day;
    int month;
    public Date(int hour, int day, int month, int year) {
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getHour() { return hour; }

    public void setHour() { this.hour = hour;}

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
            this.month = month;
    }

    public int getYear() {
        return year;
    }

    public static Date dateGenerator(){
            int year;
            int month;
            int day;
            int hour;
            year = Scanner.getInt("Introduzca el año: ");
            month = Scanner.getInt("Introduzca el mes en numeros");
            month = validMonth(month);
            day = Scanner.getInt("Introduzca el dia");
            day = validDay(month,day);
            hour = Scanner.getInt("Introduzca la hora");
            hour = validHour(hour);
            return new Date(hour,day,month,year);
    }
    public static int validMonth(int month){
        int month1 = month;
        if(month<1 || month>12){
            month1 = Scanner.getInt("Introduzca el mes en numeros");
            validMonth(month1);
        }
        return month1;
    }
    public static int validDay(int month, int day){
        int day1 = day;
        if((month == 2 && day > 29) || ((month == 4 || month == 6 || month == 9 || month == 11) && day>30) || ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day>31)){
            System.out.println("Fecha invalida");
            day1 = Scanner.getInt("Introduzca el dia");
        }
        return day1;
    }
    public static int validHour(int hour){
        int hour1 = hour;
        if(hour < 0 || hour > 23){
            System.out.println("Hora invalida");
            hour1 = Scanner.getInt("Introduzca el dia");
        }
        return hour1;
    }
}

