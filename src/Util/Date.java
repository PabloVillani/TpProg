package Util;
//Metodo sacado de la Practica1 de Prog2.
public class Date {
        int hour;
        int day;
        int month;
        public Date(int hour, int day, int month) {
            this.hour = hour;
            this.day = day;
            this.month = month;
        }
        public int getHour() { return hour; }

        public void setHour() { this.hour = hour;}

        public int getDia() {
            return day;
        }

        public void setDia(int day) {
            this.day = day;
        }

        public int getMes() {
            return month;
        }

        public void setMes(int month) {
            this.month = month;
        }
}

