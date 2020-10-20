package Admin;

import Citizen.Citizen;
//Objeto de admin, con sus capacidades de trabajo.
public class Admin  {
    String user;
    String password;
    boolean superAdmin;

    public Admin(String user, String password){
        this.password = password;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public void unLock(Citizen c) { //Desbloquea el usuario.
        c.setBlocked(false);
    }

    public void symptomRelease() { } //Dar de baja sintomas

    public void notifySymptom() { } //Agrega-Notifica sintomas


}
