package Util;
//Metodo sacado de la Practica1 de Prog2.
public class Date {
        int day;
        int month;
        public Date(int day, int month) {
            this.day = day;
            this.month = month;
        }
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

